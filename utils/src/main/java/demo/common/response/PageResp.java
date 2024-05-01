package demo.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResp<T> implements Serializable {

    private int page;
    private int size;
    private int totalPage;
    private long totalSize;
    private boolean hasNext;
    private List<T> records;

//    public PageResp(int page, int size, int totalPage, int totalSize, boolean hasNext, List<T> records){
//
//    }

}
