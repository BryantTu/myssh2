package org.sky.ssh.vo;

import java.io.Serializable;

public class StudentVO implements Serializable
{

	private static final long serialVersionUID = 1L;

	private String studentNo;
	
    private String studentName;

	public String getStudentNo()
	{
		return studentNo;
	}

	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}

	public String getStudentName()
	{
		return studentName;
	}

	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
    
    
}

