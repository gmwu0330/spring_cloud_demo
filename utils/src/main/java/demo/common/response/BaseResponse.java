package demo.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseResponse<T> implements Serializable {

    private int code;
    private Boolean success = true;
    private T data;

    public BaseResponse(T data){
        this.data = data;
    }

    public static <T> BaseResponse<T> successWithData(T data){
        return new BaseResponse<>(HttpStatus.OK.value(), true, data);
    }

    public static BaseResponse<Void> success(){
        return new BaseResponse<>(HttpStatus.OK.value(), true, null);
    }

}
