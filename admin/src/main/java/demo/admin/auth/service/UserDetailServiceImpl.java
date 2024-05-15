package demo.admin.auth.service;

import demo.admin.auth.bo.LoginUser;
import demo.admin.repository.entity.AuthUser;
import demo.admin.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final AuthUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found !!"));

        LoginUser loginUser = new LoginUser();
        loginUser.setUsername(authUser.getUsername());
        loginUser.setPassword(authUser.getPassword());
        loginUser.setAccountNonLocked(!authUser.isLocked());
        loginUser.setEnabled(authUser.isEnabled());

        // 判斷過期
        loginUser.setAccountNonExpired(true);
        loginUser.setCredentialsNonExpired(true);

        return loginUser;
    }
}
