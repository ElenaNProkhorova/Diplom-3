package tests;

import factory.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pageObject.Constants;
import pageObject.UserRegistration;
import userApiEditor.DeleteUser;

import java.util.Random;

@DisplayName("Регистрация")
public class UserRegistrationTest {
    public int random5Numbers() {
        return new Random().nextInt(89999)+10000;
    }

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    @DisplayName("Регистрация")
    @Description("Успешная регистрация")
    public void successfulRegistration () {
        String name = Constants.DEFAULT_NAME + random5Numbers();
        String email = random5Numbers() + Constants.DEFAULT_EMAIL;
        String password = Constants.DEFAULT_PASSWORD;

        //регистрация нового пользователя, проверка регистрации
        new UserRegistration(driverFactory.getDriver())
                .userRegistration(name, email, password)
                .checkSuccessfulRegistration();

        //удаление нового пользователя
        new DeleteUser().deleteCreatedUser(email, password);
    }

    @Test
    @DisplayName("Регистрация")
    @Description("Получение ошибки при некорректном пароле. Минимальный пароль — шесть символов.")
    public void unsuccessfulRegistration () {
        String name = Constants.DEFAULT_NAME + random5Numbers();
        String email = random5Numbers() + Constants.DEFAULT_EMAIL;
        String password = String.valueOf(random5Numbers());

        //регистрация нового пользователя, проверка регистрации
        new UserRegistration(driverFactory.getDriver())
                .userRegistration(name, email, password)
                .checkUnsuccessfulRegistration();
    }
}
