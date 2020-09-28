package com.wellsfaro.fsd.sba2.coronakit.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wellsfaro.fsd.sba2.coronakit.entity.CoronaKit;
import com.wellsfaro.fsd.sba2.coronakit.entity.KitDetail;
import com.wellsfaro.fsd.sba2.coronakit.entity.ProductMaster;
import com.wellsfaro.fsd.sba2.coronakit.entity.UserAddress;
import com.wellsfaro.fsd.sba2.coronakit.exception.CoronaKitException;
import com.wellsfaro.fsd.sba2.coronakit.service.CoronaKitService;
import com.wellsfaro.fsd.sba2.coronakit.service.KitDetailService;
import com.wellsfaro.fsd.sba2.coronakit.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CoronaKitService coronaKitService;
	
	@Autowired
	KitDetailService kitDetailService;
	
	@RequestMapping("/home")
	public String home() {
		
		return "user-home";
	}
	
	@RequestMapping("/show-cart")
	public String showKit(HttpSession session,Model model) {
		
		List<ProductMaster> cartaddedproducts=null;
		Map<Integer,Integer> hm=new HashMap<Integer,Integer>();
		
		List<ProductMaster> Addedproductstocart=(List<ProductMaster>)session.getAttribute("cartproduct");
		if (Addedproductstocart!=null)
		{		
		 cartaddedproducts=new ArrayList<ProductMaster>();
		  session.setAttribute("Qtymap", null);
		for(ProductMaster p:Addedproductstocart)
		{
			if (hm.containsKey(p.getId()))
			{
				hm.put(p.getId(), hm.get(p.getId())+1);
			}
			else
			{
				hm.put(p.getId(), 1);
				cartaddedproducts.add(p);				
			}
		}
		session.setAttribute("Qtymap", hm);
		session.setAttribute("cartaddedproduct", cartaddedproducts);
		}
		
		return "show-cart";
	}

	@RequestMapping("/show-list")
	public String showList(Model model,HttpSession session) throws CoronaKitException {
		model.addAttribute("productlist", productService.getAllProducts());
		session.removeAttribute("cartproduct");
		session.removeAttribute("cartaddedproduct");
		session.removeAttribute("Qtymap");
		return "show-all-item-user";
	}
	
	@RequestMapping("/add-to-cart")
	public String showKit(@RequestParam("productId") int productId,HttpSession session,Model model) throws CoronaKitException {
		ProductMaster p;
		List<ProductMaster> Addedproducts;
		p=productService.getProductById(productId);
		Addedproducts= (List<ProductMaster>) session.getAttribute("cartproduct");
		if (Addedproducts==null)
		{
			Addedproducts=new ArrayList<ProductMaster>();
		}
		if(p!=null)
		{
			Addedproducts.add(p);
		}
		session.setAttribute("cartproduct", Addedproducts);
		model.addAttribute("productlist",productService.getAllProducts());
		return "show-all-item-user";
	}
	
	

	
