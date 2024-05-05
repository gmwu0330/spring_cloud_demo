package demo.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageReq<T> implements Serializable {

    private int page;
    private int size;
    private T queries;
    private String[] asc;
    private String[] desc;

}
