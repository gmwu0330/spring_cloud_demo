package demo.biz.config;

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

//	@Bean("DemoDataSource")
//    public DataSource getDataSource() {
//        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url("jdbc:h2:mem:test");
//        dataSourceBuilder.username("SA");
//        dataSourceBuilder.password("");
//        return dataSourceBuilder.build();
//    }

}
