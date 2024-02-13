package sprint.courier.login;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import model.CourierAccount;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import steps.Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LoginSuccessReturnIdTest {

    private final Faker faker = new Faker(new Locale("en"));
    private final Steps steps = new Steps();
    private CourierAccount account;
    private List<CourierAccount> testData;

    @Before
    public void setUp() {
        testData = new ArrayList<>();
        account = new CourierAccount(faker.funnyName().name(), faker.internet().password(), faker.name().firstName());
        testData.add(account);
    }

    @Test
    @DisplayName("Успешный запрос возвращает id")
    public void loginSuccessReturnId() {
        steps.create(account);
        ValidatableResponse response = steps.login(account);

        Assert.assertNotNull("Успешный запрос возвращает \"id\": int",
                response.extract().body().jsonPath().get("id"));
    }

    @After
    public void cleanUp() {
        steps.delete(testData);
    }
}
