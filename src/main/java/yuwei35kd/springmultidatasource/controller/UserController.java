package yuwei35kd.springmultidatasource.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yuwei35kd.springmultidatasource.mapper.UserMapper;

@RestController
public class UserController {
	@Resource
	private UserMapper userMapper;
	
	@RequestMapping("findUser")
	public List<Map<String,Object>> findUser(){
		return userMapper.findUsers();
	}
}
