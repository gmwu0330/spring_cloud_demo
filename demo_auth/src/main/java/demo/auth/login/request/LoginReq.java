package demo.auth.login.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class LoginReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank()
    private String username;
    @NotBlank()
    private String password;
}
