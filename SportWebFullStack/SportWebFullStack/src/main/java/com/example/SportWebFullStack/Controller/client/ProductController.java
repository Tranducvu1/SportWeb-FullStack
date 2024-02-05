package com.example.SportWebFullStack.Controller.client;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SportWebFullStack.Model.DanhMuc;
import com.example.SportWebFullStack.Model.MatHang;
import com.example.SportWebFullStack.Service.DanhMucService;
import com.example.SportWebFullStack.Service.MatHangService;

@Controller
@RequestMapping("/admin")
public class ProductController {
@Autowired
private DanhMucService danhMucService;
@Autowired
private MatHangService matHangService;
@GetMapping("/product/{id}")
public String login(Model model,@PathVariable int id) throws Exception {
	 MatHang products = this.matHangService.getById(id);
	  if (products.getDanhmuc_id() != 0) {
	 DanhMuc category = products.getDanhMuc(); 
	 //DanhMuc category =        
         model.addAttribute("products", products);	 
	   model.addAttribute("category", category);
	 System.out.println("sản phẩm là :"+products);
	 System.out.println("Danh mục là :"+category);
	  }else {
	        System.out.println("Không tìm thấy danh mục cho sản phẩm có id: " + id);
	    }
			return "FrontEnd/product";
}
}
