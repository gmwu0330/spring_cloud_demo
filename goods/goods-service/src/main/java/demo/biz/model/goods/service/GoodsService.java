package demo.biz.model.goods.service;

import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.goods.response.GoodsResp;
import demo.common.request.PageReq;
import demo.common.response.PageResp;

import java.util.List;

public interface GoodsService {

    List<GoodsResp> queryAll(QueryGoodsReq req);

    PageResp<GoodsResp> queryPage(PageReq<QueryGoodsReq> pageReq);

}
