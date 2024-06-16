package demo.auth.persistence.repository;

import demo.auth.persistence.repository.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, JpaSpecificationExecutor<AuthUser> {

    Optional<AuthUser> findByUsername(String username);

}
