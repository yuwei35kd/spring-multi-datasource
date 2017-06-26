package yuwei35kd.springmultidatasource.mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	public List<Map<String, Object>> findUsers();
	
	public int clear();
}
