package demo.admin.repository.entity;

import demo.admin.repository.entity.base.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "auth_user")
public class AuthUser extends BaseAuditEntity {

    @Id
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

    @Column(name = "locked")
    private boolean locked;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "expired_date")
    private LocalDateTime expired_date;

    @Column(name = "last_pwd_change_date")
    private LocalDateTime lastPwdChangeDate;

}
