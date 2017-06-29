package yuwei35kd.springmultidatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author yuwei35kd
 *
 * 配置多数据源的事务控制
 * http://blog.csdn.net/u012345283/article/details/47059537
 * 
 * 基于注解的Spring多数据源配置和使用
 * http://www.cnblogs.com/liujiduo/p/5004691.html
 * 
 * Spring Boot 默认集成事务，所以无须手动开启使用 @EnableTransactionManagement 注解，
 * 就可以用 @Transactional注解进行事务管理。
 * 
 * https://stackoverflow.com/questions/14068525/javaconfig-replacing-aopadvisor-and-txadvice
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ImportResource("classpath:tx-advice.xml")
@EnableTransactionManagement
public class SpringMultiDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMultiDatasourceApplication.class, args);
	}
}
