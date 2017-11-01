package yuwei35kd.springmultidatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
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
 * Spring, MyBatis 多数据源的配置和管理
 * http://www.cnblogs.com/digdeep/p/4512368.html
 * 
 * https://stackoverflow.com/questions/14068525/javaconfig-replacing-aopadvisor-and-txadvice
 * 
 * 注意：
 * 当是不同类型的数据源切换时需要注意的是，需要将在开启事务之前切换数据源。
 * 比方两个数据源：一个是mysql,一个是oracle
 * 此时如果在service层开启事务，而数据源切换在dao层，这时就会报错。
 * 最好是开始事务和切换数据源都在service上面。而DataSourceAspect上面的@Order(0)决定了切换数据源会在开始事务之前。
 * 
 * 
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@ImportResource("classpath:tx-advice.xml")
@EnableTransactionManagement
public class SpringMultiDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMultiDatasourceApplication.class, args);
	}
}
