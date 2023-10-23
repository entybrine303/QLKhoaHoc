/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edusys.Utils;

import java.util.Date;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class Vaidation {
    public static void checkRong(JTextField txt,  StringBuilder sb, String mess){
        if(txt.getText().length() == 0){
            sb.append(mess);
            
        }
      
    }
    
    public static void checkPass(JPasswordField txt, StringBuilder sb, String mess){
        String pass = new String(txt.getPassword());
        if(pass.length()<3){
            sb.append(mess);
     
        }
     
    }
    
   
    public static void checkTen(JTextField txt,StringBuilder sb){
        String ten = txt.getText();
        if(!ten.matches("[a-z A-Z]+")){
            sb.append("Tên không nhập số hoặc ký tự\n");
            
        }
     
    }
    
    public static void checkEmail(JTextField txt, StringBuilder sb){
        if(!txt.getText().matches("\\w+@\\w+(\\.\\w+){1,2}")){
            sb.append("Sai định dạng email");
            
        }
       
    }
    
    public static  void checkTuoi(Date day,StringBuilder sb){
        int ns = day.getYear();
        int now = new Date().getYear();
        if((now-ns)<16){
            sb.append("Người học chưa đủ tuổi\n");
            
        }
    }
    
    public static void checkSo(JTextField txt,StringBuilder sb){
        try {
            double s = Double.parseDouble(txt.getText());
            if(s <0){
                sb.append("Số phải lớn hơn 0\n");
            }
        } catch (NumberFormatException e) {
            sb.append("Chỉ nhập chữ số\n");
        }
    }
}
