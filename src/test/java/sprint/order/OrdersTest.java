package sprint.courier.order;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.Orders;
import org.junit.Assert;
import org.junit.Test;
import steps.Steps;

public class OrdersTest {
    private final Steps steps = new Steps();

    @Test
    @DisplayName("Список заказов - В тело ответа возвращается список заказов")
    public void ordersReturnsOrderList() {
        Response response = steps.orders();
        Assert.assertNotNull("В тело ответа возвращается список заказов",
                response.as(Orders.class).getOrders());
    }
}
