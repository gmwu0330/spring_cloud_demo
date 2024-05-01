package demo.biz.model.goods.controller;

import demo.biz.goods.api.GoodsApi;
import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.goods.response.QueryGoodsResp;
import demo.biz.model.goods.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/goods")
public class GoodsController implements GoodsApi {

    private final GoodsService orderService;

    @Override
    @PostMapping("/query")
    public QueryGoodsResp query(@RequestBody QueryGoodsReq request) {
        return orderService.query(request);
    }

}
