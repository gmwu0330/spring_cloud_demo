package demo.admin.auth.bo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class LoginUser implements UserDetails {

    private String username;
    private String password;

    /**
     * 用來判斷使用者的帳戶是否過期
     * 如果帳戶已過期，返回false，表示使用者不應該被授權，反之則true。
     */
    private boolean accountNonExpired;

    /**
     * 用來判斷使用者的帳戶是否被鎖定
     * 如果帳戶被鎖定，返回false，表示使用者不應該被授權。
     */
    private boolean accountNonLocked;

     /**
     * 用來判斷使用者的認證信息是否過期，例如密碼是否過期
     * 如果認證信息已過期，返回false，表示使用者不應該被授權。
     */
    private boolean credentialsNonExpired;

    /**
     * 用來判斷使用者是否啟用，如果使用者已被禁用
     * 返回false，表示使用者不應該被授權。
     */
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
