/**
 * 
 */
package com.nlkj.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author 石凯强
 *
 * @date 2018年7月6日
 */
public class CommonUtil {
	private static final String KEY="脑力科技";//加密秘钥
	
	public static boolean judgeNULL(Object obj, String sign, String time) {
		//时间合适，判断参数
		if(checkTime(time)==1) {
			//进行对象参数的拼接及加密
			StringBuilder sb = new StringBuilder();
			String[] fieldNames = getFiledName(obj);
			List<String> list=new ArrayList<>();
			for (String s : fieldNames) {
				list.add(s);
			}
			Collections.sort(list);
			  for(int j=0 ; j<list.size() ; j++){     //遍历所有属性
	               String name = list.get(j);    //获取属性的名字
	               Object value = getFieldValueByName(name,obj);
	               if(value!=null) {
	            	   sb.append(name).append(value);
	               }
		      }
			 String string =new String(sb);
			 String encrypt = new AESUtil().encrypt(string, KEY);
			 if(sign.equals(encrypt)) {
				 return true;
			 }
		}
		return false;
		
	}
	
	/**时间解密+判断***/
	public static int checkTime(String time) {
		String decrypt = new AESUtil().decrypt(time, KEY);
		Long nowTime = new Date().getTime();
		if(nowTime-Long.valueOf(decrypt)>5*60000) {
			return 0;
		}
		return 1;
	}
	
	/**获取属性名数组**/
	private static String[] getFiledName(Object o){  
        Field[] fields=o.getClass().getDeclaredFields();  
        String[] fieldNames=new String[fields.length];  
        for(int i=0;i<fields.length;i++){  
            fieldNames[i]=fields[i].getName();  
        }  
        return fieldNames;  
    }  
	
	/** 根据属性名获取属性值 **/
	 private static Object getFieldValueByName(String fieldName, Object o) {  
        try {    
            String firstLetter = fieldName.substring(0, 1).toUpperCase();    
            String getter = "get" + firstLetter + fieldName.substring(1);    
            Method method = o.getClass().getMethod(getter, new Class[] {});    
            Object value = method.invoke(o, new Object[] {});    
            return value;    
        } catch (Exception e) {    
          
            return null;    
        }    
	 }
	 
	 
	
}
