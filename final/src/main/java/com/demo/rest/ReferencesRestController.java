package com.demo.rest;

import com.demo.DAO.*;
import com.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/references")
public class ReferencesRestController {
    @Autowired LoaiGiayDAO loaiGiayDAO;

    @Autowired HangDAO hangDAO;

    @Autowired KichCoDAO kichCoDAO;

    @Autowired MauSacDAO mauSacDAO;

    @Autowired ChatLieuDAO chatLieuDAO;

    @Autowired ThuongHieuDAO thuongHieuDAO;

    @Autowired XuatXuDAO xuatXuDAO;

    @GetMapping("/loaigiay")
    public List<LoaiGiay> getAllLoaigiay(){
       return loaiGiayDAO.findAll();
    }

    @GetMapping("/hang")
    public List<Hang> getAllHang(){
        return hangDAO.findAll();
    }

    @GetMapping("/kichco")
    public List<KichCo> getAllKichco(){
        return kichCoDAO.findAll();
    }

    @GetMapping("/mausac")
    public List<MauSac> getMauSac(){
        return mauSacDAO.findAll();
    }

    @GetMapping("/chatlieu")
    public List<ChatLieu> getChatLieu(){
        return chatLieuDAO.findAll();
    }

    @GetMapping("/thuonghieu")
    public List<ThuongHieu> getThuongHieu(){
        return thuongHieuDAO.findAll();
    }

    @GetMapping("/xuatxu")
    public List<XuatXu> getXuatXu(){
        return xuatXuDAO.findAll();
    }
}
