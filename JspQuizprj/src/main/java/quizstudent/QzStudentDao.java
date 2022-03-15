package quizstudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QzStudentDao {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qzstudent?characterEncoding=latin1","root","tiger");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(QzStudent s){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	       PreparedStatement ps=con.prepareStatement( "insert into studt values(?,?,?,?)");  
	       ps.setInt(1, s.getSid());
	        ps.setString(2,s.getSname());
	        ps.setString(3,s.getSemail()); 
	        ps.setString(4,s.getSpassword());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int update(QzStudent s){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update studt set sname=?,semail=?,spassword=? where sid=?");  
	        ps.setString(1,s.getSname());
	        ps.setString(2,s.getSemail()); 
	        ps.setString(3,s.getSpassword());    
	        ps.setInt(4, s.getSid());
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int delete(QzStudent s){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from studt where sid=?");  
	        ps.setInt(1,s.getSid());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	public static List<QzStudent> getAllRecords(){  
	    List<QzStudent> list=new ArrayList<QzStudent>();  
	      
	    try{  
	       Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from studt");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	QzStudent s=new QzStudent();  
	            s.setSid(rs.getInt("sid"));  
	            s.setSname(rs.getString("sname")); 
	            s.setSemail(rs.getString("semail")); 
	            s.setSpassword(rs.getString("spassword"));                        
	            list.add(s);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	public static QzStudent getRecordById(int id){  
		QzStudent s=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from studt where sid=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            s=new QzStudent();  
	            s.setSid(rs.getInt("sid"));  
	            s.setSname(rs.getString("sname")); 
	            s.setSemail(rs.getString("semail")); 
	            s.setSpassword(rs.getString("spassword"));                        
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return s;  
	}  

}
