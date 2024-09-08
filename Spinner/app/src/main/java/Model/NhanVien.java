package Model;

import androidx.annotation.NonNull;

public class NhanVien {
    private String ten;
    private String thu;
    private int soNgay;

    public NhanVien() {
    }

    public NhanVien(String ten, String thu, int soNgay) {
        this.ten = ten;
        this.thu = thu;
        this.soNgay = soNgay;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    @NonNull
    @Override
    public String toString() {
        return this.ten + "\n Bat dau di cong tac vao thu [" + this.thu + "] "
                + "\n So ngay cong tac du kien: " + this.soNgay;
    }
}
