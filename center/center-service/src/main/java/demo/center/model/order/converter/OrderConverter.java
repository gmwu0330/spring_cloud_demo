package demo.center.model.order.converter;

import demo.center.model.order.response.QueryOrderResp;
import demo.center.common.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderConverter {

    QueryOrderResp toResp(Order entity);

}
