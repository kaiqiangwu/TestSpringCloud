package com.cy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.hisystem.dao.RegisterDao;
import com.cy.hisystem.pojo.RegisterPojo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterDaoTest {

	@Autowired
	RegisterDao registerDao;
	
	/*
	 * @Test public void testFindById() { RegisterPojo regisPojo =
	 * registerDao.findById("402880ea6a97d937016a97dfbfcf0004");
	 * System.out.println(regisPojo); }
	 */
	
}
