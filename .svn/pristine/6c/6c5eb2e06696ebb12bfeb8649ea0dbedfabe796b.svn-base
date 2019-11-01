package com.cy.hisystem.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.hisystem.dao.UserDao;
import com.cy.hisystem.exception.ServiceException;
import com.cy.hisystem.pojo.UserPojo;

@Service
public class ShiroUserRealm extends AuthorizingRealm {
	
	@Autowired
	UserDao userDao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		String email = upToken.getUsername();
		UserPojo userPojo = userDao.findUserAccountByEamil(email);
		if (userPojo == null) {
			throw new ServiceException("用户名不正确！");
		}
		Integer emailStatus = userPojo.getEmailStatus();
		if (emailStatus == 0) {
			throw new ServiceException("此用户尚未通过邮箱验证！");
		} 
		
		
		return null;
	}

	@Override
	public void setCredentialsMatcher(
	    CredentialsMatcher credentialsMatcher) {
		//构建凭证匹配对象
		HashedCredentialsMatcher cMatcher=
		new HashedCredentialsMatcher();
		//设置加密算法
		cMatcher.setHashAlgorithmName("MD5");
		//设置加密次数
		cMatcher.setHashIterations(1);
		super.setCredentialsMatcher(cMatcher);
	}

	
	
}
