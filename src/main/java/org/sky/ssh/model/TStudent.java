package org.sky.ssh.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the T_STUDENT database table.
 * 
 */
@Entity
@Table(name="T_STUDENT")
@NamedQuery(name="TStudent.findAll", query="SELECT t FROM TStudent t")
public class TStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_STUDENT_STUID_GENERATOR", sequenceName="SQL_STUDENT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_STUDENT_STUID_GENERATOR")
	private long stuid;

	private BigDecimal age;

	private String name;

	private String sex;

	public TStudent() {
	}

	public long getStuid() {
		return this.stuid;
	}

	public void setStuid(long stuid) {
		this.stuid = stuid;
	}

	public BigDecimal getAge() {
		return this.age;
	}

	public void setAge(BigDecimal age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}