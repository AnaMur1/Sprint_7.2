package sprint.courier;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import model.CourierAccount;
import org.junit.Assert;
import steps.Steps;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import java.util.Locale;

public class CreateTwoIdenticalCourierTest {
    private final Faker faker = new Faker(new Locale("en"));
    private final Steps steps = new Steps();
    private CourierAccount account;

    @Before
    public void setUp() {
        account = new CourierAccount(
                faker.funnyName().name(),
                faker.internet().password(),
                faker.name().firstName());
    }

    @Test
    @DisplayName("Создание курьера - нельзя создать двух одинаковых курьеров")
    public void createIdenticalAccountsForbidden() {
        ValidatableResponse createFirst = steps.create(account);
        int firstStatusCode = createFirst.extract().statusCode();

        ValidatableResponse createSecond = steps.create(account);
        int secondStatusCode = createSecond.extract().statusCode();
        Assert.assertNotEquals("Статус код не должен быть 201",
                secondStatusCode,
                HttpStatus.SC_CREATED);
    }
}
