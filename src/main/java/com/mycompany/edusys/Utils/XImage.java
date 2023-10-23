/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edusys.Utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author ADMIN
 */
public class XImage {
     public static Image getAppIcon(){
        URL url = XImage.class .getResource("/com/mycompany/edusys/icon/fpt.png");
        return new ImageIcon(url).getImage();
    }
    
    public static void saveIcon(File src){
        File dst = new File("src\\main\\resources\\com\\mycompany\\edusys\\logo",src.getName());
        if(!dst.getParentFile().exists()){
            // tạo thư mục mới
            dst.getParentFile().mkdirs();
        }
        try {
            // lấy đường dẩn tuyệt đối
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            //copy vào thư mục logo
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static ImageIcon read(String filename){
        File path = new File("src\\main\\resources\\com\\mycompany\\edusys\\logo", filename);
        return new ImageIcon(path.getAbsolutePath());
    }
}