//	@RequestMapping("/checkout")
//	public String Checkout(HttpSession session,Model model) throws ProductException {
//		KitDetail k;
//		int totalamount=0;
//		List<ProductMaster> Addedproductstocart=(List<ProductMaster>)session.getAttribute("cartaddedproduct");
//		Map<Integer,Integer> hm=(Map<Integer,Integer>)session.getAttribute("Qtymap");
//		for(ProductMaster p:Addedproductstocart) {
//			totalamount=totalamount+(hm.get(p.getId())*p.getCost());
//			k= new KitDetail(17,p.getId(),p.getProductName(),hm.get(p.getId()),(hm.get(p.getId())*p.getCost()));
//		kitDetailService.addKitItem(k);
//		}		
//		List<KitDetail> details=kitDetailService.getAllKitItemsOfAKit(17);
//		
//		model.addAttribute("kitdetails", details);
//		session.setAttribute("Totalamount", totalamount);
//		session.setAttribute("kitdetails", details);
//		model.addAttribute("Address", new UserAddress());
//		return "checkout-address";
//		
//	}
	
	@RequestMapping("/checkout")
	public String Checkout(HttpSession session,Model model) throws CoronaKitException {
//		KitDetail k;
//		int totalamount=0;
//		List<ProductMaster> Addedproductstocart=(List<ProductMaster>)session.getAttribute("cartaddedproduct");
//		Map<Integer,Integer> hm=(Map<Integer,Integer>)session.getAttribute("Qtymap");
//		for(ProductMaster p:Addedproductstocart) {
//			totalamount=totalamount+(hm.get(p.getId())*p.getCost());
//			k= new KitDetail(17,p.getId(),p.getProductName(),hm.get(p.getId()),(hm.get(p.getId())*p.getCost()));
//			kitDetailService.addKitItem(k);
//		}		
//		List<KitDetail> details=kitDetailService.getAllKitItemsOfAKit(17);
//		
//		model.addAttribute("kitdetails", details);
//		session.setAttribute("Totalamount", totalamount);
//		session.setAttribute("kitdetails", details);
		model.addAttribute("Address", new UserAddress());
		return "checkout-address";
		
	}

	@PostMapping("/finalize")
	public String finalizeOrder(@ModelAttribute("Address") @Valid UserAddress userAddress,BindingResult rs,Model model,HttpSession session) throws CoronaKitException {
		String view=null;
		if (!rs.hasErrors())
		{		
		KitDetail k;
		double Totalamount=0;
		List<ProductMaster> Addedproductstocart=(List<ProductMaster>)session.getAttribute("cartaddedproduct");
		Map<Integer,Integer> hm=(Map<Integer,Integer>)session.getAttribute("Qtymap");
		for(ProductMaster p:Addedproductstocart) {
			Totalamount=Totalamount+(hm.get(p.getId())*p.getCost());
		}
		
		
		model.addAttribute("Address1",userAddress.getAddress1());
		model.addAttribute("Address2",userAddress.getAddress2());
		model.addAttribute("City",userAddress.getCity());
		model.addAttribute("State",userAddress.getState());
		
	
		CoronaKit kit=new CoronaKit();

		kit.setDeliveryAddress(userAddress);
		kit.setOrderDate(LocalDate.now());
		kit.setTotalAmount(Totalamount);
		coronaKitService.saveKit(kit);
		System.out.println(kit.getId());
		for(ProductMaster p:Addedproductstocart) {
			
			k= new KitDetail(kit.getId(),p.getId(),p.getProductName(),hm.get(p.getId()),(hm.get(p.getId())*p.getCost()));
			kitDetailService.addKitItem(k);
		}
		List<KitDetail> details=kitDetailService.getAllKitItemsOfAKit(kit.getId());
		model.addAttribute("kitdetails", details);
		session.setAttribute("Totalamount", Totalamount);
		session.setAttribute("OrderID", kit.getId());
		view= "show-summary";
		}
		else
		{
			view="checkout-address";
		}
		return view;
	}
	
	@RequestMapping("/delete")
	public String deleteItem(@RequestParam("productId") int itemId,HttpSession session,Model model) {
		List<ProductMaster> Addedproductstocart=(List<ProductMaster>)session.getAttribute("cartaddedproduct");
		List<ProductMaster> RefreshCartAddedProducts=new ArrayList<ProductMaster>();
		Map<Integer,Integer> hm=(Map<Integer,Integer>)session.getAttribute("Qtymap");

		for(ProductMaster p:Addedproductstocart)
				{
			if (p.getId()==itemId)	
			{
				hm.remove(itemId);				
			}	
			else
			{
				RefreshCartAddedProducts.add(p);
			}
				}
		session.setAttribute("Qtymap", hm);
		session.setAttribute("cartaddedproduct", RefreshCartAddedProducts);
		
		return "show-cart";
	}
}
