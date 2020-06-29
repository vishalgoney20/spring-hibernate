package com.luv2Code.jdbc;

import java.sql.DriverManager;

import java.sql.Connection;

public class TestJdbc {
	
	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user="hbstudent";
		String pass="Vishal@1234";
		try {
			System.out.println("Connecting to database :"+jdbcUrl);
			Connection myConn=DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection Succesfull...!!! ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
