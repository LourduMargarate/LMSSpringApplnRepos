package com.mph.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class LibraryUser {
	@Id
	@SequenceGenerator(name = "LIBUSER_SEQ", sequenceName = "libuser_seq", initialValue = 1, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIBUSER_SEQ")
	private int userid;
	private String name;
	private String gender;
	private String email;
	private long phno;


	

	public LibraryUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public LibraryUser(int userid, String name, String gender, String email, long phno) {
		super();
		this.userid = userid;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phno = phno;
	}



	public int getUserid() {
		return userid;
	}

	public void setUserid(int uid) {
		this.userid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public long getPhno() {
		return phno;
	}



	public void setPhno(long phno) {
		this.phno = phno;
	}



	@Override
	public String toString() {
		return "LibraryUser [userid=" + userid + ", name=" + name + ", gender=" + gender + ", email=" + email
				+ ", phno=" + phno + "]";
	}



	

}
