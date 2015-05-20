package org.sky.ssh.index.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.sky.ssh.service.StudentService;
import org.sky.ssh.vo.StudentVO;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware
{
	private static final long serialVersionUID = 1L;

	private Map att;

	private HttpServletRequest request = null;

	private HttpServletResponse response;

	private List<StudentVO> stdList = new ArrayList<StudentVO>();

	private StudentVO studentVO = new StudentVO();

	public StudentVO getStudentVO()
	{
		return studentVO;
	}

	public void setStudentVO(StudentVO studentVO)
	{
		this.studentVO = studentVO;
	}

	public List<StudentVO> getStdList()
	{
		return stdList;
	}

	public void setStdList(List<StudentVO> stdList)
	{
		this.stdList = stdList;
	}

	@Resource
	private StudentService stdService = null;

	protected final Log logger = LogFactory.getLog(getClass());

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

	public String indexInit() throws Exception
	{
		try
		{
			stdList = stdService.getAllStudent();
			return SUCCESS;
		}
		catch (Exception e)
		{
			logger.error("Init Index Exception:" + e.getMessage(), e);
			throw new Exception("Init Index Exception:" + e.getMessage(), e);
		}
	}

	public String popUpdateStudent() throws Exception
	{
		String stuId = request.getParameter("studentId");
		if (stuId != null)
		{
			studentVO = stdService.getStudent(Long.parseLong(stuId));
		}
		return "forward";
	}

	public String addStudent() throws Exception
	{
		try
		{
			stdService.addStudent(studentVO.getStudentName());
		}
		catch (Exception e)
		{
			logger.error("addStudent error:" + e.getMessage(), e);
			throw new Exception("addStudent error:" + e.getMessage(), e);
		}
		return SUCCESS;
	}

	public String delStudent() throws Exception
	{
		String[] stdArray = null;
		try
		{
			stdArray = request.getParameterValues("selectedStudents");
			if (stdArray != null && stdArray.length > 0)
			{
				stdService.delStudent(stdArray);
			}
		}
		catch (Exception e)
		{
			logger.error("delStudent error:" + e.getMessage(), e);
			throw new Exception("delStudent error:" + e.getMessage(), e);
		}
		return SUCCESS;
	}

	public String updateStudent() throws Exception
	{
		if (studentVO.getStudentNo() != null)
		{
			stdService.updateStudent(studentVO);
		}
		return SUCCESS;
	}
}