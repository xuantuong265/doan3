package com.example.test1;

public class BaiDauXe {
    private String key, diaChi, hinhAnh, soDienThoai, soLuong,
            tenBaiDoXe,gio, conlai;

    public BaiDauXe() {
    }

    public String getConlai() {
        return conlai;
    }

    public void setConlai(String conlai) {
        this.conlai = conlai;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public BaiDauXe(String key, String diaChi, String gio, String hinhAnh, String soDienThoai, String soLuong, String tenBaiDoXe, String conlai) {
        this.key = key;
        this.diaChi = diaChi;
        this.gio = gio;
        this.hinhAnh = hinhAnh;
        this.soDienThoai = soDienThoai;
        this.soLuong = soLuong;
        this.tenBaiDoXe = tenBaiDoXe;
        this.conlai = conlai;
    }

    public BaiDauXe(String key, String diaChi, String hinhAnh, String soDienThoai, String soLuong, String tenBaiDoXe, String gio) {
        this.key = key;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
        this.soDienThoai = soDienThoai;
        this.soLuong = soLuong;
        this.tenBaiDoXe = tenBaiDoXe;
        this.gio = gio;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }




    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenBaiDoXe() {
        return tenBaiDoXe;
    }

    public void setTenBaiDoXe(String tenBaiDoXe) {
        this.tenBaiDoXe = tenBaiDoXe;
    }

}
