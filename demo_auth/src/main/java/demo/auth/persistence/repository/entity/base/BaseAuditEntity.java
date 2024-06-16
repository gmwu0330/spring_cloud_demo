package demo.auth.persistence.repository.entity.base;

import constant.CommonConstant;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseAuditEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @CreatedDate
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "create_by")
    private String createBy;

    @LastModifiedDate
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "update_by")
    private String updateBy;

    @PrePersist
	private void prePersist() {
		if (StringUtils.isBlank(createBy)){
            createBy = CommonConstant.SYSTEM;
            updateBy = CommonConstant.SYSTEM;
        }
        createTime = LocalDateTime.now();
        updateTime = LocalDateTime.now();
	}

	@PreUpdate
	private void preUpdate() {
		if (StringUtils.isBlank(updateBy)){
            updateBy = CommonConstant.SYSTEM;
        }
        updateTime = LocalDateTime.now();
	}

}
