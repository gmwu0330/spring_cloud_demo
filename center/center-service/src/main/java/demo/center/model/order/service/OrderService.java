package demo.center.model.order.service;

import demo.center.model.order.request.QueryOrderReq;
import demo.center.model.order.response.QueryOrderResp;

public interface OrderService {

    QueryOrderResp query(QueryOrderReq request);

}
