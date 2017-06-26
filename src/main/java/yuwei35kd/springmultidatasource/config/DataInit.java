package yuwei35kd.springmultidatasource.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DataInit {
	@Value("classpath:db-schema1.sql")
	private Resource schemaScript1;

	@Value("classpath:db-test-data1.sql")
	private Resource dataScript1;
	
	@Value("classpath:db-schema2.sql")
	private Resource schemaScript2;

	@Value("classpath:db-test-data2.sql")
	private Resource dataScript2;

	@Bean("dataSourceInitializer1")
	public DataSourceInitializer dataSourceInitializer1(final @Qualifier("source") DataSource dataSource) {
	    final DataSourceInitializer initializer = new DataSourceInitializer();
	    initializer.setDataSource(dataSource);
	    initializer.setDatabasePopulator(databasePopulator(schemaScript1,dataScript1));
	    return initializer;
	}
	
	@Bean("dataSourceInitializer2")
	public DataSourceInitializer dataSourceInitializer2(final @Qualifier("source") DataSource dataSource) {
	    final DataSourceInitializer initializer = new DataSourceInitializer();
	    initializer.setDataSource(dataSource);
	    initializer.setDatabasePopulator(databasePopulator(schemaScript2,dataScript2));
	    return initializer;
	}

	private DatabasePopulator databasePopulator(Resource schemaScript,Resource dataScript) {
	    final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	    populator.addScript(schemaScript);
	    populator.addScript(dataScript);
	    return populator;
	}
}
