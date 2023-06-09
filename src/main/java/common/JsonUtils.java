package common;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Collection;

public class JsonUtils {
    public static <T> Collection<T> getCollection(String relativePath, Class<T> clazz) {
        Collection<T> collection;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType typeOfT = mapper.getTypeFactory().constructCollectionType(Collection.class, clazz);
            collection = mapper.readValue(new File(relativePath), typeOfT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return collection;
    }
}
