package Utils;
import org.example.NewUser;
import javax.xml.crypto.Data;
import static java.time.LocalDateTime.now;


public class TestDataHelper {

    public static NewUser createUser() {
        NewUser newObject = new NewUser();
        newObject.getID();
        newObject.setName("Bali San Mali");
        newObject.setEmail("bali_san_mali@dmx.com");
        newObject.setGender("man");
        newObject.setStatus("active");
        return newObject;
    }
}
