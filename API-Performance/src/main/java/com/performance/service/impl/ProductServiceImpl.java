package com.performance.service.impl;

import com.performance.entity.Product;
import com.performance.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product findById(Long id) {
        //add log.info
        addDelay();
        return null;//DB call
    }

    private void addDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
