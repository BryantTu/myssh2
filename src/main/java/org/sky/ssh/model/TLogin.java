package org.sky.ssh.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the T_LOGIN database table.
 * 
 */
@Entity
@Table(name="T_LOGIN")
@NamedQuery(name="TLogin.findAll", query="SELECT t FROM TLogin t")
public class TLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOGIN_ID")
	private String loginId;

	@Column(name="LOGIN_PWD")
	private String loginPwd;

	public TLogin() {
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

}