import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RestassureBaseTest {
    protected static Properties properties;


    @BeforeAll
    public static void globalSetUp() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = getConfig("baseURI");
        RestAssured.filters(new AllureRestAssured());
    }

    public   static int getID(String endPoint, String nameId) {
        String path = "[5]." + nameId;
        return
                given()
                        .when()
                        .get(getConfig("resourcesPath_v2") +
                                getConfig(endPoint))
                        .then()
                        .statusCode(200)
                        .log().ifValidationFails()
                        .extract()
                        .jsonPath()
                        .getInt(path);
    }

    public static String getConfig(String key) {
        return properties.getProperty(key);
    }

    @AfterEach
    public void tearDown() {
        RestAssured.reset();
    }
}
