package sprint.courier;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
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

public class CreateNewCourierTest {
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
    @DisplayName("Создание курьера - курьера можно создать")
    public void createNewCourierReturnSC_CREATED() {
        ValidatableResponse response = steps.create(account);
        Assert.assertEquals("Ждём 201",
                response.extract().statusCode(),
                HttpStatus.SC_CREATED);
    }

    @After
    public void cleanUp() {
        steps.delete(testData);
    }
}
