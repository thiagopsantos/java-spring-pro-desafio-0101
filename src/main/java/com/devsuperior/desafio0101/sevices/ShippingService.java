package com.devsuperior.desafio0101.sevices;

import com.devsuperior.desafio0101.model.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double shippmentValue = 0.0;

        if (order.getBasic() < 100.0) {
            shippmentValue = 20.0;
        } else if (order.getBasic() >= 100.0 && order.getBasic() < 200.0) {
            shippmentValue = 12.0;
        }

        return shippmentValue;
    }
}
