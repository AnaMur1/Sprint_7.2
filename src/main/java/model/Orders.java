package model;

import java.util.List;

public class Orders {
    private List<OrdersItem> orders;
    private PageInfo pageInfo;
    private List<Station> availableStations;

    public List<OrdersItem> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersItem> orders) {
        this.orders = orders;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Station> getAvailableStations() {
        return availableStations;
    }

    public void setAvailableStations(List<Station> availableStations) {
        this.availableStations = availableStations;
    }

    public Orders(List<OrdersItem> orders, PageInfo pageInfo, List<Station> availableStations) {
        this.orders = orders;
        this.pageInfo = pageInfo;
        this.availableStations = availableStations;
    }

    public Orders() {
    }
}
