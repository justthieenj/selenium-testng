package tests;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.UserData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class ReadUserDataTest {
    @Test(dataProvider = "getData")
    public void loginTest(UserData userData) {
        System.out.println("Login test");
        System.out.println(userData.getEmail());
    }

    @DataProvider
    public Object[] getData() {
        return readUserData().toArray();
    }

    public List<UserData> readUserData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String filePath = new File("src/test/resources/data/userdata.json").getAbsolutePath();
            JavaType typeOfT = mapper.getTypeFactory().constructCollectionType(Collection.class, UserData.class);
            return mapper.readValue(new File(filePath), typeOfT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
