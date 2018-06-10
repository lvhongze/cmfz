package com.baizhi.util;

import java.util.Random;


public class RandomSaltUtil {
	public static String getSalt(){
		String s="1234567890qwertyuioplkjhgfsdazxcvbnmQAZWSXEDCRFVTGBYHNUJMIKOLP";
		Random rd=new Random();
		String salt="";
		for(int i=0;i<4;i++){
			char c=s.charAt(rd.nextInt(s.length()));
			salt+=c;
		}
		System.out.println(salt);
		return salt;
	}
}
