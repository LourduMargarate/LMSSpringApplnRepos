package com.mph.service;

import java.util.List;

import com.mph.entity.BookIssue;

public interface BookIssueService {
	public List<BookIssue> getBookIssueList();
	public BookIssue getBookIssue(BookIssue bookIssue);
	public void createBookIssue(BookIssue bookIssue);
	public List<BookIssue> updateBookIssue(BookIssue bookIssue);
	public List<BookIssue> deleteBookIssue(int bissue_Id);
	public BookIssue getBookIssueById(int bissue_Id);
	public List<BookIssue> getBookIssuebyuid();
	public List<BookIssue> updateBookReturn(BookIssue bookIssue);
}
