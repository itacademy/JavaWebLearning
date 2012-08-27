package jp.itacademy.samples.web.mvc.shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void removeItem(Item item) {
        CartItem ci = getCartItem(item);
        if (ci != null) {
            items.remove(ci);
        }
    }

    public void addItem(Item item) {
        CartItem ci = getCartItem(item);
        if (ci == null) {
            ci = new CartItem(item);
            items.add(ci);
        }
        ci.inc();
    }

    public CartItem getCartItem(Item item) {
        for (CartItem ci : items) {
            if (ci.getId() == item.getId()) {
                return ci;
            }
        }
        return null;
    }

    public int getAmount() {
        int amount = 0;
        for (CartItem ci : items) {
            amount += ci.getQuantity() * ci.getPrice();
        }
        return amount;
    }

    public void clear() {
        items = new ArrayList<>();
    }

}
