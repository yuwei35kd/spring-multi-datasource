package yuwei35kd.springmultidatasource.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import yuwei35kd.springmultidatasource.aop.DataSource;
import yuwei35kd.springmultidatasource.bean.User;
import yuwei35kd.springmultidatasource.mapper.UserMapper;
import yuwei35kd.springmultidatasource.mapper.UserMapper2;

@Service
@DataSource("source1")
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {
	@Resource
	private UserMapper userMapper;
	@Resource
    private UserService2 userService2;

	public List<Map<String,Object>> findUsers(){
		return userMapper.findUsers();
	}
	
    public void badCreate(){
	    User user = new User();
	    user.setUserId(1000);
	    user.setName("hahaha");
	    userMapper.create(user);
	    try{
            userService2.badCreate(user);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
