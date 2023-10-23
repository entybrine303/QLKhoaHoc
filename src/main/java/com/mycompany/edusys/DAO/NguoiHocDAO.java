/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edusys.DAO;

import com.mycompany.edusys.Entity.NguoiHoc;
import com.mycompany.edusys.Entity.NhanVien;
import com.mycompany.edusys.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NguoiHocDAO extends EduSysDAO<NguoiHoc, String>{
    String INSERT_SQL = "INSERT INTO NguoiHoc(MaNH,HoTen,NgaySinh,GioiTinh,DienThoai,Email,GhiChu,MaNV,NgayDK) VALUES(?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NguoiHoc SET HoTen = ?,NgaySinh = ?,GioiTinh = ?, DienThoai = ?, Email = ?, GhiChu = ?, MaNV = ?, NgayDK = ? WHERE MaNH = ?";
    String DELETE_SQL = "DELETE FROM NguoiHoc WHERE MaNH = ?";
    String SELECT_ALL_SQL = "SELECT * FROM NguoiHoc";
    String SELECT_BY_ID_SQL = "SELECT * FROM NguoiHoc WHERE MaNH = ?";

    @Override
    public void insert(NguoiHoc e) {
        JdbcHelper.update(INSERT_SQL, e.getMaNH(), e.getHoTen(),e.getNgaySinh(), e.isGioiTinh(),e.getDienThoai(),e.getEmail(),e.getGhiChu(),e.getMaNV(),e.getNgayDK());
    }

    @Override
    public void update(NguoiHoc e) {
        JdbcHelper.update(UPDATE_SQL,  e.getHoTen(),e.getNgaySinh(), e.isGioiTinh(),e.getDienThoai(),e.getEmail(),e.getGhiChu(),e.getMaNV(),e.getNgayDK(),e.getMaNH());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NguoiHoc selectById(String id) {
        List<NguoiHoc> list = selectBySql(SELECT_BY_ID_SQL, id);
       if(list.isEmpty()){
           return null;
       }
       return list.get(0);
    }
    

    @Override
    protected List<NguoiHoc> selectBySql(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs =JdbcHelper.query(sql, args);
            while(rs.next()){
                NguoiHoc e = new NguoiHoc();
               e.setMaNH(rs.getString("MaNH"));
               e.setHoTen(rs.getString("HoTen"));
               e.setNgaySinh(rs.getDate("NgaySinh"));
               e.setDienThoai(rs.getString("DienThoai"));
               e.setEmail(rs.getString("Email"));
               e.setGhiChu(rs.getString("GhiChu"));
               e.setMaNV(rs.getString("MaNV"));
               e.setNgayDK(rs.getDate("NgayDK"));
                list.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<NguoiHoc> selectByKeyword(String keyword){
        String sql = "SELECT * from NguoiHoc WHERE Hoten LIKE ?";
        return this.selectBySql(sql,"%"+keyword+"%");
    }
    
    public List<NguoiHoc> selectNotInCourse(int makh,String key){
        String sql = "select * from nguoihoc where hoten like ? and manh not in (select manh from hocvien where makh = ?)";
        return this.selectBySql(sql, "%"+key+"%",makh);
    }

    void insert(NhanVien e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}