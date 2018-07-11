/**
 * 
 */
package com.nlkj.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.Key;
import java.util.Map;

/**
 * @author 石凯强
 *
 * @data 2018年7月10日
 */
public class RSACheckUtil {
	
	/**判断公钥**/
	public static String checkPublicKey(String pubKey) {
		try {
			String pubkey=getpublicKey();
			if(!pubkey.equals(pubKey)) {
				Map<String, Key> keyMap = RSAUtil.initKey();
		        String publicKey = RSAUtil.getPublicKey(keyMap);
		        String privateKey = RSAUtil.getPrivateKey(keyMap);
		        
		        // 保存密钥，名字分别为publicKey.txt 和privateKey.txt;
		        File file1=new File("D:/publicKey.txt");
		        File file2=new File("D:/privateKey.txt");
		        
		        //存储密钥到文件中
		        OutputStream outputStream1=new FileOutputStream(file1);
		        OutputStream outputStream2=new FileOutputStream(file2);
				outputStream1.write(publicKey.getBytes());
				outputStream2.write(privateKey.getBytes());
				outputStream1.close();
				outputStream2.close();
		        return publicKey;
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**从文件中获取私钥**/
	public static String getPrivateKey() {
		try {
			File file = new File("D:/privateKey.txt");
			InputStream inputStream;
			inputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader= new InputStreamReader(inputStream); //得到文件的字符流
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader); //放入读取缓冲区
			String readd="";
			StringBuffer stringBuffer=new StringBuffer();
			while ((readd=bufferedReader.readLine())!=null) {
				stringBuffer.append(readd);
			}
			inputStream.close();
			//文件内容的字节流
			String publicKey=stringBuffer.toString();
			return publicKey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**从文件中获取公钥**/
	public static String getpublicKey() {
		try {
			File file = new File("D:/publicKey.txt");
			InputStream inputStream;
			inputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader= new InputStreamReader(inputStream); //得到文件的字符流
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader); //放入读取缓冲区
			String readd="";
			StringBuffer stringBuffer=new StringBuffer();
			while ((readd=bufferedReader.readLine())!=null) {
				stringBuffer.append(readd);
			}
			inputStream.close();
			//文件内容的字节流
			String publicKey=stringBuffer.toString();
			return publicKey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	

}
