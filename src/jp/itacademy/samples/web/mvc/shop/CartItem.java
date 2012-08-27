package jp.itacademy.samples.web.mvc.shop;

public class CartItem {

    private Item item;
    private int quantity;

    public CartItem(Item item) {
        this.item = item;
    }

    public int getId() {
        return item.getId();
    }

    public String getName() {
        return item.getName();
    }

    public int getPrice() {
        return item.getPrice();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void inc() {
        quantity++;
    }
}
