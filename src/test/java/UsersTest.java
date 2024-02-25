import Utils.ApiWrapper;
import Utils.TestDataHelper;
import org.example.NewUser;
import org.junit.jupiter.api.Test;
import static Utils.ApiWrapper.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTest extends RestassureBaseTest {

    @Test
    public void getListOfObjects() {
        sendGetRequest(
                getConfig("fullPath_v2"))
                .assertThat()
                .body("$", hasSize(10)
                );
    }

    @Test
    public void getParamOfUsers() {
        String page = "5";
        String perPage = "50";

        sendGetRequest(
                given().pathParams("page", page,
                        "perPage", perPage),
                        (getConfig("resourcesPath_v2")
                        + getConfig("endPointUsers")
                        + "?page={page}&per_page={perPage}")
        )
                .assertThat()
                .body("$", hasSize(Integer.parseInt(perPage)));
    }


    @Test
    public void schemeUserValidate() {
        int userId = getID("endPointUsers", "id");
        sendGetRequest(
                given().pathParams("id", userId),
                getConfig("resourcesPath_v2")
                        + getConfig("objectIdPath")
        )
                .assertThat()
                .body(matchesJsonSchemaInClasspath("user-schema.json"));
    }

    @Test
    public void CreateNewUsers() {

      NewUser newUser = TestDataHelper.createUser();
      NewUser  actualUser =
          ApiWrapper.sendPostRequest(
                getConfig("fullPath_v2"),
                newUser,
                NewUser.class
          );

      assertEquals(actualUser, newUser);
    }

    @Test
    public void deleteUser() {

        int userId = getID("endPointUsers", "id");

        deleteRequest(
                given().pathParams("id", userId),
                getConfig("resourcesPath_v2")
                        + getConfig("objectIdPath")
        );
    }
}


