package org.stu.jdbcApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Studentcrud {

	public static void main(String[] args) {
	// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		Studentcrud s=new Studentcrud();
		
		int ch;
		do {
			System.out.println("enter your choice");
			
			System.out.println("1.Insert the record");
			System.out.println("2.Display the record");
			System.out.println("3.Update the record");
			System.out.println("4.Delete the Record");
			System.out.println("5.Exit");
			ch=sc.nextInt();
			
			switch (ch) {
			case 1:  
		       s.insertData();
				break;
			case 2:
				s.displayData();
				break;
			case 3:
				s.updateData();
				break;
			case 4:
				s.deleteData();
				break;
			case 5:
				System.out.println("Thank you");
				break;
			default:
				break;
			}
		}
		while(ch!=5);
			
	}
	
	public Connection getConnect()
	{
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinequiz?characterEncoding=latin1","root","tiger");
			System.out.println("Connection Established Between java applicatiion and database server");
			return con;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void insertData() {
		Student st=new Student();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the details");
		String sname=sc.next();
		st.setSname(sname);
		String semail=sc.next();
		st.setSemail(semail);
		String spassword=sc.next();
		st.setSpassword(spassword);
		
		try {
			Connection con=getConnect();
			PreparedStatement pst=con.prepareStatement("insert into student(sname,semail,spassword) values(?,?,?)");
			pst.setString(1,st.getSname());
			pst.setString(2,st.getSemail());
			pst.setString(3,st.getSpassword());
			int x=pst.executeUpdate();
			pst.close();
			con.close();
			if(x==1) {
				System.out.println("Record inserted successfully");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void displayData()
	{
		try {
			Connection con=getConnect();
			PreparedStatement pst=con.prepareStatement("select * from student");
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void updateData()
	{
		Student st=new Student();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		int sid=sc.nextInt();
		st.setSid(sid);
		System.out.println("Enter the name");
		String sname=sc.next();
		st.setSname(sname);
		System.out.println("Enter the email");
		String semail=sc.next();
		st.setSemail(semail);
		System.out.println("Enter the password");
		String spassword=sc.next();
		st.setSpassword(spassword);
		
		try {
			
			Connection con=getConnect();
			String str="update student set sname=?,semail=?,spassword=? where sid=?";
			PreparedStatement pst=con.prepareStatement(str);
			
			pst.setString(1, st.getSname());
			pst.setString(2, st.getSemail());
			pst.setString(3, st.getpassword());
			pst.setInt(4, st.getSid());
			
			int x=pst.executeUpdate();
			pst.close();
			con.close();
			if(x==1) {
				System.out.println("Updated Successfully");
			}
			else {
				System.out.println("Record not Found");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void deleteData()
	{
		Scanner sc=new Scanner(System.in);
		try {
			int sid;
			System.out.println("Enter the record number to delete");
			sid=sc.nextInt();
			Student st=new Student();
			st.setSid(sid);
			Connection con=getConnect();
			
			PreparedStatement pst=con.prepareStatement("delete from student where sid=?");
			
			pst.setInt(1, st.getSid());
			int x=pst.executeUpdate();
			pst.close();
			con.close();
			if(x==1) {
				System.out.println("Record Deleted");
			}
			else
			{
				System.out.println("Record not found");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
