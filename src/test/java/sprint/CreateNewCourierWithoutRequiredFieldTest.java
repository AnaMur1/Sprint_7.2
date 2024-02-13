package sprint.courier;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.CourierAccount;
import org.junit.Assert;
import steps.Steps;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CreateNewCourierWithoutRequiredFieldTest {
    private final Faker faker = new Faker(new Locale("en"));
    private final Steps steps = new Steps();
    private CourierAccount account;
    private List<CourierAccount> testData;

    @Before
    public void setUp() {
        testData = new ArrayList<>();
        account = new CourierAccount(
                faker.funnyName().name(),
                faker.internet().password(),
                faker.name().firstName());
        testData.add(account);
    }

    @Test
    @DisplayName("Создание курьера - если одного из полей нет, запрос возвращает ошибку")
    public void createFieldlessReturnsError() {
        account = new CourierAccount();
        testData.add(account);
        account.setLogin(faker.funnyName().name());
        account.setFirstName(faker.name().firstName());
        Assert.assertEquals("Пароль обязательное поле, ждем 400 код",
                steps.create(account).extract().statusCode(),
                HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @DisplayName("Создание курьера - если одного из полей нет, запрос возвращает ошибку")
    public void createFieldlessReturnsError2() {
        account = new CourierAccount();
        testData.add(account);
        account.setPassword(faker.internet().password());
        account.setFirstName(faker.name().firstName());
        Assert.assertEquals("Логин обязательное поле, ждем 400 код",
                steps.create(account).extract().statusCode(),
                HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @DisplayName("Создание курьера - если одного из полей нет, запрос возвращает ошибку")
    @Description("У портала баг. Принимает создание пользователя без firstName")
    public void createFieldlessReturnsError3() {
        account = new CourierAccount();
        testData.add(account);
        account.setLogin(faker.funnyName().name());
        account.setPassword(faker.internet().password());
        Assert.assertEquals("Имя обязательное поле, ждем 400 код",
                steps.create(account).extract().statusCode(),
                HttpStatus.SC_BAD_REQUEST);
    }

    @After
    public void cleanUp() {
        steps.delete(testData);
    }
}
