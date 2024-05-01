package demo.biz.goods.api;

import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.goods.response.QueryGoodsResp;
import org.springframework.web.bind.annotation.RequestBody;

public interface GoodsApi {

    public QueryGoodsResp query(@RequestBody QueryGoodsReq request);

}
