package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;

@Service
public class CartService

{
    @Autowired
    CartRepository repository;

    public List<CartItem> getCartContents(int id) {

        return repository.selectAllItems();
    }

    public Object addItem(int id, String action, CartItem cartItem) {
        return repository.insertOrIncrementItem(cartItem);
    }

    public Object removeItem(int id, String action, CartItem cartItem) {
        return repository.deleteOrDecrementItem(cartItem);
    }

    public void emptyCart(boolean b) {
        repository.deleteAllItems(b);
    }
}