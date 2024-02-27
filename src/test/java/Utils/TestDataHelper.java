package Utils;
import com.github.javafaker.Faker;
import org.example.NewUser;
import org.example.Post;

import javax.xml.crypto.Data;
import static java.time.LocalDateTime.now;


public class TestDataHelper {
    static Faker faker = new Faker();

    public static NewUser createUser() {
        NewUser randomUser = new NewUser();
        randomUser.setName(faker.name().firstName() + faker.name().lastName() + now());
        randomUser.setEmail(faker.internet().emailAddress());
        randomUser.setGender((faker.demographic().sex()).toLowerCase());
        randomUser.setStatus(faker.random().nextBoolean() ? "active" : "inactive");

        return randomUser;
    }
    public static Post createPost(int userID) {
        Post post = new Post();
        post.setUserId(userID);
        post.setTitle(faker.lorem().sentence(faker.random().nextInt(3, 5)));
        post.setBody(faker.lorem().sentence(faker.random().nextInt(11, 18)));

        return post;
    }
}