package com.mph.service;

import java.util.List;

import com.mph.entity.LibraryUser;

public interface LibraryUserService {
	public List<LibraryUser> getLibraryUserList();
	public LibraryUser getLibraryUser(LibraryUser libraryUser);
	public void createLibraryUser(LibraryUser libraryUser);
	public List<LibraryUser> updateLibraryUser(LibraryUser libraryUser);
	public List<LibraryUser> deleteLibraryUser(int userId);
	public LibraryUser getLibraryUserById(int userId);
	public LibraryUser getLibraryUserByName(String name);
}
