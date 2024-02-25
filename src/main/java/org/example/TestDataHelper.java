package org.example;
import org.example.UserTemplate;
import javax.xml.crypto.Data;
import static java.time.LocalDateTime.now;


public class TestDataHelper {

    public static UserTemplate createUser() {
        UserTemplate newUser = new UserTemplate();
        newUser.setName("Bali San Mali");
        newUser.setEmail("bali_san_mali@dmx.com");
        newUser.setGender("man");
        newUser.setStatus("active");

        return newUser;
    }
}
