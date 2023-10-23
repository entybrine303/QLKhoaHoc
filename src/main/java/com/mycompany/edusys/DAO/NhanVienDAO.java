/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edusys.DAO;

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
public class NhanVienDAO extends EduSysDAO<NhanVien, String>{
    String INSERT_SQL = "INSERT INTO NhanVien(MaNV,MatKhau,HoTen,VaiTro) VALUES(?,?,?,?)";
    String UPDATE_SQL = "UPDATE Nhanvien SET MatKhau = ?,HoTen = ?,VaiTro = ? WHERE MaNV = ?";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV = ?";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV = ?";

    @Override
    public void insert(NhanVien e) {
        JdbcHelper.update(INSERT_SQL, e.getMaNV(),e.getMatKhau(),e.getHoTen(),e.getVaiTro());
    }

    @Override
    public void update(NhanVien e) {
       JdbcHelper.update(UPDATE_SQL, e.getMatKhau(),e.getHoTen(),e.getVaiTro(),e.getMaNV());
    }

    @Override
    public void delete(String id) {
       JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
       List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, id);
       if(list.isEmpty()){
           return null;
       }
       return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs =JdbcHelper.query(sql, args);
            while(rs.next()){
                NhanVien e = new NhanVien();
                e.setMaNV(rs.getString("MaNV"));
                e.setMatKhau(rs.getString("MatKhau"));
                e.setHoTen(rs.getString("HoTen"));
                e.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
