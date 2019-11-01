package com.cy.hisystem.vo;

import java.io.Serializable;
/**
 * 
 * @author 肖家睿 李溢
 * Json字符串类
 */
public class JsonResult implements Serializable {
	private static final long serialVersionUID = 5526409111149902317L;
	/** 状态码 */
	/**1表示SUCCESS,0表示ERROR*/
	private int state = 1;
	/** 状态信息 */
	private String message = "ok";
	/** 正确数据 */
	private Object data;
	
//	private Integer totalElementsNumber=8;
	
	private Integer pageNumber=1;

	public JsonResult(String message) {
		this.message = message;
	}

	public JsonResult(Object data) {
		this.data = data;
	}
	
	public JsonResult(Object data,Integer pageNumber) {
		this.data = data;
//		this.totalElementsNumber=totalElementsNumber;
		this.pageNumber=pageNumber;
	}

	public JsonResult(int state) {
		this.state = state;
	}
	
	/**封装异常数据*/
	public JsonResult(Throwable e) {
		this.state = 0;
		this.message = e.getMessage();
	}
	
	public JsonResult() {
    }
	
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
	
}
