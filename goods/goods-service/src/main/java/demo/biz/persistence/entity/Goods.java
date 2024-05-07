package demo.biz.persistence.entity;

import demo.biz.persistence.entity.base.BaseAuditEntity;
import demo.enums.GoodsTypeEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_goods")
public class Goods extends BaseAuditEntity {

    @Id
    private Long id;

    @Column(name = "goods_code")
    private String goodsCode;

    @Column(name = "goods_name")
    private String goodsName;

    @Enumerated(EnumType.STRING)
    @Column(name = "goods_type")
    private GoodsTypeEnum goodsType;

    @Column(name = "price")
    private BigDecimal price;

}
