/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edusys.Utils;

import com.mycompany.edusys.Entity.NhanVien;

/**
 *
 * @author ADMIN
 */
public class Auth {
     //duy trì đăng nhập
    public static NhanVien user = null;
    
    public static void clear(){
        Auth.user = null;
    }
    
    public static boolean isLogin(){
        return Auth.user != null;
    }
    
    public static boolean isManager(){
        return Auth.isLogin() && user.getVaiTro();
    }
}
