package com.mph.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.BookIssueDao;
import com.mph.entity.BookIssue;



@Service
@Transactional
public class BookIssueServiceImpl implements BookIssueService{
	@Autowired
	BookIssueDao bookIssueDao;

	@Override
	public List<BookIssue> getBookIssueList() {
	 return	bookIssueDao.getBookIssueList();
	}
	
	@Override
	public List<BookIssue> getBookIssuebyuid() {
	 return	bookIssueDao.getBookIssueByUid();
	}

	@Override
	public BookIssue getBookIssue(BookIssue bookIssue) {
		
		return bookIssueDao.getBookIssue(bookIssue);
	}

	@Override
	public void createBookIssue(BookIssue bookIssue) {
		bookIssueDao.createBookIssue(bookIssue);
		
	}

	@Override
	public List<BookIssue> updateBookIssue(BookIssue bookIssue) {
		
		return bookIssueDao.updateBookIssue(bookIssue);
	}

	@Override
	public List<BookIssue> updateBookReturn(BookIssue bookIssue) {
		
		return bookIssueDao.updateBookReturn(bookIssue);
	}
	
	@Override
	public List<BookIssue> deleteBookIssue(int bissue_Id) {
		// TODO Auto-generated method stub
		return bookIssueDao.deleteBookIssue(bissue_Id);
	}

	@Override
	public BookIssue getBookIssueById(int bissue_Id) {
		// TODO Auto-generated method stub
		return bookIssueDao.getBookIssueById(bissue_Id);
	}

	

}
