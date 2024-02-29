package com.example.SportWebFullStack.Controller.Admin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SportWebFullStack.Model.DanhMuc;
import com.example.SportWebFullStack.Model.MatHang;
import com.example.SportWebFullStack.Service.DanhMucService;
import com.example.SportWebFullStack.Service.MatHangService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/admin")
public class AdminController {

@Autowired
private MatHangService matHangService;
@Autowired
private DanhMucService danhMucService;
@GetMapping()
public String login(Model model){
return "Admin/trangAdmin";
}


@GetMapping("/san-pham")
public String quanLySanPhamPage(ModelMap modelMap, @RequestParam(value="id", required = false) Integer productId,
	       @RequestParam(value="danhmuc", required = false) String danhMucId) throws Exception {
	 List<MatHang> products = new ArrayList<>();
   if(productId !=null) {
	   
          MatHang product = matHangService.getById(productId);
          products.add(product);
          System.out.println("1"+products);
       } else if(danhMucId != null) {
           
           // products = matHangService.getDataDanhMuc(danhMucId);
            System.out.println("2 "+products);
        } else {
        	 
            products = matHangService.getDataFromAPI();
            System.out.println("3"+products);
         }
        modelMap.addAttribute("products", products);
       
        return "Admin/quanLySanPham";

   
}


@GetMapping("/category")
public String quanLyDanhMucPage(ModelMap modelMap, @RequestParam(value = "keyword", required = false) String keyword) throws JsonMappingException, JsonProcessingException, UnsupportedEncodingException {
	if (keyword == null) {
		modelMap.addAttribute("danhMucs",this.danhMucService.getDataFromAPI());
       
    } else {
        // Mã hóa tham số keyword trước khi sử dụng nó trong URL
        String encodedKeyword = URLEncoder.encode(keyword, "UTF-8");
        // Sử dụng encodedKeyword khi tạo URL
        modelMap.addAttribute("danhMucs", this.danhMucService.searchDataFromAPI(encodedKeyword));
    }
	return "Admin/quanLyDanhMuc";
}

@GetMapping("/new/category")
public String TaoDanhmuc(ModelMap modelMap) throws JsonMappingException, JsonProcessingException, UnsupportedEncodingException {
	DanhMuc dm = new DanhMuc();
	modelMap.addAttribute("danhmucs",dm);
	return "Admin/Taodanhmuc";
}

@PostMapping("/new/category")
public String CreateDanhmuc(ModelMap modelMap,DanhMuc danhMuc) throws JsonMappingException, JsonProcessingException, UnsupportedEncodingException {
	danhMucService.post(danhMuc);
	return "redirect:/admin/category";
}

@GetMapping("/nhan-hieu")
public String quanLyNhanHieuPage() {
	return "admin/quanLyNhanHieu";
}

@GetMapping("/lien-he")
public String quanLyLienHePage() {
	return "admin/quanLyLienHe";
}


}
