package Model;

import java.io.Serializable;

public class DanhBa implements Serializable {
    private int ma;
    private String ten;
    private String phone;

    public DanhBa() {
    }

    public DanhBa(int i, String phanVanC, String number) {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

}
