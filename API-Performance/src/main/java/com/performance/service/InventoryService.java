package com.performance.service;

import com.performance.entity.Inventory;

public interface InventoryService {

    Inventory getInventoryByProductId(Long productId);
}
