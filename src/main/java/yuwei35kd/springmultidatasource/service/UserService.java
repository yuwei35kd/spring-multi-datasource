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
public class UserService {
	@Resource
	private UserMapper userMapper;
	@Resource
	private UserMapper2 userMapper2;
	
	public List<Map<String,Object>> findUsers1(){
		return userMapper.findUsers();
	}
	
	public List<Map<String,Object>> findUsers2(){
		return userMapper2.findUsers();
	}
	
	public void clearInit(){
		userMapper.clearInit();
		userMapper2.clearInit();
	}
	
	@Transactional
	public void create(User user){
        userMapperCreate(user);
        userMapper2BadCreate(user);
	}

    @Transactional
	public void create2(User user){
        userMapper2Create(user);
		userMapperBadCreate(user);
	}

	@DataSource("source1")
    @Transactional(propagation = Propagation.REQUIRED)
	public int userMapperCreate(User user){
	    return userMapper.create(user);
    }

    @DataSource("source2")
    public int userMapper2Create(User user){
	    return userMapper2.create(user);
    }

    @DataSource("source1")
    public int userMapperBadCreate(User user){
	    return userMapper.badCreate(user);
    }

    @DataSource("source2")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int userMapper2BadCreate(User user){
	    return userMapper2.badCreate(user);
    }
	
}
