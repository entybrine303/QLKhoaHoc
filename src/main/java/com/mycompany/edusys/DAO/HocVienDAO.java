/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edusys.DAO;

import com.mycompany.edusys.Entity.HocVien;
import com.mycompany.edusys.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HocVienDAO extends EduSysDAO<HocVien, Integer>{
    String INSERT_SQL = "INSERT INTO HocVien(MaKH,MaNH,Diem) VALUES(?,?,?)";
    String UPDATE_SQL = "UPDATE HocVien SET MaKH = ?,MaNH = ?,Diem = ? WHERE MaHV = ?";
    String DELETE_SQL = "DELETE FROM HocVien WHERE MaHV = ?";
    String SELECT_ALL_SQL = "SELECT * FROM HocVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM hocvien WHERE MaHV = ?";
    
    @Override
    public void insert(HocVien e) {
        JdbcHelper.update(INSERT_SQL,e.getMaKH(),e.getMaNH(),e.getDiem());
    }

    @Override
    public void update(HocVien e) {
        JdbcHelper.update(UPDATE_SQL,e.getMaKH(),e.getMaNH(),e.getDiem(), e.getMaHV());
    }

  

    @Override
    public List<HocVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<HocVien> selectBySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs =JdbcHelper.query(sql, args);
            while(rs.next()){
                HocVien e = new HocVien();
                e.setMaHV(rs.getInt("MaHV"));
                e.setMaKH(rs.getInt("MaKH"));
                e.setMaNH(rs.getString("MaNH"));
                e.setDiem(rs.getDouble("diem"));
                
                list.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void delete(Integer id) {
       JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public HocVien selectById(Integer id) {
        List<HocVien> list = selectBySql(SELECT_BY_ID_SQL, id);
       if(list.isEmpty()){
           return null;
       }
       return list.get(0);
    }
    
    public List<HocVien> selectByKhoaHoc(int makh){
        String sql = "select * from hocvien where makh = ?";
        return this.selectBySql(sql, makh);
    }
}
