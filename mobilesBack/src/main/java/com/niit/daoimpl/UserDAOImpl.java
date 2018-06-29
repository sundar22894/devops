package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.UserDAO;
//import com.niit.model.CartItem;
import com.niit.model.User;
@Transactional
@EnableTransactionManagement

@Repository("userDAO")

public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	

	@Transactional
	//@Override
	public boolean addUser(User user) {
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	
	}
    @Transactional
	//@Override
	public boolean deleteUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}

	
	
	}
    @Transactional
	//@Override
	public boolean updateUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	
	}

	//@Override
	public User getUser(int userId) {
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,userId);
		session.close();
		return user;
	}

	//@Override
	public List<User> getUser() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> listUser=(List<User>)query.list();
		return listUser;

		
	}
	
		
	
		@Transactional
	public User get(String username)
	{
		String hql = "from User where username= "+" '" +username+ "'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();
		if(list == null || list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	@Transactional
	public boolean isValidUser(String username, String password) {
		System.out.println("dao impl");
		String hql ="from User where username= '" + username + "' and " + " password ='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		if(list != null && !list.isEmpty())
		{
		
			return true;
		}
		return false;

	}

	@Transactional
	public User getCustomerByUsername(String username) {

		String hql = "from User where username=" + "'" + username + "'";
		
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
	List<User> listOfCustomers = query.list();
		
	if (listOfCustomers != null && !listOfCustomers.isEmpty()){

		return  listOfCustomers.get(0);

	}
	return null;
	}
	
	@Transactional
	public boolean save(User user)
	{
	try {
		 Session session = sessionFactory.getCurrentSession();
		
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		
		
//		    CartItem newCart = new CartItem();
//	        newCart.setUser(user);
//	        user.setCartItem(newCart);
//	        session.saveOrUpdate(user);
//	        session.saveOrUpdate(newCart);

	        session.flush();
		
		return true;

	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		return false;
	}

   }
	
}	