package com.mph.entity;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="BOOKTABLE")
public class Book {
@Id
@SequenceGenerator(name = "BOOK_SEQ",sequenceName = "book_seq",
initialValue = 1, allocationSize = 100)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_SEQ")
private int book_Id;
@Column	
private String title;
@Column	
private String author;
@Column	
private String category;
@Column	
private String publication;
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-mm-dd")
@Column	
private Date publish_Date;





/*@JoinTable(name = "BOOK_BOOKISUE")
@ManyToOne
//@JoinColumn(name="bookid")
private BookIssue bookisu;
*/
public Book() {
	super();
	// TODO Auto-generated constructor stub
}





public Book(int book_Id, String title, String author, String category, String publication, Date publish_Date) {
	super();
	this.book_Id = book_Id;
	this.title = title;
	this.author = author;
	this.category = category;
	this.publication = publication;
	this.publish_Date = publish_Date;
}





public int getBook_Id() {
	return book_Id;
}





public void setBook_Id(int book_Id) {
	this.book_Id = book_Id;
}





public String getTitle() {
	return title;
}





public void setTitle(String title) {
	this.title = title;
}





public String getAuthor() {
	return author;
}





public void setAuthor(String author) {
	this.author = author;
}





public String getCategory() {
	return category;
}





public void setCategory(String category) {
	this.category = category;
}





public String getPublication() {
	return publication;
}





public void setPublication(String publication) {
	this.publication = publication;
}





public Date getPublish_Date() {
	return publish_Date;
}





public void setPublish_Date(Date publish_Date) {
	this.publish_Date = publish_Date;
}





@Override
public String toString() {
	return "Book [book_Id=" + book_Id + ", title=" + title + ", author=" + author + ", category=" + category
			+ ", publication=" + publication + ", publish_Date=" + publish_Date + "]";
}














}