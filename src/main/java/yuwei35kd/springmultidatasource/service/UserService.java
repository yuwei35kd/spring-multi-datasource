package yuwei35kd.springmultidatasource.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yuwei35kd.springmultidatasource.aop.DataSource;
import yuwei35kd.springmultidatasource.mapper.UserMapper;

@Service
public class UserService {
	@Resource
	private UserMapper userMapper;
	
	public List<Map<String,Object>> findUsers1(){
		return userMapper.findUsers();
	}
	
	@DataSource("source2")
	public List<Map<String,Object>> findUsers2(){
		return userMapper.findUsers();
	}
	
	public int clear1(){
		return userMapper.clear();
	}
	
	@DataSource("source2")
	public int clear2(){
		return userMapper.clear();
	}
}
