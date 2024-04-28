package demo.center.model.order.controller;

import demo.center.model.order.request.QueryOrderReq;
import demo.center.model.order.response.QueryOrderResp;

public interface OrderApi {

    QueryOrderResp query(QueryOrderReq request);

}
