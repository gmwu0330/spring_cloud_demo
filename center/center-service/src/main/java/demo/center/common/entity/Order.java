package demo.center.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "t_order")
public class Order {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

}
