package demo.goods.model.goods.controller;

import demo.goods.model.goods.response.QueryGoodsResp;
import demo.goods.model.goods.request.QueryGoodsReq;

public interface GoodsApi {

    QueryGoodsResp query(QueryGoodsReq request);

}
