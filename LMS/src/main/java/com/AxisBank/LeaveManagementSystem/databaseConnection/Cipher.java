package com.AxisBank.LeaveManagementSystem.databaseConnection;

public class Cipher {
	public static String encryption(String a) {
		 String b="";int v=0;int q=1;String d=a;
		 try {
			for(int j=0;j<10;j++) {
				for(int i=0;i<a.length();i++) {
					char c=d.charAt(i);
					v=(int)c+q;
					char ch=(char)v;
					b=b+ch;
				}
				d=b;
			}
		} catch (Exception e) {
		 e.printStackTrace();
		}
		 return d;
	 }
	public static String decryption(String a) {
		 String b="";int v=0;int q=1;String d=a;
		 try {
			for(int j=0;j<10;j++) {
				for(int i=0;i<a.length();i++) {
					char c=d.charAt(i);
					v=(int)c-q;
					char ch=(char)v;
					b=b+ch;
				}
				d=b;
			}
		} catch (Exception e) {
		 e.printStackTrace();
		}
		 return d;
	}
}
