package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private static int nextId = 1;

    private final int id;
    private final List<OrderItem> items;

    public Order() {
        this.id = nextId;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addItem(OrderItem item) {
        if (item != null && item.isValid()) {
            items.add(item);
            System.out.println("Item added: " + item.getName());
        } else {
            System.out.println("Invalid item. Item was not added.");
        }
    }

    public double getTotal() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }

        return total;
    }

    public void printOrder() {
        System.out.println("\nOrder #" + id);

        for (OrderItem item : items) {
            System.out.println(item);
        }

        System.out.println("Total: " + getTotal());
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

}
