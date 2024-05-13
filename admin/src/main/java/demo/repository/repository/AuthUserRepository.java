package demo.repository.repository;


import demo.repository.entity.AuthBaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthBaseUser, Long>, JpaSpecificationExecutor<AuthBaseUser> {

    Optional<AuthBaseUser> findByUsername(String username);

}
