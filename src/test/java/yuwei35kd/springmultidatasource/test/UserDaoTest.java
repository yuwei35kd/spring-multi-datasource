package yuwei35kd.springmultidatasource.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import yuwei35kd.springmultidatasource.SpringMultiDatasourceApplication;
import yuwei35kd.springmultidatasource.bean.User;
import yuwei35kd.springmultidatasource.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringMultiDatasourceApplication.class})
public class UserDaoTest{
	private static UserService userService;
	
	@Resource
    public void setUserService(UserService userService) {  
		UserDaoTest.userService = userService;  
    }  
	
	@Test
	public void testSource1(){
		List<Map<String,Object>> users = userService.findUsers1();
		int id = (int) users.get(0).get("user_id");
		Assert.assertTrue(id==1);
	}
	
	@Test
	public void testSource2(){
		List<Map<String,Object>> users = userService.findUsers2();
		int id = (int) users.get(0).get("user_id");
		Assert.assertTrue(id==2);
	}
	
	@Test
	public void testTransactional(){
		User user = new User();
		user.setUserId(3);
		user.setName("u3");
		userService.create(user);
	} 
	
	@Test
	public void testTransactional2(){
		User user = new User();
		user.setUserId(4);
		user.setName("u4");
		userService.create2(user);
	}
	
	/*@AfterClass
	public static void clear(){
		userService.clearInit();
	}*/
}
