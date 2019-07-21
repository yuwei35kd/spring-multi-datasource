package yuwei35kd.springmultidatasource.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import yuwei35kd.springmultidatasource.bean.User;
import yuwei35kd.springmultidatasource.service.UserService;

@RestController
public class UserController {
	@Resource
	private UserService userService;
	
	@GetMapping("findUser")
	public List<Map<String,Object>> findUser(){
		return userService.findUsers1();
	}

	@GetMapping("create")
    public String create(){
        User user = new User();
        user.setUserId(2);
        user.setName("u2");
	    userService.create(user);
	    return "创建成功！";
    }
}
