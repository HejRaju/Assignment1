    package se.jensenyh.javacourse.saltmerch.backend.controller;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3010")
@RequestMapping("api/v1")

public class CartController {
    @Autowired
    private CartService cartService;


    @GetMapping("/carts/{id}")
    public ResponseEntity<List<CartItem>> getCardId(@PathVariable int id){

        return new ResponseEntity<>(cartService.getCartContents(id) ,HttpStatus.OK);

    }
    @PatchMapping("carts/{id}")
    public ResponseEntity<Object> addOrRemoveItemFromCart (@PathVariable("id") int id,
                                                             @RequestParam ("action") String action,
                                                             @RequestBody CartItem cartItem){

        if (action.equals("add")){
            return new ResponseEntity<>(cartService.addItem(id, action,cartItem), HttpStatus.OK);
        }
        if (action.equals("remove")){
            return new ResponseEntity<>(cartService.removeItem(id, action,cartItem), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("carts/{id}")
    public void clearCart(@PathVariable("id") int id,
                                              @RequestParam @Nullable boolean buyout){
        cartService.emptyCart(!buyout);

    }
}