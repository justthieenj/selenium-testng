package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Attribute {
    id("id"), name("name"), className("class"), href("href"), value("value");

    private final String val;
}
