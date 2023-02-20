package stock;

import java.util.Objects;

public class Product {
    private String productName;
    private double price;
    private int quantity;
    private int id;


    public Product(String productName, double price, int quantity) {
        if (productName.length() > 30 ||
                String.valueOf(price).length() > 8 ||
                String.valueOf(quantity).length() > 4) {
            throw new IllegalArgumentException();
        }
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        if (productName.length() > 30) {
            throw new IllegalArgumentException();
        }
        this.productName = productName;
    }

    public void setPrice(double price) {
        if (String.valueOf(price).length() > 6) {
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (String.valueOf(quantity).length() > 4) {
            throw new IllegalArgumentException();
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %s, Quantity: %s", productName, price, quantity);
    }

    public String toDbFormat(Integer id) {
        return String.format("%-8d%-30s%-8s%-4d", id, getProductName(), getPrice(), getQuantity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
