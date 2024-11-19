package com.performance;

import com.performance.DTO.ProductDetailDTO;
import com.performance.facade.ProductDetailFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDetailController {

    ProductDetailFacade productDetailFacade;

    public ProductDetailController(ProductDetailFacade productDetailFacade) {
        this.productDetailFacade = productDetailFacade;
    }

    @GetMapping("/{id}/sync")
    public ResponseEntity<ProductDetailDTO> getProductDetails(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productDetailFacade.getProductDetails(id));
    }

    @GetMapping("/{id}/async")
    public ResponseEntity<ProductDetailDTO> getProductDetailsAsync(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productDetailFacade.getProductDetailsAsync(id));
    }
}
