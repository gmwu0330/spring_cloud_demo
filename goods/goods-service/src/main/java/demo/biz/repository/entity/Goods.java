package demo.biz.repository.entity;

import demo.common.entity.BaseAuditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "t_goods")
public class Goods extends BaseAuditEntity {

    @Id
    private Long id;

    @Column(name = "goods_code")
    private String goodsCode;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_type")
    private String goodsType;

    @Column(name = "price")
    private BigDecimal price;

}
