package com.mph.dao;

import java.util.List;

import com.mph.entity.Book;
import com.mph.entity.BookIssue;

public interface BookIssueDao {
	public List<BookIssue> getBookIssueList();
	public BookIssue getBookIssue(BookIssue bookIssue);
	public void createBookIssue(BookIssue bookIssue);
	public List<BookIssue> updateBookIssue(BookIssue bookIssue);
	public List<BookIssue> deleteBookIssue(int bissue_Id);
	public BookIssue getBookIssueById(int bissue_Id);
	public List<BookIssue> getBookIssueByUid();
	public List<BookIssue> updateBookReturn(BookIssue bookIssue);
}
