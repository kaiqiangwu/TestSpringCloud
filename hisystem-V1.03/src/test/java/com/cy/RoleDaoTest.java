package com.cy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.hisystem.dao.RoleDao;
import com.cy.hisystem.dao.UserDao;
import com.cy.hisystem.dao.UserRoleDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDaoTest {

	@Autowired
	UserDao userDao;
	@Autowired
	UserRoleDao userRoleDao;
	@Autowired
	RoleDao roleDao; 
	
	@Test 
	public void testFindRoleByRoleId() {
		String userId = userDao.findIdByEmail("1208585122@qq.com");
		System.out.println(userId);
		List<String> roleIds = userRoleDao.fiadRoleIdByUserId(userId);
		System.out.println("----------------");
		for (String roleId : roleIds) {
			System.out.println(roleId);
		}
		System.out.println("--------------------");
		List<String> roles = roleDao.findRoleByRoleId(roleIds);
		for (String r : roles) {
			System.out.println(r);
		}
	}
	
	
}
