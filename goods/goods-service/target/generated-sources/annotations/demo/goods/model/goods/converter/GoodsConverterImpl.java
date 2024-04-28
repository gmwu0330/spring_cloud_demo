package demo.goods.model.goods.converter;

import demo.goods.common.entity.Goods;
import demo.goods.model.goods.response.QueryGoodsResp;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T00:56:03+0800",
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
        queryGoodsResp.setGoodsNo( entity.getGoodsNo() );
        queryGoodsResp.setGoodsName( entity.getGoodsName() );
        queryGoodsResp.setPrice( entity.getPrice() );

        return queryGoodsResp;
    }
}
