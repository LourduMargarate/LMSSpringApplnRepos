package com.mph.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

@Entity

public class BookIssue {
@Id	
@SequenceGenerator(name = "BOOKIS_SEQ",sequenceName = "bookis_seq",
initialValue = 1, allocationSize = 100)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKIS_SEQ")
private int issueNo;
private String status;
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-mm-dd")
private Date issueDate;
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-mm-dd")
private Date returnWithinDate;

@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-mm-dd")
private Date actualReturnedDate;




//private String fineRange;

//@OneToMany(cascade=CascadeType.REMOVE)
//@JoinColumn(name="bid") 
//@JoinTable(name="BOOK_BOOKIS", joinColumns={@JoinColumn(name="isuno", referencedColumnName="issueNo")}
//, inverseJoinColumns={@JoinColumn(name="BOOKiD", referencedColumnName="book_Id")})
//@OneToMany//(targetEntity=Book.class,cascade=CascadeType.REMOVE)
//@JoinColumn(name="issueid")
@OneToOne(cascade=CascadeType.REMOVE)
@JoinColumn(name="BOOK_ID")
/**
 * Book_Id is foreign key which references to BOOK_ID Column in Book Entity 
 */
private Book book;  
//private Book book;//---->column name(foreign key name=DEPTID)
//@OneToOne
//private Book book;
@OneToOne(cascade=CascadeType.REMOVE)
@JoinColumn(name="USERID")
/**
 * userid is foreign key which references to USERID Column in LibraryUser Entity
 */
private LibraryUser libuser;
//---->column name(foreign key name=DEPTID)

/**
 * BookIssue() is SuperClass Constructor
 */
public BookIssue() {
	super();
	// TODO Auto-generated constructor stub
}


/**
 * BookIssue(int issueNo, String status, Date issueDate, Date returnWithinDate, Date actualReturnedDate, Book book,
		LibraryUser libuser)  is Fields Constructor
 * @param issueNo
 * @param status
 * @param issueDate
 * @param returnWithinDate
 * @param actualReturnedDate
 * @param book
 * @param libuser
 */

public BookIssue(int issueNo, String status, Date issueDate, Date returnWithinDate, Date actualReturnedDate, Book book,
		LibraryUser libuser) {
	super();
	this.issueNo = issueNo;
	this.status = status;
	this.issueDate = issueDate;
	this.returnWithinDate = returnWithinDate;
	this.actualReturnedDate = actualReturnedDate;
	this.book = book;
	this.libuser = libuser;
}







public int getIssueNo() {
	return issueNo;
}
public void setIssueNo(int issueNo) {
	this.issueNo = issueNo;
}



public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Date getIssueDate() {
	return issueDate;
}
public void setIssueDate(Date issueDate) {
	this.issueDate = issueDate;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
public LibraryUser getLibuser() {
	return libuser;
}
public void setLibuser(LibraryUser libuser) {
	this.libuser = libuser;
}

public Date getReturnWithinDate() {
	return returnWithinDate;
}

public void setReturnWithinDate(Date returnWithinDate) {
	this.returnWithinDate = returnWithinDate;
}



public Date getActualReturnedDate() {
	return actualReturnedDate;
}



public void setActualReturnedDate(Date actualReturnedDate) {
	this.actualReturnedDate = actualReturnedDate;
}







@Override
public String toString() {
	return "BookIssue [issueNo=" + issueNo + ", status=" + status + ", issueDate=" + issueDate + ", returnWithinDate="
			+ returnWithinDate + ", actualReturnedDate=" + actualReturnedDate + ", book=" + book + ", libuser="
			+ libuser + "]";
}











}
