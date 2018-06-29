package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addSupplier(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().save(supplier);
	    
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public Supplier getSupplier(int supplierId) {
		
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
		session.close();
		return supplier;
	}

	@Transactional
	public boolean deleteSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	public List<Supplier> getSuppliers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> listSuppliers=(List<Supplier>)query.list();
		return listSuppliers;
	}

}
