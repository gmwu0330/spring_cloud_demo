package demo.biz.model.goods.converter;

import demo.biz.goods.response.QueryGoodsResp;
import demo.biz.persistence.entity.Goods;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-05T23:37:57+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class GoodsConverterImpl implements GoodsConverter {

    @Override
    public QueryGoodsResp toResp(Goods entity) {
        if ( entity == null ) {
            return null;
        }

        QueryGoodsResp queryGoodsResp = new QueryGoodsResp();

        queryGoodsResp.setId( entity.getId() );
        queryGoodsResp.setGoodsCode( entity.getGoodsCode() );
        queryGoodsResp.setGoodsName( entity.getGoodsName() );
        queryGoodsResp.setGoodsType( entity.getGoodsType() );
        queryGoodsResp.setPrice( entity.getPrice() );
        queryGoodsResp.setCreateTime( entity.getCreateTime() );
        queryGoodsResp.setCreateBy( entity.getCreateBy() );
        queryGoodsResp.setUpdateTime( entity.getUpdateTime() );
        queryGoodsResp.setUpdateBy( entity.getUpdateBy() );

        return queryGoodsResp;
    }
}
