package org.sky.ssh.dao;


public interface LoginDAO {
	public long validLogin(String loginId, String loginPwd) throws Exception;
}
