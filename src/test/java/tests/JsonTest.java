package tests;

import common.JsonUtils;
import data.Credential;

import java.util.Collection;

public class JsonTest {
    public static void main(String[] args) {
        Collection<Credential> data = JsonUtils.getCollection("src/test/resources/data/credential.json", Credential.class);
        data.forEach(System.out::println);
    }
}
