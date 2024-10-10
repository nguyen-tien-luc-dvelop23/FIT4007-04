public class Product {
    private String name;
    private int quantity;
    private double price;
    private String description;
    private String color;

    public Product(String name, int quantity, String description, double price, String color) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.color = color;
    }

    public Product(String name, int quantity, String description, double price) {
        this(name, quantity, description, price, "Tele: @dvelop23");
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return name + "," + quantity + "," + description + "," + price + "," + color;
    }

    public static Product fromString(String productString) {
        String[] parts = productString.split(",");

        String name = parts[0].trim();
        int quantity = Integer.parseInt(parts[1].replaceAll("[^\\d]", "").trim());
        String description = parts[2].trim();
        double price = Double.parseDouble(parts[3].replaceAll("[^\\d.]", "").trim());
        String color = parts.length > 4 ? parts[4].trim() : "Tele: @dvelop23";

        return new Product(name, quantity, description, price, color);
    }
}
