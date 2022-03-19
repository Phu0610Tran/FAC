package com.example.fac.Model;

public class BaiViet {
    int IDBV;
    int IDTK;
    String TENTAIKHOAN;
    String TIEUDE;
    String NOIDUNG;
    String DATE;
    byte[] HINHANHBAIVIET;
    byte[] AVATAR;
    int THICH;
    int KHONGTHICH;
    

    public BaiViet(int IDBV, int IDTK, String TENTAIKHOAN, String TIEUDE, String NOIDUNG, String DATE, byte[] HINHANHBAIVIET, byte[] AVATAR, int THICH,int KHONGTHICH) {
        this.IDBV = IDBV;
        this.IDTK = IDTK;
        this.TENTAIKHOAN = TENTAIKHOAN;
        this.TIEUDE = TIEUDE;
        this.NOIDUNG = NOIDUNG;
        this.DATE = DATE;
        this.HINHANHBAIVIET = HINHANHBAIVIET;
        this.AVATAR = AVATAR;
        this.THICH = THICH;
        this.KHONGTHICH = KHONGTHICH;
    }

    public int getTHICH() {
        return THICH;
    }

    public void setTHICH(int THICH) {
        this.THICH = THICH;
    }

    public int getKHONGTHICH() {
        return KHONGTHICH;
    }

    public void setKHONGTHICH(int KHONGTHICH) {
        this.KHONGTHICH = KHONGTHICH;
    }

    public int getIDBV() {
        return IDBV;
    }

    public void setIDBV(int IDBV) {
        this.IDBV = IDBV;
    }

    public int getIDTK() {
        return IDTK;
    }

    public void setIDTK(int IDTK) {
        this.IDTK = IDTK;
    }

    public String getTENTAIKHOAN() {
        return TENTAIKHOAN;
    }

    public void setTENTAIKHOAN(String TENTAIKHOAN) {
        this.TENTAIKHOAN = TENTAIKHOAN;
    }

    public String getTIEUDE() {
        return TIEUDE;
    }

    public void setTIEUDE(String TIEUDE) {
        this.TIEUDE = TIEUDE;
    }

    public String getNOIDUNG() {
        return NOIDUNG;
    }

    public void setNOIDUNG(String NOIDUNG) {
        this.NOIDUNG = NOIDUNG;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public byte[] getHINHANHBAIVIET() {
        return HINHANHBAIVIET;
    }

    public void setHINHANHBAIVIET(byte[] HINHANHBAIVIET) {
        this.HINHANHBAIVIET = HINHANHBAIVIET;
    }

    public byte[] getAVATAR() {
        return AVATAR;
    }

    public void setAVATAR(byte[] AVATAR) {
        this.AVATAR = AVATAR;
    }
}
