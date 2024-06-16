package demo.auth.persistence.repository.entity;

import demo.auth.common.enums.AuthRoleEnum;
import demo.auth.persistence.repository.converter.enums.AuthRoleEnumConverter;
import demo.auth.persistence.repository.converter.enums.StatusEnumConverter;
import demo.auth.persistence.repository.entity.base.BaseAuditEntity;
import demo.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user_role")
public class UserRole extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Convert(converter = AuthRoleEnumConverter.class)
    @Column(name = "auth_role")
    private AuthRoleEnum authRole;

    @Convert(converter = StatusEnumConverter.class)
    @Column(name = "enabled")
    private StatusEnum enabled;

}
