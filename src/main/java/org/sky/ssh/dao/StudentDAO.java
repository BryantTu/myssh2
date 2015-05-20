package org.sky.ssh.dao;

import java.util.List;

import org.sky.ssh.model.TStudent;

public interface StudentDAO {

	public List<TStudent> getAllStudent() throws Exception;

	public void addStudent(String studentName) throws Exception;

	public void delStudent(TStudent std) throws Exception;
	
	public void updateStudent(TStudent student) throws Exception;
	
	public TStudent getStudent(Long stuNo) throws Exception;
}
