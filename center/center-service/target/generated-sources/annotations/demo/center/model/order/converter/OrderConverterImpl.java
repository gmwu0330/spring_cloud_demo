package demo.center.model.order.converter;

import demo.center.common.entity.Order;
import demo.center.model.order.response.QueryOrderResp;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-28T20:37:30+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class OrderConverterImpl implements OrderConverter {

    @Override
    public QueryOrderResp toResp(Order entity) {
        if ( entity == null ) {
            return null;
        }

        QueryOrderResp queryOrderResp = new QueryOrderResp();

        queryOrderResp.setId( entity.getId() );
        queryOrderResp.setName( entity.getName() );

        return queryOrderResp;
    }
}
