package com.mph.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.BookDao;
import com.mph.dao.BookIssueDao;
import com.mph.entity.Book;


@Service
@Transactional
public class BookServiceImpl implements BookService{
	@Autowired
	BookDao bookDao;

	@Override
	public List<Book> getBookList() {
		
		return bookDao.getBookList();
	}

	@Override
	public Book getBook(Book book) {
		
		return bookDao.getBook(book);
	}

	@Override
	public void createBook(Book book) {
		bookDao.createBook(book);
		
	}

	@Override
	public List<Book> updateBook(Book book) {
		
		return bookDao.updateBook(book);
	}

	@Override
	public List<Book> deleteBook(int bid) {
		// TODO Auto-generated method stub
		return bookDao.deleteBook(bid);
	}

	@Override
	public Book getBookById(int bid) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(bid);
	}
	@Override
	public Book getBookByTitle(String bTitle) {
		return bookDao.getBookByTitle(bTitle);
	}

	
}
