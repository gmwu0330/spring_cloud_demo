package demo.biz.goods.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryGoodsReq implements Serializable {

    private Long id;
    private String goodsCode;
    private String goodsName;
    private String goodsType;
    private BigDecimal priceMax;
    private BigDecimal priceMin;
}