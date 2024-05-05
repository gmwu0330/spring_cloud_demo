package demo.biz.model.goods.converter;

import demo.biz.goods.response.QueryGoodsResp;
import demo.biz.persistence.entity.Goods;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoodsConverter {

    QueryGoodsResp toResp(Goods entity);

}
