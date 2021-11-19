package com.mph.dao;

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
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Book;
import com.mph.entity.BookIssue;



@Repository
public class BookIssueDaoImpl implements BookIssueDao{
	@Autowired
	private SessionFactory sessionFactory;
	

	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}


	@Override
	public List<BookIssue> getBookIssueList() {

		Query qry = getSession().createQuery("from BookIssue");
		List<BookIssue> bookIssueList = qry.list();
		return bookIssueList;
	}

	@Override
	public List<BookIssue> getBookIssueByUid() {

		Query qry = getSession().createQuery("select bi.issueNo,bi.status,bi.issueDate,bi.returnWithinDate,bi.actualReturnedDate,u.userid,u.name,b.book_Id,b.title from BookIssue bi join bi.libuser u join bi.book b on bi.libuser.userid=u.userid");
		List<BookIssue> bookIssueList = qry.list();
		return bookIssueList;
	}

	@Override
	public BookIssue getBookIssue(BookIssue bookIssue) {
		Criteria c = getSession().createCriteria(BookIssue.class);
		//c.add(Restrictions.eq("email", supplier.getEmail()));
		BookIssue bookIs= (BookIssue)c.uniqueResult();
		
		
		
		return bookIs;
	}


	@Override
	public void createBookIssue(BookIssue bookIssue) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(bookIssue);
		System.out.println("Book Issue Stored Successfully :)");
	     System.out.println("book->"+bookIssue);
	}

	

	@Override
	public List<BookIssue> updateBookIssue(BookIssue bookIssue) {
		Query qry = getSession().createQuery("update BookIssue set issueDate=:iDate,returnWithinDate=:rwDate where issueNo=:iNo");
		qry.setParameter("iDate", bookIssue.getIssueDate());
		qry.setParameter("rwDate", bookIssue.getReturnWithinDate());
		qry.setParameter("iNo", bookIssue.getIssueNo());
		
		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Update is successful !!!");
		}
		return getBookIssueList();
	}

	@Override
	public List<BookIssue> updateBookReturn(BookIssue bookIssue) {
		Query qry = getSession().createQuery("update BookIssue set actualReturnedDate=:arDate,status=:sta where book_Id=:bid AND userid=:uid");
		qry.setParameter("arDate", bookIssue.getActualReturnedDate());
		qry.setParameter("sta", bookIssue.getStatus());
		qry.setParameter("bid", bookIssue.getBook().getBook_Id());
		qry.setParameter("uid", bookIssue.getLibuser().getUserid());
		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Update is successful !!!");
		}
		return getBookIssueList();
	}

	@Override
	public List<BookIssue> deleteBookIssue(int bissue_Id) {
		Query qry = getSession().createQuery("delete BookIssue where issueNo=:iNo");		
		qry.setParameter("iNo",bissue_Id );		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + bissue_Id + "successfully !!!");
		}
		return getBookIssueList();
	}


	@Override
	public BookIssue getBookIssueById(int bissue_Id) {
		Query query = getSession().createQuery("from BookIssue bookIs where issueNo=:iNo");
		query.setParameter("iNo",bissue_Id );
		BookIssue bookIssue = (BookIssue)query.uniqueResult();;
		System.out.println(bookIssue);
		return bookIssue;
	}


	


	
	
}
