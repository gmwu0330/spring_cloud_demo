package demo.center.model.order.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryOrderResp implements Serializable {

    private Long id;
    private String name;

}
