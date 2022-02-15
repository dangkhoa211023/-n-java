package Model;

public class KTX {
    private String masv;
    private String Name;
    private String lop;
    private int sdt;
    private String sophong;
    private String tinhtrang;

    public KTX(String masv, String name, String lop, int sdt, String sophong, String tinhtrang) {
        this.masv = masv;
        Name = name;
        this.lop = lop;
        this.sdt = sdt;
        this.sophong = sophong;
        this.tinhtrang = tinhtrang;
    }

    public KTX() {
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getSophong() {
        return sophong;
    }

    public void setSophong(String sophong) {
        this.sophong = sophong;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
