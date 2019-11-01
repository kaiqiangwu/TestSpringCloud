package com.cy;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.hisystem.service.EmailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailUtilTest {

	@Autowired
	EmailService emailService;
	
	@Test
	public void testSendEmail() {
		emailService.setVariable("email", "1136168808@qq.com");
		emailService.setVariable("validateCode", "afdasasfasfasfas23452");
		
		try {
			emailService.sendEmail("1136168808@qq.com", "账号激活","email/email");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
}
