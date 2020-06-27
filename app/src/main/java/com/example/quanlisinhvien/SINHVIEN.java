package com.example.quanlisinhvien;

public class SINHVIEN {
    String mssv,hoten,gt,cn;

    public SINHVIEN() {
    }

    public SINHVIEN(String mssv, String hoten, String gt, String cn) {
        this.mssv = mssv;
        this.hoten = hoten;
        this.gt = gt;
        this.cn = cn;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }
}
