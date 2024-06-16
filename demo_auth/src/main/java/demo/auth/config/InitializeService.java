package demo.auth.config;

import demo.auth.common.enums.AuthRoleEnum;
import demo.auth.persistence.repository.AuthUserRepository;
import demo.auth.persistence.repository.UserRoleRepository;
import demo.auth.persistence.repository.entity.AuthUser;
import demo.auth.persistence.repository.entity.UserRole;
import demo.enums.StatusEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitializeService implements InitializingBean {

    private final AuthUserRepository authUserRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void afterPropertiesSet() {
        String adminUser = "admin";
        this.initAdminUser(adminUser);
        this.initAdminRole(adminUser);
    }

    private void initAdminUser(String username) {
        Optional<AuthUser> adminOpt = authUserRepository.findByUsername(username);
        if (adminOpt.isEmpty()) {
            AuthUser authUser = new AuthUser();
            authUser.setUsername(username);
            authUser.setPassword(passwordEncoder.encode(username + "123"));
            authUser.setLastPwdChangeDate(LocalDateTime.now());
            authUser.setLocked(StatusEnum.N);
            authUser.setEnabled(StatusEnum.Y);
            authUserRepository.save(authUser);
        }
    }

    private void initAdminRole(String username) {
        List<UserRole> userRoleList = userRoleRepository.findByUsername(username);
        if (userRoleList.isEmpty()) {
            Arrays.stream(AuthRoleEnum.values()).forEach(authRole -> {
                UserRole userRole = new UserRole();
                userRole.setUsername(username);
                userRole.setAuthRole(authRole);
                userRole.setEnabled(StatusEnum.Y);
                userRoleRepository.save(userRole);
            });
        }
    }

}
