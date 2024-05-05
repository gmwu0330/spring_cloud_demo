package demo.biz.model.goods.service;

import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.goods.response.QueryGoodsResp;
import demo.common.request.PageReq;
import demo.common.response.PageResp;

import java.util.List;

public interface GoodsService {

    List<QueryGoodsResp> queryAll(QueryGoodsReq req);

    PageResp<QueryGoodsResp> queryPage(PageReq<QueryGoodsReq> pageReq);

}
