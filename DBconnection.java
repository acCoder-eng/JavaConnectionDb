package denem1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class DBconnection {
	
	 final  String JDBC = "com.mysql.jdbc.Driver";
	 final  String url = "jdbc:mysql://mysql.wmcoder.com:2095/UniApp";
	 final  String user = "";
	 final  String pass = "";
	 
	 Connection con = null;
	 PreparedStatement ps;
	 ResultSet rs;
	 String id,kad;
	 public DBconnection() {
		 connection();
		 vericek();

	 }
	 
	 public void connection() {
		 
		 
		 try {
			 Class.forName("com.mysql.jdbc.Driver");  
			  con=DriverManager.getConnection(url,user,pass);
			 System.out.println("baglanti basarılı");
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 
	 }
	 
	 public void vericek() {
		 connection();
		 
		 try {
			 String sql = "select * from registers";
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			 
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 }
	public static void main(String[] args) {
		new DBconnection();
	}

}
