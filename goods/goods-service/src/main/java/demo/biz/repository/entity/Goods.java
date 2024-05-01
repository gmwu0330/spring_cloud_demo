package demo.biz.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_goods")
public class Goods {

    @Id
    private Long id;

    @Column(name = "goods_no")
    private String goodsNo;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "update_by")
    private String updateBy;

}
