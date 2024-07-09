package tests;

import factory.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pageObject.Constants;
import pageObject.UserRegistration;

import java.util.Random;

public class UserIncorrectRegistrationTest {
    public int random5Numbers() {
        return new Random().nextInt(89999)+10000;
    }

    String name = Constants.DEFAULT_NAME + random5Numbers();
    String email = random5Numbers() + Constants.DEFAULT_EMAIL;
    String password = String.valueOf(random5Numbers());

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    @DisplayName("Регистрация")
    @Description("Получение ошибки при некорректном пароле.Минимальный пароль — шесть символов.")
    public void unsuccessfulRegistration () {

        //регистрация нового пользователя, проверка регистрации
        new UserRegistration(driverFactory.getDriver())
                .userRegistration(name, email, password)
                .checkUnsuccessfulRegistration();
    }
}
