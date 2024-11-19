package com.performance.DTO;

public class ProductDetailDTO {

    private Long id;
    private String categoryName;
    private String name;
    private  String description;
    private int availableQuantity;
    private Double price;
    private String status;

    public ProductDetailDTO(Long id, String categoryName, String name, String description, int availableQuantity, Double price, String status) {
        this.id = id;
        this.categoryName = categoryName;
        this.name = name;
        this.description = description;
        this.availableQuantity = availableQuantity;
        this.price = price;
        this.status = status;
    }

}
