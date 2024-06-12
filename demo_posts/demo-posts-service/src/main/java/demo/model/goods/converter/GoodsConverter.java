package demo.model.goods.converter;

import posts.biz.goods.response.GoodsResp;
import demo.repository.entity.Goods;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoodsConverter {

    GoodsResp toResp(Goods entity);

}
