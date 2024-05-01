package demo.biz.goods.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryGoodsResp implements Serializable {

    private Long id;

    private String goodsCode;

    private String goodsName;

    private String goodsType;

    private BigDecimal price;

}