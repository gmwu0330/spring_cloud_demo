package demo.biz.model.goods.controller;

import demo.biz.goods.api.GoodsApi;
import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.goods.response.QueryGoodsResp;
import demo.biz.model.goods.service.GoodsService;
import demo.common.request.PageReq;
import demo.common.response.BaseResponse;
import demo.common.response.PageResp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GoodsController implements GoodsApi {

    private final GoodsService goodsService;

    @Override
    public BaseResponse<List<QueryGoodsResp>> queryList(QueryGoodsReq req) {
        return BaseResponse.successWithData(goodsService.queryAll(req));
    }

    @Override
    public BaseResponse<PageResp<QueryGoodsResp>> queryPage(PageReq<QueryGoodsReq> pageReq) {
        return BaseResponse.successWithData(goodsService.queryPage(pageReq));
    }

}
