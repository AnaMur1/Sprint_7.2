package sprint.courier.courier;

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

public class CreateNewCourierReturnBodyWithOkTest {
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
    @DisplayName("Создание курьера - успешный запрос возвращает ok: true")
    public void createNewCourierReturnBodyWithOk() {
        ValidatableResponse response = steps.create(account);
        boolean actualResult = response.extract().body().jsonPath().getBoolean("ok");
        Assert.assertTrue("Ожидаем что успешный запрос возвращает ok", actualResult);
    }

    @After
    public void cleanUp() {
        steps.delete(testData);
    }
}
