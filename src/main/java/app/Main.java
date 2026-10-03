package app;

import domain.Order;
import domain.OrderItem;


public class Main {
    static void main() {

        Order order = new Order();

        OrderItem item1 = new OrderItem("Keyboard", 1200, 1);
        OrderItem item2 = new OrderItem("Mouse", 500, 2);
        OrderItem item3 = new OrderItem("USB Cable", 200);

        order.addItem(item1);
        order.addItem(item2);
        order.addItem(item3);

        order.printOrder();

        System.out.println("\nChanging quantity...");

        OrderItem invalidItem = new OrderItem("Broken item", -10, 1);

        order.addItem(invalidItem);

        System.out.println("\nTrying to modify items list directly...");

        try {
            order.getItems().clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("External modification is bloked.");
        }

        order.printOrder();

    }
}
