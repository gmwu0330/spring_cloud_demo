package demo.center.common.config;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManagerFactoryBiz",
		transactionManagerRef = "transactionManagerBiz",
		basePackages = { "demo.center.repository" }) // scan JPA SQL package
public class BizJpaConfig {

	public static final String Biz_PU = "BizPersistenceUnit";

	@Autowired
	@Qualifier("BizDataSource")
	private DataSource BizDataSource;

	@Autowired(required = false)
	private JpaProperties jpaProperties;

	@Autowired
	private HibernateProperties hibernateProperties;

	@Primary
	@Bean(name = "entityManagerBiz")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return Objects.requireNonNull(entityManagerFactoryBiz(builder).getObject()).createEntityManager();
	}

	@Primary
	@Bean(name = "entityManagerFactoryBiz")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBiz(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(BizDataSource)
				.packages("demo.center.common.entity", "demo.center.common.po")
				.persistenceUnit(Biz_PU)
				.properties(getVendorProperties())
				.build();
	}

	private Map<String, Object> getVendorProperties() {
		return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
	}

	@Primary
	@Bean(name = "transactionManagerBiz")
	@Qualifier("transactionManagerBiz")
	public PlatformTransactionManager transactionManagerBiz(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryBiz(builder).getObject()));
	}

}
