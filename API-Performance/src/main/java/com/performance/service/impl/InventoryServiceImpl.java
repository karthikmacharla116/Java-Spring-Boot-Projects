package com.performance.service.impl;

import com.performance.entity.Inventory;
import com.performance.service.InventoryService;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Override
    public Inventory getInventoryByProductId(Long productId) {
        addDelay();
        return null;
    }

    private void addDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
