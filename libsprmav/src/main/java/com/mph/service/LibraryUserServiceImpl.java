package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.LibraryUserDao;
import com.mph.entity.LibraryUser;

@Service
@Transactional
public class LibraryUserServiceImpl implements LibraryUserService{
    @Autowired
    LibraryUserDao libraryUserDao;
	@Override
	public List<LibraryUser> getLibraryUserList() {
		// TODO Auto-generated method stub
		return libraryUserDao.getLibraryUserList();
	}

	@Override
	public LibraryUser getLibraryUser(LibraryUser libraryUser) {
		
		return libraryUserDao.getLibraryUser(libraryUser);
	}

	@Override
	public void createLibraryUser(LibraryUser libraryUser) {
		libraryUserDao.createLibraryUser(libraryUser);
		
	}

	@Override
	public List<LibraryUser> updateLibraryUser(LibraryUser libraryUser) {
		
		return libraryUserDao.updateLibraryUser(libraryUser);
	}

	@Override
	public List<LibraryUser> deleteLibraryUser(int userId) {
		
		return libraryUserDao.deleteLibraryUser(userId);
	}

	@Override
	public LibraryUser getLibraryUserById(int userId) {
		
		return libraryUserDao.getLibraryUserById(userId);
	}

	@Override
	public LibraryUser getLibraryUserByName(String name) {
		
		return libraryUserDao.getLibraryUserByName(name);
	}
}
