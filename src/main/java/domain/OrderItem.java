package domain;

public class OrderItem {

    private static int nextId = 1;

    private final int id;
    private final String name;

    private double price;
    private int quantity;

    public OrderItem(String name, double price, int quantity) {
        this.id = nextId++;
        this.name = name;

        setPrice(price);
        setQuantity(quantity);
    }

    public OrderItem(String name, double price) {
        this(name, price, 1);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    boolean isValid() {
        return name != null
                && !name.isBlank()
                && price > 0
                &&  quantity > 0;
    }

    @Override
    public String toString(){
        return "#" + id
                + " " + name
                + " | price: " + price
                + " | quantity: " + quantity
                + " | total: " + getTotalPrice();
    }
}
