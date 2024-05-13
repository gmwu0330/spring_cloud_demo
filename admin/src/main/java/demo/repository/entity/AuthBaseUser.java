package demo.repository.entity;

import demo.repository.entity.base.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "auth_base_user")
public class AuthBaseUser extends BaseAuditEntity {

    @Id
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "locked")
    private boolean locked;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "account_expired_date")
    private LocalDateTime accountExpiredDate;

    @Column(name = "credentials_expired_date")
    private LocalDateTime credentialsExpiredDate;

}
