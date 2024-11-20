package mao.demo;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import mao.demo.Mapper.UserMapper;
import mao.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelect() {
		//System.out.println(userMapper.insert(new User(888L,"maoyunlong",25,"1026225160@qq.com")));
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		System.out.println("user:"+userMapper.selectById(5));
		Assert.isTrue(5 == userList.size(), "");
		userList.forEach(System.out::println);
	}
}
