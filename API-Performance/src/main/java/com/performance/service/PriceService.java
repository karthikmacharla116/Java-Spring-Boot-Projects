package com.performance.service;

import com.performance.entity.Price;

public interface PriceService {

    Price getPriceByProductId(Long productId);
}
