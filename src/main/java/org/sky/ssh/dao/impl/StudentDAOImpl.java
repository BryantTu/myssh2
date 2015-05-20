package org.sky.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.sky.ssh.dao.BaseHibernateDaoSupport;
import org.sky.ssh.dao.StudentDAO;
import org.sky.ssh.model.TStudent;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl extends BaseHibernateDaoSupport implements StudentDAO
{

	public List<TStudent> getAllStudent() throws Exception
	{
		List<TStudent> stdList = new ArrayList<TStudent>();
		String sql = "from TStudent as s order by s.stuid desc";
		Query query = super.getSession().createQuery(sql);
		stdList = query.list();
		return stdList;
	}

	public void addStudent(String studentName) throws Exception
	{
		TStudent std = new TStudent();
		std.setName(studentName);
		this.getHibernateTemplate().save(std);
	}

	public void delStudent(TStudent std) throws Exception
	{
		this.getHibernateTemplate().delete(std);
	}

	@Override
	public void updateStudent(TStudent student) throws Exception
	{
		this.getHibernateTemplate().update(student);
	}

	@Override
	public TStudent getStudent(Long stuNo) throws Exception
	{
		return this.getHibernateTemplate().get(TStudent.class, stuNo);
	}
}
