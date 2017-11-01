package yuwei35kd.springmultidatasource.mapper;

import java.util.List;
import java.util.Map;

import yuwei35kd.springmultidatasource.aop.DataSource;
import yuwei35kd.springmultidatasource.bean.User;

@DataSource("source1")
public interface UserMapper {
	public List<Map<String, Object>> findUsers();
	
	public int clearInit();
	
	public int create(User user);
	
	public int badCreate(User user);
	
}
