package demo.model.goods.controller;

import demo.biz.goods.api.GoodsApi;
import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.goods.response.GoodsResp;
import demo.common.request.PageReq;
import demo.common.response.BaseResponse;
import demo.common.response.PageResp;
import demo.model.goods.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GoodsController implements GoodsApi {

    private final GoodsService goodsService;

    @Override
    public BaseResponse<List<GoodsResp>> queryList(QueryGoodsReq req) {
        return BaseResponse.successWithData(goodsService.queryAll(req));
    }

    @Override
    public BaseResponse<PageResp<GoodsResp>> queryPage(PageReq<QueryGoodsReq> pageReq) {
        return BaseResponse.successWithData(goodsService.queryPage(pageReq));
    }

}
