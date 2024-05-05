package demo.biz.goods.response;

import demo.enums.GoodsType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryGoodsResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String goodsCode;

    private String goodsName;

    private GoodsType goodsType;

    private BigDecimal price;

    private LocalDateTime createTime;

    private String createBy;

    private LocalDateTime updateTime;

    private String updateBy;

}