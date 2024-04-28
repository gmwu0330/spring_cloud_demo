package demo.center.model.order.controller;

import demo.center.model.order.service.OrderService;
import demo.center.model.order.request.QueryOrderReq;
import demo.center.model.order.response.QueryOrderResp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/order")
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Override
    @PostMapping("/query")
    public QueryOrderResp query(@RequestBody QueryOrderReq request) {
        return orderService.query(request);
    }

}
