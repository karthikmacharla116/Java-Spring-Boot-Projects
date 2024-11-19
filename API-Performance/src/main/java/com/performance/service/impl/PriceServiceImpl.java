package com.performance.service.impl;

import com.performance.entity.Price;
import com.performance.service.PriceService;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    @Override
    public Price getPriceByProductId(Long productId) {
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
