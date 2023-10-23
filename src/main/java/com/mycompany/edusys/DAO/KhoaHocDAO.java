/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edusys.DAO;

import com.mycompany.edusys.Entity.KhoaHoc;
import com.mycompany.edusys.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class KhoaHocDAO extends EduSysDAO<KhoaHoc, Integer>{
    String INSERT_SQL = "INSERT INTO KhoaHoc(MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV,NgayTao) VALUES(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE KhoaHoc SET MaCD = ?,HocPhi = ?,ThoiLuong = ?, NgayKG = ?, GhiChu = ?, MaNV=?,NgayTao=? WHERE MaKH = ?";
    String DELETE_SQL = "DELETE FROM KhoaHoc WHERE MaKH = ?";
    String SELECT_ALL_SQL = "SELECT * FROM KhoaHoc";
    String SELECT_BY_ID_SQL = "SELECT * FROM KhoaHoc WHERE MaKH = ?";

    @Override
    public void insert(KhoaHoc e) {
        JdbcHelper.update(INSERT_SQL, e.getMaCD(), e.getHocPhi(),e.getThoiLuong(), e.getNgayKG(), e.getGhiChu(),e.getMaNV(),e.getNgayTao());
    }

    @Override
    public void update(KhoaHoc e) {
         JdbcHelper.update(UPDATE_SQL, e.getMaCD(), e.getHocPhi(),e.getThoiLuong(), e.getNgayKG(), e.getGhiChu(),e.getMaNV(),e.getNgayTao(),e.getMaKH());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<KhoaHoc> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhoaHoc selectById(Integer id) {
       List<KhoaHoc> list = selectBySql(SELECT_BY_ID_SQL, id);
       if(list.isEmpty()){
           return null;
       }
       return list.get(0);
    }

    @Override
    protected List<KhoaHoc> selectBySql(String sql, Object... args) {
        List<KhoaHoc> list = new ArrayList<>();
        try {
            ResultSet rs =JdbcHelper.query(sql, args);
            while(rs.next()){
                KhoaHoc e = new KhoaHoc();
                e.setMaKH(rs.getInt("MaKH"));
                e.setMaCD(rs.getString("MaCD"));
                e.setHocPhi(rs.getDouble("HocPhi"));
                e.setThoiLuong(rs.getInt("ThoiLuong"));
                e.setNgayKG(rs.getDate("NgayKG"));
                e.setGhiChu(rs.getString("GhiChu"));
                e.setMaNV(rs.getString("MaNV"));
                e.setNgayTao(rs.getDate("NgayTao"));
                list.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<KhoaHoc> selectByChuyenDe(String maCD){
        String sql = "SELECT * FROM KhoaHoc WHERE MaCD = ?";
        return selectBySql(sql, maCD);
    }
    
    public List<Integer> selectYear(){
        String sql = "select distinct year(ngaykg) year from khoahoc order by year desc";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while(rs.next()){
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
