package com.example.SportWebFullStack.Model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatHang {

    private int id;
    private String mamathang;
    private String tenmathang;
    private String maphanloai;
    private String hinhanh;
    private Long dongia;
    private String danhgia;
    private int soluong; // Đã sửa thành kiểu int
    private String mota;
    private String gender;
    private Timestamp ngaythem;
    private Long giamgia;
    private int danhmuc_id;

    // Đảm bảo kiểu dữ liệu tương ứng với lớp DanhMuc
    private DanhMuc danhMuc;
}
