package org.sky.ssh.dao.impl;

import org.sky.ssh.dao.BaseHibernateDaoSupport;
import org.sky.ssh.dao.LoginDAO;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

@Repository
public class LoginDAOImpl extends BaseHibernateDaoSupport implements LoginDAO
{

	public long validLogin(String loginId, String loginPwd) throws Exception
	{
		Long count = new Long(0);
		String sql = "select count(tl.loginId) from TLogin as tl where tl.loginId=:loginId and tl.loginPwd=:loginPwd ";
		Query query = super.getSession().createQuery(sql);
		query.setString("loginId", loginId);
		query.setString("loginPwd", loginPwd);
		count = (Long) query.list().get(0);
		return count;
	}

}
