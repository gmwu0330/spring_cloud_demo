package demo.biz.goods.api;

import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.goods.response.QueryGoodsResp;
import demo.common.request.PageReq;
import demo.common.response.BaseResponse;
import demo.common.response.PageResp;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GoodsApi {

    BaseResponse<List<QueryGoodsResp>> queryList();
    BaseResponse<PageResp<QueryGoodsResp>> queryPage(@RequestBody PageReq<QueryGoodsReq> pageReq);

}
