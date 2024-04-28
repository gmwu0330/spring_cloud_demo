package demo.center.model.order.service.impl;

import demo.center.model.order.converter.OrderConverter;
import demo.center.model.order.service.OrderService;
import demo.center.model.order.request.QueryOrderReq;
import demo.center.model.order.response.QueryOrderResp;
import demo.center.common.entity.Order;
import demo.center.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    @Override
    public QueryOrderResp query(QueryOrderReq request) {
        final Long id = request.getId();
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional.map(orderConverter::toResp).orElse(null);
    }

}
