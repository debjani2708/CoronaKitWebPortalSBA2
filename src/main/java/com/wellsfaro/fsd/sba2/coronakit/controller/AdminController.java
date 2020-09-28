package com.wellsfaro.fsd.sba2.coronakit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfaro.fsd.sba2.coronakit.entity.ProductMaster;
import com.wellsfaro.fsd.sba2.coronakit.exception.CoronaKitException;
import com.wellsfaro.fsd.sba2.coronakit.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/home")
	public String home() {
		return "admin-home";
	}
	
	@GetMapping("/product-entry")
	public ModelAndView productEntry() throws CoronaKitException {
		ModelAndView mv = new ModelAndView("add-new-item","product",new ProductMaster());
		mv.addObject("New Products",true);
		return mv;
	}
	
	@PostMapping("/product-save")
	public ModelAndView productSave(@ModelAttribute("product") @Valid ProductMaster product, BindingResult result) throws CoronaKitException {
		
		ModelAndView mv = null;
		if(result.hasErrors()) {
			mv = new ModelAndView("add-new-item","product",product);
		}else {
			productService.addNewProduct(product);
			mv = new ModelAndView("admin-home","msg","Product is saved successfully");
		}
		
		return mv;
	}
	

	@GetMapping("/product-list")
	public ModelAndView productList() throws CoronaKitException {
		return new ModelAndView("show-all-item-admin","products",productService.getAllProducts());
	}

	@GetMapping("/product-delete")
	public ModelAndView productDelete(@RequestParam("productId") int productId) throws CoronaKitException {
		productService.deleteProduct(productId);
        return new ModelAndView("admin-home","msg","Product is deleted successfully");
	}
	
}
