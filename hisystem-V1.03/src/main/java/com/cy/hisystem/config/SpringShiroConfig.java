package com.cy.hisystem.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SpringShiroConfig {

	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
		return sManager;
	}

	/**
	 * 访问过滤
	 * @param securityManager
	 * @return
	 */
	@Bean("shiroFilterFactoryBean")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean sfBean = new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		sfBean.setLoginUrl("/doLogin");
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("/css/**", "anon");
		map.put("/error/**", "anon");
		map.put("/images/**", "anon");
		map.put("/js/**", "anon");
		map.put("/sb-admin-2/**", "anon");
		map.put("/email/**", "anon");
		map.put("/login", "anon");
		map.put("/activation", "anon");
		map.put("/**", "authc");
		
		sfBean.setFilterChainDefinitionMap(map);
		return sfBean;
	}

}
