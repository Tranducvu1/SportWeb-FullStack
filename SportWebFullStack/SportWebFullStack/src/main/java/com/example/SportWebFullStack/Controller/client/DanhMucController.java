//package com.example.SportWebFullStack.Controller.client;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.SportWebFullStack.Model.DanhMuc;
//import com.example.SportWebFullStack.Service.DanhMucService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//
//
//@Controller
//@RequestMapping("/admin/danhmuc")
//public class DanhMucController {
//@Autowired
//private DanhMucService danhMucService;
//
//@GetMapping()
//public String login(Model model) throws JsonMappingException, JsonProcessingException {
//	 List<DanhMuc> danhmuc = this.danhMucService.getDataFromAPI();
//	 List<DanhMuc> danhmucproducts = danhmuc.stream()
//	         .filter(p -> p.getTendanhmuc().contains("Nam"))
//	         .collect(Collectors.toList());
//
//	 		System.out.println(danhmucproducts);
//
//
//		model.addAttribute("danhmucs",danhmucproducts);
//			return "FrontEnd/template/header";
//}
//}
