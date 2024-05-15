package demo.admin.repository;


import demo.admin.repository.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, JpaSpecificationExecutor<AuthUser> {

    Optional<AuthUser> findByUsername(String username);

}
