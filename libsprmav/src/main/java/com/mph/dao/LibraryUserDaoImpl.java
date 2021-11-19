package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Book;
import com.mph.entity.BookIssue;
import com.mph.entity.LibraryUser;

@Repository
public class LibraryUserDaoImpl implements LibraryUserDao {
    
	@Autowired
	private SessionFactory sessionFactory;
	

	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<LibraryUser> getLibraryUserList() {

		Query qry = getSession().createQuery("from LibraryUser");
		List<LibraryUser> userList = qry.list();
		return userList;

	}
	



	@Override
	public LibraryUser getLibraryUser(LibraryUser libraryUser) {
		Criteria c = getSession().createCriteria(LibraryUser.class);
		//c.add(Restrictions.eq("email", supplier.getEmail()));
		LibraryUser user= (LibraryUser)c.uniqueResult();
		
		return user;
	}

	@Override
	public void createLibraryUser(LibraryUser libraryUser) {
		getSession().saveOrUpdate(libraryUser);
		System.out.println("User Stored Successfully :)");
	System.out.println("User->"+libraryUser);
		
	}

	@Override
	public List<LibraryUser> updateLibraryUser(LibraryUser libraryUser) {
		Query qry = getSession().createQuery("update LibraryUser set name=:nam,email=:mail,gender=:gen,phno=:ph where userid=:userId");
		qry.setParameter("nam",libraryUser.getName());
		qry.setParameter("mail",libraryUser.getEmail() );
		qry.setParameter("userId", libraryUser.getUserid());
		qry.setParameter("gen", libraryUser.getGender());
		qry.setParameter("ph", libraryUser.getPhno());
		
		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Update is successful !!!");
		}
		return getLibraryUserList();
	}


	

	@Override
	public List<LibraryUser> deleteLibraryUser(int userId) {
   Query qry1 = getSession().createQuery("delete BookIssue bi where bi.libuser.userid=:uid");    
        
        qry1.setParameter("uid", userId);        
        int noofrows1 = qry1.executeUpdate();
		Query qry = getSession().createQuery("delete LibraryUser where userid=:uid");		
		qry.setParameter("uid",userId );		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + userId + "successfully !!!");
		}
		return getLibraryUserList();
	}

	@Override
	public LibraryUser getLibraryUserById(int userId) {
		Query query = getSession().createQuery("from LibraryUser user where userid=:id");
		query.setParameter("id", userId);
		LibraryUser users = (LibraryUser)query.uniqueResult();
		System.out.println(users);
		return users;
	}

	@Override
	public LibraryUser getLibraryUserByName(String name) {
		Query query = getSession().createQuery("from LibraryUser user where name=:na");
		query.setParameter("na", name);
		LibraryUser users = (LibraryUser)query.uniqueResult();
		System.out.println(users);
		return users;
	}
}
