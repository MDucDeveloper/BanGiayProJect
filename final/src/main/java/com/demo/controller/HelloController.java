package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import com.demo.entity.HangKhachHang;
import com.demo.entity.KhachHang;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
//	@Autowired
//	KhachHangRepo khachHangRepo;
//
//	@Autowired
//	HangKhachHangRepo hangKhachHangRepo;
//
//	@Data
//	public static class SearchForm{
//		String request;
//
//		Long mahang;
//	}
//
//
//	@ModelAttribute("dsHangKH")
//	public List<HangKhachHang> getDsHangKH(){
//		return hangKhachHangRepo.findAll();
//	}
//
//	@ModelAttribute("gioitinh")
//	public Map<Integer,String> getGioiTinh(){
//		Map<Integer,String> dsgioitinh = new HashMap<>();
//		dsgioitinh.put(0,"Nam");
//		dsgioitinh.put(1,"Nu");
//		return dsgioitinh;
//	}
//
//	@PostMapping("/khach-hang/add")
//	public String add(Model model, @ModelAttribute("khachhang")KhachHang khachHang){
//		khachHangRepo.save(khachHang);
//		return "redirect:/khach-hang/hien-thi";
//	}
//
//	@RequestMapping("/khach-hang/hien-thi")
//	public String index(Model model, @RequestParam(defaultValue = "0") int p,@ModelAttribute("search") SearchForm search){
//		Pageable pageable = PageRequest.of(p,5);
////		if(search.request.equals("")){
////			Page<KhachHang> page = khachHangRepo.searchForm(null,null,search.mahang,pageable);
////		}
////		if(search.request.startsWith("0"))
//		Page<KhachHang> page = khachHangRepo.searchForm(search.request,search.request,search.mahang,pageable);
//		model.addAttribute("khachhang",new KhachHang());
//		model.addAttribute("page",page);
//		System.out.println(search.request);
//		System.out.println(search.mahang);
//		return "khachhang/index";
//	}
//
//
//	@RequestMapping("/khach-hang/delete/{makhachhang}")
//	public String index(Model model, @PathVariable Long makhachhang){
//		KhachHang kh = khachHangRepo.findById(makhachhang).orElse(null);
//		khachHangRepo.delete(kh);
//		return "redirect:/khach-hang/hien-thi";
//	}
}
