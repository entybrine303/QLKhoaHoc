/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edusys.DAO;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public abstract class EduSysDAO<EntityType, KeyType> {
   public abstract void insert(EntityType e);
  public abstract void update(EntityType e);
  public abstract void delete(KeyType id);
  public abstract List<EntityType> selectAll();
  public abstract EntityType selectById(KeyType id);
  protected abstract  List<EntityType> selectBySql(String sql, Object... args);
}
