package com.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


public class ZXingUtil {
	
	public static HashMap<String,String> users = new HashMap<String,String>();
	
	public static  Image encodeImage(String content)
	{
		int BLACK = 0xFF000000;  
		int WHITE = 0xFFFFFFFF;  
		@SuppressWarnings("unused")
		String resultPath =null;
		int width = 180;  
        int height = 180;  
        //File file = new File(path);  
        BufferedImage image;
		
        QRCodeWriter writer = new QRCodeWriter();  
        try {  
            BitMatrix matrix = writer.encode(content, BarcodeFormat.QR_CODE,width, height);  
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            for (int x = 0; x < width; x++) {  
                for (int y = 0; y < height; y++) {  
                  image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);  
                }  
              }  
            return image;
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
		return null;
	}
}
