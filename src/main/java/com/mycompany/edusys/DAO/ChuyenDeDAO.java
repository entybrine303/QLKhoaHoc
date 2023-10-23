/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edusys.DAO;

import com.mycompany.edusys.Entity.ChuyenDe;
import com.mycompany.edusys.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChuyenDeDAO extends EduSysDAO<ChuyenDe, String>{
      String INSERT_SQL = "INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES (?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE ChuyenDe SET TenCD = ?,HocPhi = ?,ThoiLuong = ?, Hinh = ?, MoTa = ? WHERE MaCD = ?";
    String DELETE_SQL = "DELETE FROM ChuyenDe WHERE MaCD = ?";
    String SELECT_ALL_SQL = "SELECT * FROM ChuyenDe";
    String SELECT_BY_ID_SQL = "SELECT * FROM ChuyenDe WHERE MaCD = ?";
    @Override
    public void insert(ChuyenDe e) {
        JdbcHelper.update(INSERT_SQL, e.getMaCD(), e.getTenCD(), e.getHocPhi(),e.getThoiLuong(), e.getHinh(), e.getMota());
    }

    @Override
    public void update(ChuyenDe e) {
        JdbcHelper.update(UPDATE_SQL,  e.getTenCD(), e.getHocPhi(),e.getThoiLuong(), e.getHinh(), e.getMota(),e.getMaCD());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChuyenDe selectById(String id) {
        List<ChuyenDe> list = selectBySql(SELECT_BY_ID_SQL, id);
       if(list.isEmpty()){
           return null;
       }
       return list.get(0);
    }
    

    @Override
    protected List<ChuyenDe> selectBySql(String sql, Object... args) {
        List<ChuyenDe> list = new ArrayList<>();
        try {
            ResultSet rs =JdbcHelper.query(sql, args);
            while(rs.next()){
                ChuyenDe e = new ChuyenDe();
                e.setMaCD(rs.getString("MaCD"));
                e.setTenCD(rs.getString("TenCD"));
                e.setHocPhi(rs.getDouble("HocPhi"));
                e.setThoiLuong(rs.getInt("ThoiLuong"));
                e.setHinh(rs.getString("Hinh"));
                e.setMota(rs.getString("MoTa"));
                list.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
