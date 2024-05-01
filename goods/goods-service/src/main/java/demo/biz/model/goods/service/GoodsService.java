package demo.biz.model.goods.service;

import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.goods.response.QueryGoodsResp;

public interface GoodsService {

    QueryGoodsResp query(QueryGoodsReq request);

}
