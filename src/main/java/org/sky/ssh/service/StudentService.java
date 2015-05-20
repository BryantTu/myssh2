package org.sky.ssh.service;

import java.util.List;

import org.sky.ssh.vo.StudentVO;

public interface StudentService {
	public List<StudentVO> getAllStudent() throws Exception;

	public void addStudent(String stdName) throws Exception;

	public void delStudent(String[] stdNo) throws Exception;
	
	public void updateStudent(StudentVO stdVO) throws Exception;
	
	public StudentVO getStudent(Long stuNo) throws Exception;
}
