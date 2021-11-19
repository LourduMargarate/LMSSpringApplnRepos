package com.mph.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Book> getBookList() {
		// Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(this.getBook(null));

		Query qry = getSession().createQuery("from Book");
		List<Book> booklist = qry.list();
		return booklist;
	}

	@Override
	public Book getBook(Book book) {
//		Criteria p = getSession().createCriteria(Supplier.class);
		Criteria c = getSession().createCriteria(Book.class);
		// c.add(Restrictions.eq("email", supplier.getEmail()));
		Book books = (Book) c.uniqueResult();

		return books;
	}

	@Override
	public void createBook(Book book) {
		// Date date2 = new
		// SimpleDateFormat("dd/MM/yyyy").parse(book.getPublish_Date());
		// Timestamp sqlTimestamp = new Timestamp(book.getPublish_Date());
		// SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Timestamp s=Timestamp.valueOf(formatter.format(book.getPublish_Date()));
		// book.setPublish_Date(s);

		// book.setSupplier(sup);
		// getSession().saveOrUpdate(sup);
		getSession().saveOrUpdate(book);
		System.out.println("Book Stored Successfully :)");
		System.out.println("book->" + book);
//	System.out.println("book->"+book.getSupplier());
	}

	@Override
	public List<Book> updateBook(Book book) {
		Query qry = getSession().createQuery(
				"update Book set title=:tit,author=:auth,category=:cat,publication=:pub,publish_Date=:pubDate where book_Id=:bookid");
		qry.setParameter("tit", book.getTitle());
		qry.setParameter("auth", book.getAuthor());
		qry.setParameter("cat", book.getCategory());
		qry.setParameter("pub", book.getPublication());
		qry.setParameter("pubDate", book.getPublish_Date());
		qry.setParameter("bookid", book.getBook_Id());

		// qry.setParameter("con", book.get());

		int noofrows = qry.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Update is successful !!!");
		}
		return getBookList();
	}

	@Override
	public List<Book> deleteBook(int bid) {
		Query qry1 = getSession().createQuery("delete BookIssue bi where bi.book.book_Id=:bid");

		qry1.setParameter("bid", bid);
		int noofrows1 = qry1.executeUpdate();
		Query qry = getSession().createQuery("delete Book where book_Id=:bid");
		qry.setParameter("bid", bid);
		int noofrows = qry.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + bid + "successfully !!!");
		}
		return getBookList();
	}

	@Override
	public Book getBookById(int bid) {
		Query query = getSession().createQuery("from Book book where book_Id=:bno");
		query.setParameter("bno", bid);
		Book books = (Book) query.uniqueResult();
		;
		System.out.println(books);
		return books;
	}

	@Override
	public Book getBookByTitle(String bTitle) {
		Query query = getSession().createQuery("from Book book where  title=:bname");
		query.setParameter("bname", bTitle);
		Book books = (Book) query.uniqueResult();
		System.out.println(books);
		return books;
	}

}
