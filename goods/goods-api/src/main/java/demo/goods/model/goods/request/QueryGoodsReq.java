package demo.goods.model.goods.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryGoodsReq implements Serializable {

    private Long id;

}
