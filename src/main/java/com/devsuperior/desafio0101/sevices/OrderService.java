package com.devsuperior.desafio0101.sevices;

import com.devsuperior.desafio0101.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double shipmentValue = shippingService.shipment(order);
        double discountedValue = order.getBasic() - (order.getBasic() * order.getDiscount() / 100);

        return discountedValue + shipmentValue;
    }
}
