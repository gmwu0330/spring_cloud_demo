package demo.goods.config;

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
		entityManagerFactoryRef = "entityManagerFactoryGoods",
		transactionManagerRef = "transactionManagerGoods",
		basePackages = { "demo.goods.repository" }) // scan JPA SQL package
public class GoodsJpaConfig {

	public static final String Goods_PU = "GoodsPersistenceUnit";

	@Autowired
	@Qualifier("GoodsDataSource")
	private DataSource GoodsDataSource;

	@Autowired(required = false)
	private JpaProperties jpaProperties;

	@Autowired
	private HibernateProperties hibernateProperties;

	@Primary
	@Bean(name = "entityManagerGoods")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return Objects.requireNonNull(entityManagerFactoryGoods(builder)
				.getObject()).createEntityManager();
	}

	@Primary
	@Bean(name = "entityManagerFactoryGoods")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryGoods(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(GoodsDataSource)
				.packages("demo.goods.common.entity", "demo.goods.common.po")
				.persistenceUnit(Goods_PU)
				.properties(getVendorProperties())
				.build();
	}

	private Map<String, Object> getVendorProperties() {
		return hibernateProperties.determineHibernateProperties(
				jpaProperties.getProperties(), new HibernateSettings());
	}

	@Primary
	@Bean(name = "transactionManagerGoods")
	@Qualifier("transactionManagerGoods")
	public PlatformTransactionManager transactionManagerGoods(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryGoods(builder).getObject()));
	}

}
