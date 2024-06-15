package demo.auth.common.login.service;

import demo.auth.common.login.bo.LoginUser;
import demo.auth.persistence.repository.entity.AuthUser;
import demo.auth.persistence.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found !!"));

        LoginUser loginUser = new LoginUser();
        loginUser.setUsername(authUser.getUsername());
        loginUser.setPassword(authUser.getPassword());
        loginUser.setAccountNonLocked(!authUser.isLocked());
        loginUser.setEnabled(authUser.isEnabled());

        // 判斷過期
        loginUser.setAccountNonExpired(true);
        loginUser.setCredentialsNonExpired(true);

        List<GrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority("ADMIN"));
        loginUser.setAuthorities(auths);

        return loginUser;
    }
}
