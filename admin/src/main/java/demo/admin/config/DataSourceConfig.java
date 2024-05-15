package demo.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
	@Bean("DemoDataSource")
	@ConfigurationProperties(prefix = "demo-datasource")
	public DataSource DemoDataSource() {
		return DataSourceBuilder.create().build();
	}

}
