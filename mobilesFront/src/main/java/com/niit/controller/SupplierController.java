package com.niit.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;


@Controller
public class SupplierController {
	
	@Autowired
	SupplierDAO supplierDAO;
	
	boolean flag = true;
	
	@RequestMapping("/Supplier")
	public String showSupplier(Model m) {
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		   
		for (Supplier supplier : listSuppliers) {
			System.out.println(supplier.getSupplierName() + ",");
		}
		flag = false;
		return "Supplier";
	}
	@RequestMapping(value = "/InsertSupplier", method = RequestMethod.POST)
	public String insertSupplierData(@RequestParam("supname") String supname, @RequestParam("supdesc") String supdesc,
			Model m) {
		Supplier supplier = new Supplier();
		supplier.setSupplierName(supname);
		supplier.setSupplierDesc(supdesc);

		supplierDAO.addSupplier(supplier);

	List<Supplier> listSuppliers = supplierDAO.getSuppliers();
	m.addAttribute("listSuppliers", listSuppliers);
	flag = false;
	return "Supplier";
	}
	@RequestMapping("/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers",listSuppliers);
		flag=false;
		return "Supplier";
	}
	@RequestMapping("/updateSupplier/{supplierId}")
	public String updateSupplier(@PathVariable("supplierId") int supplierID,Model m)
	{
		
		Supplier supplier=supplierDAO.getSupplier(supplierID);
		
		
		List<Supplier> listSuppliers=supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers",listSuppliers);
		m.addAttribute("supplierInfo",supplier);
		
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateSupplierInDB(@RequestParam("supid") int SupplierId,@RequestParam("supname") String supplierName,
			@RequestParam("supdesc") String supplierDesc,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(SupplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDesc(supplierDesc);
		
		supplierDAO.updateSupplier(supplier);
		List<Supplier> listSuppliers=supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers",listSuppliers);
		
		return "Supplier";
	}

}
	


