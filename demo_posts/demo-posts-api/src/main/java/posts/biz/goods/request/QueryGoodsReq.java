package posts.biz.goods.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryGoodsReq implements Serializable {

    private Long id;
    private String goodsCode;
    private String goodsName;
    private Collection<String> goodsTypes;
    private BigDecimal priceMax;
    private BigDecimal priceMin;
}