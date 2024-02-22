package com.example.SportWebFullStack.Controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SportWebFullStack.Model.Cart;
import com.example.SportWebFullStack.Model.MatHang;
import com.example.SportWebFullStack.Service.MatHangService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sport")
public class ShoppingCart {
@Autowired
private MatHangService matHangService;
	
	@GetMapping("/cart")
	public String addtoCart(ModelMap modelmap,@RequestParam int productId, HttpSession session) throws Exception {
		Cart cart = (Cart) session.getAttribute("cart");
		  if (cart == null) {
		    cart = new Cart();
		    session.setAttribute("cart", cart);  
		  }
		  
		// Tìm sản phẩm theo productId và thêm vào giỏ hàng
		  MatHang product = matHangService.getById(productId);
		  cart.addMatHang(product);
		return "FrontEnd/cart";
	}
	
//	@GetMapping("/cart")
//	public String viewCart(HttpSession session,ModelMap modelmap) {
//
//	  Cart cart = (Cart) session.getAttribute("cart");  
//	  modelmap.addAttribute("cart", cart);
//
//	  return "cartPage";
//	}
}
