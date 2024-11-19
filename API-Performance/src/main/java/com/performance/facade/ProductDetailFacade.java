package com.performance.facade;

import com.performance.DTO.ProductDetailDTO;
import com.performance.entity.Inventory;
import com.performance.entity.Price;
import com.performance.entity.Product;
import com.performance.service.InventoryService;
import com.performance.service.PriceService;
import com.performance.service.ProductService;
import com.performance.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class ProductDetailFacade {

    public ProductDetailFacade(ProductService productService, PriceService priceService, InventoryService inventoryService) {
        this.productService = productService;
        this.priceService = priceService;
        this.inventoryService = inventoryService;
    }

    final ProductService productService;
    PriceService priceService;
    InventoryService inventoryService;

    //Synchronous way
    public ProductDetailDTO getProductDetails(Long productId) {
        //fetch product details
        //fetch price details of product
        //fetch inventory details
        Product product = productService.findById(productId);
        Price price = priceService.getPriceByProductId(productId);
        Inventory inventory = inventoryService.getInventoryByProductId(productId);
        return new ProductDetailDTO(
                        productId,
                        product.getCategory().getName(),
                        product.getName(),
                        product.getDescription(),
                        inventory.getAvailableQuantity(),
                        price.getPrice(),
                        product.getStatus());
    }

    //Asynchronous way, using CompletableFuture<>
    public CompletableFuture<Product> getProduct(Long productId) {
        return CompletableFuture.supplyAsync(() -> productService.findById(productId));
    }
    public CompletableFuture<Price> getPrice(Long productId) {
        return CompletableFuture.supplyAsync(() -> priceService.getPriceByProductId(productId));
    }
    public CompletableFuture<Inventory> getInventory(Long productId) {
        return CompletableFuture.supplyAsync(() -> inventoryService.getInventoryByProductId(productId));
    }

    /*
        Using CompletableFuture we fetch data in asynchronous way
        eventually decrease the response time.
     */
    public ProductDetailDTO getProductDetailsAsync(Long productId) {
        CompletableFuture<Product> productCompletableFuture = getProduct(productId);
        CompletableFuture<Price> priceCompletableFuture = getPrice(productId);
        CompletableFuture<Inventory> inventoryCompletableFuture = getInventory(productId);

        CompletableFuture.allOf(productCompletableFuture,priceCompletableFuture,inventoryCompletableFuture);
        Product product = productCompletableFuture.join();
        Price price = priceCompletableFuture.join();
        Inventory inventory = inventoryCompletableFuture.join();
        return new ProductDetailDTO(
                productId,
                product.getCategory().getName(),
                product.getName(),
                product.getDescription(),
                inventory.getAvailableQuantity(),
                price.getPrice(),
                product.getStatus());
    }

}
