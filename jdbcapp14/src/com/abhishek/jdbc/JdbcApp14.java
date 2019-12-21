package com.abhishek.jdbc;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp14 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "Abhishek123");
			st =con.createStatement();
			
			rs = st.executeQuery("select * from emp1");
			String data = "";
			data = data + "|ENO  |\tENAME |\tESAL  |\tEADDR|\n";
			while(rs.next()) {
				data = data + "|" +rs.getString("ENO")+ "  |\t";
				data = data + rs.getString("ENAME")+ "   |\t";
				data = data + rs.getString("ESAL")+ "|";
				data = data + rs.getString("EADDR")+ "   |\n";
			}
			fos = new FileOutputStream("C:\\Users\\Dell\\Documents\\PracticeLab\\AAA\\emp.txt");
			byte[] b = data.getBytes();
			fos.write(b);
			System.out.println("Data transferred to C:\\Users\\Dell\\Documents\\PracticeLab\\AAA\\emp.txt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				st.close();
				rs.close();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}