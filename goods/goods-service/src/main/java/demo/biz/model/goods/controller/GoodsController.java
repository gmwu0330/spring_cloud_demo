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
@RequestMapping(value = "/goods")
public class GoodsController implements GoodsApi {

    private final GoodsService goodsService;

    @Override
    @PostMapping("/query/list")
    public BaseResponse<List<QueryGoodsResp>> queryList() {
        List<QueryGoodsResp> listResp = goodsService.queryAll();
        return new BaseResponse<>(listResp);
    }

    @Override
    @PostMapping("/query/page")
    public BaseResponse<PageResp<QueryGoodsResp>> queryPage(PageReq<QueryGoodsReq> pageReq) {
        PageResp<QueryGoodsResp> pageResp = goodsService.queryPage(pageReq);
        return new BaseResponse<>(pageResp);
    }

}
