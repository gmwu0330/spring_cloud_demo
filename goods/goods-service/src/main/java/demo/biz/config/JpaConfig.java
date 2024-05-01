package demo.biz.config;

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
		entityManagerFactoryRef = "entityManagerFactoryDemo",
		transactionManagerRef = "transactionManagerDemo",
		basePackages = { "demo.biz.repository" }) // scan JPA SQL package
public class JpaConfig {

	public static final String Demo_PU = "DemoPersistenceUnit";

	@Autowired
	private DataSource DemoDataSource;

	@Autowired(required = false)
	private JpaProperties jpaProperties;

	@Autowired
	private HibernateProperties hibernateProperties;

	@Primary
	@Bean(name = "entityManagerDemo")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return Objects.requireNonNull(entityManagerFactoryDemo(builder)
				.getObject()).createEntityManager();
	}

	@Primary
	@Bean(name = "entityManagerFactoryDemo")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryDemo(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(DemoDataSource)
				.packages("demo.biz.repository.entity", "demo.biz.repository.po")
				.persistenceUnit(Demo_PU)
				.properties(getVendorProperties())
				.build();
	}

	private Map<String, Object> getVendorProperties() {
		return hibernateProperties.determineHibernateProperties(
				jpaProperties.getProperties(), new HibernateSettings());
	}

	@Primary
	@Bean(name = "transactionManagerDemo")
	@Qualifier("transactionManagerDemo")
	public PlatformTransactionManager transactionManagerDemo(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryDemo(builder).getObject()));
	}

}
