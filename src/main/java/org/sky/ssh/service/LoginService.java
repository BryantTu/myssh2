package org.sky.ssh.service;

public interface LoginService {
	public boolean login(String loginId, String loginPwd) throws Exception;
}
