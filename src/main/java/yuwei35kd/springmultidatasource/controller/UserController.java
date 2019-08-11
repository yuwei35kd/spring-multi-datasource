package yuwei35kd.springmultidatasource.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import yuwei35kd.springmultidatasource.bean.User;
import yuwei35kd.springmultidatasource.service.UserService;
import yuwei35kd.springmultidatasource.service.UserService2;

@RestController
public class UserController {
	@Resource
	private UserService userService;
	@Resource
    private UserService2 userService2;
	
	@GetMapping("/findUser")
	public List<Map<String,Object>> findUser(){
		return userService.findUsers();
	}

    @GetMapping("/findUser2")
    public List<Map<String,Object>> findUser2(){
        return userService2.findUsers();
    }

    @GetMapping("/findAll")
    public List<Map<String,Object>> findAll(){
	    return userService.findAll();
    }

    @GetMapping("/badCreate")
    public void badCreate(){
	    userService.badCreate();
    }
}
