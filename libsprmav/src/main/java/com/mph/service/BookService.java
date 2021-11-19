package com.mph.service;

import java.util.List;

import com.mph.entity.Book;


public interface BookService {
	public List<Book> getBookList();
	public Book getBook(Book book);
	public void createBook(Book book);
	public List<Book> updateBook(Book book);
	public List<Book> deleteBook(int bid);
	public Book getBookById(int bid);
	public Book getBookByTitle(String bTitle);
}
