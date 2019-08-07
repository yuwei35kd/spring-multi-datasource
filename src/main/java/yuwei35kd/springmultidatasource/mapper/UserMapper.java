package yuwei35kd.springmultidatasource.mapper;

import java.util.List;
import java.util.Map;

import yuwei35kd.springmultidatasource.aop.DataSource;
import yuwei35kd.springmultidatasource.bean.User;

//@DataSource("source1")
public interface UserMapper {
	List<Map<String, Object>> findUsers();
	
	int clearInit();
	
	int create(User user);
	
	int badCreate(User user);
}
