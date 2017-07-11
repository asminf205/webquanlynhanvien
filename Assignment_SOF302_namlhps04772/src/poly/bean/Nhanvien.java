package poly.bean;

public class Nhanvien {
	private String maNV;
	private String hoten;
	private String gioitinh;
	private String ngaysinh;
	private String photo;
	private float luong;
	private String email;
	private String sDT;
	private String ghichu;
	private String phongban;
	;
	
	public Nhanvien() {
		super();
	}
	public Nhanvien(String maNV, String hoten, String gioitinh, String ngaysinh, String photo, float luong, String email,
			String sDT, String ghichu, String phongban) {
		super();
		this.maNV = maNV;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.photo = photo;
		this.luong = luong;
		this.email = email;
		this.sDT = sDT;
		this.ghichu = ghichu;
		this.phongban = phongban;
	}
	public Nhanvien(String maNV, String hoten, String gioitinh, String ngaysinh, String photo, String email,String sDT, float luong,
			 String ghichu, String phongban) {
		super();
		this.maNV = maNV;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.photo = photo;
		this.luong = luong;
		this.email = email;
		this.sDT = sDT;
		this.ghichu = ghichu;
		this.phongban = phongban;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public float getLuong() {
		return luong;
	}
	public void setLuong(float luong) {
		this.luong = luong;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public String getPhongban() {
		return phongban;
	}
	public void setPhongban(String phongban) {
		this.phongban = phongban;
	}
	

	}