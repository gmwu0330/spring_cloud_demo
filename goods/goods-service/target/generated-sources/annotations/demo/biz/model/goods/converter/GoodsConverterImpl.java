package demo.biz.model.goods.converter;

import demo.biz.goods.response.GoodsResp;
import demo.biz.persistence.entity.Goods;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-08T00:04:40+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class GoodsConverterImpl implements GoodsConverter {

    @Override
    public GoodsResp toResp(Goods entity) {
        if ( entity == null ) {
            return null;
        }

        GoodsResp goodsResp = new GoodsResp();

        goodsResp.setId( entity.getId() );
        goodsResp.setGoodsCode( entity.getGoodsCode() );
        goodsResp.setGoodsName( entity.getGoodsName() );
        goodsResp.setGoodsType( entity.getGoodsType() );
        goodsResp.setPrice( entity.getPrice() );
        goodsResp.setCreateTime( entity.getCreateTime() );
        goodsResp.setCreateBy( entity.getCreateBy() );
        goodsResp.setUpdateTime( entity.getUpdateTime() );
        goodsResp.setUpdateBy( entity.getUpdateBy() );

        return goodsResp;
    }
}
