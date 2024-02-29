import Utils.ApiWrapper;
import Utils.TestDataHelper;
import org.example.NewUser;
import org.example.Post;
import org.junit.jupiter.api.Test;
import static Utils.ApiWrapper.*;
import static Utils.ApiWrapper.deleteRequest;
import static Utils.ApiWrapper.sendPatchRequest;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTest extends RestassureBaseTest {

    @Test
    public void schemePostValidationTest() {
        int postUserId = getID("userPostPath", "user_id");

        sendGetRequest(
                given().pathParams("id", postUserId),
                getConfig("resourcesPath_v2")
                        + getConfig("objectIdPath")
                        + getConfig("userPostPath")
        )
                .assertThat()
                .body(matchesJsonSchemaInClasspath("post-schema.json"));
    }

    @Test
    public void getParamOfPosts() {
        String page = "5";
        String perPage = "70";

        sendGetRequest(
                given().pathParams("page", page,
                        "perPage", perPage),
                getConfig("resourcesPath_v2")
                        + getConfig("userPostPath")
                        + "?page={page}&per_page={perPage}"
        )
                .assertThat()
                .body("$", hasSize(Integer.parseInt(perPage)));
    }


    @Test
    public void newPostCreate() {
        int postUserId = getID("userPostPath", "user_id");

        Post newPost = TestDataHelper.createPost(postUserId);
        Post actualPost =
                ApiWrapper.sendPostRequest(
                        given().pathParams("id", postUserId),
                        getConfig("resourcesPath_v2")
                                + getConfig("objectIdPath")
                                + getConfig("userPostPath"),
                        newPost,
                        Post.class
                );

        assertEquals(actualPost, newPost);
    }

    @Test
    public void deletePost() {

        int postId = getID("userPostPath", "id");

        deleteRequest(
                given().pathParams("id", postId),
                getConfig("resourcesPath_v2")
                        + getConfig("userPostIDPath")
        );
    }

    @Test
    public void patchTitlePost() {

        int postId = getID("userPostPath", "id");

        String nameCreateField = "title";
        String textCreateField = "Silvija";

        sendPatchRequest(
                given().pathParams("id", postId),
                nameCreateField,
                textCreateField,
                getConfig("resourcesPath_v2")
                        + getConfig("userPostIDPath")
        );
    }
    @Test
    public void putTitlePost() {

        int userId = getID("userPostPath", "user_id");
        int id = getID("userPostPath", "id");

       Post newMessagePost = TestDataHelper.createPost(id);
        newMessagePost.setUserId(userId);
        newMessagePost.setTitle("Silvija");


        Post actualPost =
                ApiWrapper.sendPutRequest(
                        given().pathParams("id", id),
                        getConfig("resourcesPath_v2")
                                + getConfig("userPostIDPath"),
                        newMessagePost,
                        Post.class
                );
        assertEquals(actualPost, newMessagePost);
    }
}