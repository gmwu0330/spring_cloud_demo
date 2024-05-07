package demo.biz.goods.api;

import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.goods.response.GoodsResp;
import demo.common.request.PageReq;
import demo.common.response.BaseResponse;
import demo.common.response.PageResp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GoodsApi {

    String PREFIX = "/goods";

    @PostMapping(PREFIX + "/query/list")
    BaseResponse<List<GoodsResp>> queryList(@RequestBody QueryGoodsReq req);

    @PostMapping(PREFIX + "/query/page")
    BaseResponse<PageResp<GoodsResp>> queryPage(@RequestBody PageReq<QueryGoodsReq> pageReq);

}
