package com.cy.hisystem.service;

import javax.mail.MessagingException;

/**
 * 发送邮件的接口
 *
 * @author 吴凯强
 */
public interface EmailService {
	
	 /**
     * 
     * @param toEmail 收件人地址
     * @param title 邮件标题
     * @param template 邮件正文html地址
     * @throws MessagingException
     */
	public void sendEmail(String toEmail,String title,String template) throws MessagingException;
	
    /**
     * @param name 网页返回的参数名
     * @param value 网页返回的参数值
     */
    public void setVariable(String name ,String value );
}
