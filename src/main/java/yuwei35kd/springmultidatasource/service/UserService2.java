package yuwei35kd.springmultidatasource.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import yuwei35kd.springmultidatasource.aop.DataSource;
import yuwei35kd.springmultidatasource.bean.User;
import yuwei35kd.springmultidatasource.mapper.UserMapper;
import yuwei35kd.springmultidatasource.mapper.UserMapper2;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@DataSource("source2")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserService2 {
	@Resource
	private UserMapper2 userMapper2;

    public List<Map<String,Object>> findUsers(){
        return userMapper2.findUsers();
    }

    public Integer badCreate(User user){
        return userMapper2.badCreate(user);
    }

}
