package models;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    static Faker faker = new Faker();
    String name;
    String email;
    String password;
    String incorrectPassword;

    // фабрика
    public static User getRandom() {
        String name = faker.name().name();
        String email = faker.name().username() + "@yandex.ru";
        String password = RandomStringUtils.randomAlphanumeric(6);
        String incorrectPassword = RandomStringUtils.randomAlphanumeric(5);
        return new User(name, email, password, incorrectPassword);
    }
}
