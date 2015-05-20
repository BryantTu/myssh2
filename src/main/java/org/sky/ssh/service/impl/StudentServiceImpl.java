package org.sky.ssh.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sky.ssh.dao.StudentDAO;
import org.sky.ssh.model.TStudent;
import org.sky.ssh.service.StudentService;
import org.sky.ssh.vo.StudentVO;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService
{
	private Log logger = LogFactory.getLog(this.getClass());

	@Resource
	private StudentDAO studentDAO;

	@Override
	public List<StudentVO> getAllStudent() throws Exception
	{
		List<TStudent> stdList = new ArrayList<TStudent>();
		List<StudentVO> rtnList = new ArrayList<StudentVO>();
		stdList = studentDAO.getAllStudent();
		for (TStudent dbo : stdList)
		{
			rtnList.add(convertDB2VO(dbo));
		}
		return rtnList;
	}

	public void addStudent(String stdName) throws Exception
	{
		studentDAO.addStudent(stdName);
	}

	public void delStudent(String[] stdNo) throws Exception
	{
		for (String s : stdNo)
		{
			TStudent std = new TStudent();
			std.setStuid(Long.parseLong(s));
			studentDAO.delStudent(std);
			// throw new Exception("force system to throw a exception");
		}
	}

	@Override
	public void updateStudent(StudentVO stdVO) throws Exception
	{
		TStudent std = new TStudent();
		std.setStuid(Long.parseLong(stdVO.getStudentNo()));
		std.setName(stdVO.getStudentName());
		studentDAO.updateStudent(std);
	}

	@Override
	public StudentVO getStudent(Long stuNo) throws Exception
	{
		return convertDB2VO(studentDAO.getStudent(stuNo));
	}

	StudentVO convertDB2VO(TStudent dbo)
	{
		if (dbo == null)
		{
			return null;
		}

		StudentVO stdForm = new StudentVO();
		// BeanUtils.copyProperties(stdForm, dbo);
		stdForm.setStudentName(dbo.getName());
		stdForm.setStudentNo(String.valueOf(dbo.getStuid()));
		return stdForm;
	}
}
