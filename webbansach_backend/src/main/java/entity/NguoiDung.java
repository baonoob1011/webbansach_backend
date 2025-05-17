package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "nguoi_dung")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nguoi_dung")
    private int maNguoiDung;
    @Column(name = "ho_dem",length = 255)
    private String hoDem;
    @Column(name = "ten",length =  255)
    private String ten;
    @Column(name = "ten_dang_nhap")
    private String tenDangNhap;
    @Column(name = "mat_khau",length = 512)
    private String matKhau;
    @Column(name = "gioi_tinh")
    private char gioiTinh;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "dia_chi_mua_hang")
    private String diaChiMuaHang;
    @Column(name = "dia_chi_giao_hang")
    private String diaChiGiaoHang;
    @OneToMany(mappedBy = "nguoi_dung", fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH

    })
    private List<SuDanhGia> danhSachSuDanhGia;

    @OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH

    })
    private List<SachYeuThich> danhSachSachYeuThich;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "nguoi_quyen",
            joinColumns = @JoinColumn(name = "ma_nguoi_dung"),
            inverseJoinColumns = @JoinColumn(name = "ma_quyen")
    )
    private List<Quyen> danhSachQuyen;
    @OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH

    })
    private List<DonHang> danhSachDonHang;
}
