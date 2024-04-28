package demo.goods.model.goods.converter;

import demo.goods.model.goods.response.QueryGoodsResp;
import demo.goods.common.entity.Goods;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoodsConverter {

    QueryGoodsResp toResp(Goods entity);

}
