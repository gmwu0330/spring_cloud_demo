package demo.goods.model.goods.controller;

import demo.goods.model.goods.service.GoodsService;
import demo.goods.model.goods.request.QueryGoodsReq;
import demo.goods.model.goods.response.QueryGoodsResp;
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
