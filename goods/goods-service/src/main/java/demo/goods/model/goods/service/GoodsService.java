package demo.goods.model.goods.service;

import demo.goods.model.goods.request.QueryGoodsReq;
import demo.goods.model.goods.response.QueryGoodsResp;

public interface GoodsService {

    QueryGoodsResp query(QueryGoodsReq request);

}
