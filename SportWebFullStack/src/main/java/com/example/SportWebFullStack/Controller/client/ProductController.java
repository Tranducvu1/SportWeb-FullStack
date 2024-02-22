package com.example.SportWebFullStack.Controller.client;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.SportWebFullStack.Model.Cart;
import com.example.SportWebFullStack.Model.DanhMuc;
import com.example.SportWebFullStack.Model.DonHang;
import com.example.SportWebFullStack.Model.MatHang;
import com.example.SportWebFullStack.Model.MessageResponse;
import com.example.SportWebFullStack.Service.CartService;
import com.example.SportWebFullStack.Service.DanhMucService;
import com.example.SportWebFullStack.Service.DonHangService;
import com.example.SportWebFullStack.Service.MatHangService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sport")
public class ProductController {
	private MessageResponse message;
@Autowired
private MatHangService matHangService;
@Autowired
private DanhMucService danhMucService;
@Autowired
private DonHangService donHangService;
@Autowired
private CartService cartService;
@GetMapping("/product/{idproduct}")
public String login(Model model, @PathVariable("idproduct") int idproduct) throws Exception {
	try {
		DonHang donhang = new DonHang();
		MatHang matHang = this.matHangService.getById(idproduct);
		model.addAttribute("product",matHang);
		
		model.addAttribute("donhang",donhang);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
    return "FrontEnd/product";
}


@PostMapping("/product/{idproduct}")
public String addToCart(@RequestParam("idproduct") int productId, RedirectAttributes redirectAttributes) throws Exception {
    MatHang product = matHangService.getById(productId);
    cartService.addToCart(product);
    redirectAttributes.addFlashAttribute("message", "Sản phẩm đã được thêm vào giỏ hàng");
    return "redirect:/product/" + productId;
}


}
