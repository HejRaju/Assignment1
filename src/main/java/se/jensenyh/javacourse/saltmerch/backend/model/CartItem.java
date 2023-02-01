package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartItem {
    // todo: needs fields: int productId, String title, String color, String size, String previewImage, and int quantity

    // todo: all fields should be public and annotated with @JsonProperty
    @JsonProperty
    public int productId, quantity;
    public String title, size, color, previewImage;


    // todo: needs 3 constructors:
    //  1. empty constructor

    public CartItem() {
    }

    //  2. constructor with productId, title, color, size, and previewImage

    public CartItem(int productId, String title, String color, String size, String previewImage) {
        this.productId = productId;
        this.title = title;
        this.size = size;
        this.color = color;
        this.previewImage = previewImage;
    }


    //  3. constructor with productId, title, color, size, previewImage, and quantity


    public CartItem(int productId, String title, String color, String size, String previewImage, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
        this.title = title;
        this.size = size;
        this.color = color;
        this.previewImage = previewImage;
    }
}