package demo.auth.model.admin.user.api.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String username;

}
