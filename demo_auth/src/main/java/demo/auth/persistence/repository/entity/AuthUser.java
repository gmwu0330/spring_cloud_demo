package demo.auth.persistence.repository.entity;

import demo.auth.persistence.repository.converter.enums.StatusEnumConverter;
import demo.auth.persistence.repository.entity.base.BaseAuditEntity;
import demo.enums.StatusEnum;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

    @Convert(converter = StatusEnumConverter.class)
    @Column(name = "locked")
    private StatusEnum locked;

    @Convert(converter = StatusEnumConverter.class)
    @Column(name = "enabled")
    private StatusEnum enabled;

    @Column(name = "expired_date")
    private LocalDateTime expired_date;

    @Column(name = "last_pwd_change_date")
    private LocalDateTime lastPwdChangeDate;

}
