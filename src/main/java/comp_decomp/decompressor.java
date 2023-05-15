/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author yash_yj_07
 */
public class decompressor {
    public static void method(File file) throws IOException {
        //need the file location to store the decompressed file at the same location
        String fileDirectory = file.getParent();
        
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/decompressed");
        
        //create buffer array to store the bytes read by gzip
        byte[] buffer = new byte[1024];
        int len;//lenthg of filled buffer array
        
        while((len=gzip.read(buffer))!=-1){
            fos.write(buffer, 0, len);
        }
        
        fos.close();
        gzip.close();
        fis.close();
    }
    
    public static void main(String[] args) throws IOException {
        File path = new File("");
        method(path);
    }
}
