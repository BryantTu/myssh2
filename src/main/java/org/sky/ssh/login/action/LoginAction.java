package org.sky.ssh.login.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.sky.ssh.service.LoginService;
import org.sky.ssh.util.Constants;
import org.sky.ssh.util.session.UserSessionInfo;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware
{
	private static final long serialVersionUID = 1L;

	protected final Log logger = LogFactory.getLog(getClass());

	private Map att;

	private HttpServletRequest request = null;

	private HttpServletResponse response;

	@Resource
	LoginService loginService;

	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}

	public void setSession(Map att)
	{
		this.att = att;
	}

	public String execute() throws Exception
	{
		String loginId = "";
		String loginPwd = "";
		HttpSession session = request.getSession();
		String loginCode = "100";
		try
		{
			loginId = (String) request.getParameter("loginId");
			loginPwd = (String) request.getParameter("loginPwd");
			if (loginService.login(loginId, loginPwd))
			{
				UserSessionInfo uinfo = new UserSessionInfo();
				uinfo.setLoginId(loginId);
				session.setAttribute(Constants.USER_SESSION, uinfo);
			}
			else
			{
				loginCode = "101";
			}
			request.setAttribute("loginCode", loginCode);
			if (!loginCode.equals("100"))
			{
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login/login.jsp");
//				dispatcher.forward(request, response);
				return LOGIN;
			}
			return SUCCESS;
		}
		catch (Exception e)
		{
			logger.error("UserLogin Exception:" + e.getMessage(), e);
			throw new Exception("UserLogin Exception:" + e.getMessage(), e);
		}
	}
}