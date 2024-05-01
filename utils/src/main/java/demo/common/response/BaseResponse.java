package demo.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseResponse<T> implements Serializable {

    private static final String SUCCESS_CODE = "200";

    private String code = SUCCESS_CODE;
    private Boolean success = true;
    private T data;

    public BaseResponse(T data){
        this.data = data;
    }

//    public static BaseResponse<T> successWithData(T data){
//        return new BaseResponse<T>(SUCCESS_CODE, true, data);
//    }

}
