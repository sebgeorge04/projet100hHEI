package o.o.entities;

import java.util.HashMap;

public class Cart {
    HashMap<String, Integer> cartItems;
    public Cart(){
     cartItems = new HashMap<>();
      
    }
    public HashMap getCartItems(){
        return cartItems;
    }
    public void addToCart(String itemId, int price){
        cartItems.put(itemId, price);
    }
    public void deleteFromCart(String itemId){
        cartItems.remove(itemId);
    }
}