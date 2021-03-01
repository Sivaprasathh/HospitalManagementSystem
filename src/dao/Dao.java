package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.*;

public class Dao {
	private Connection con;
	private PreparedStatement ps;
	private String query;
	private ResultSet rs;
	private boolean status;
	public Dao() {
		try {
			System.out.println("Please wait...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hms";
			String user = "root";
			String password = "1111";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connect success.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean loginCheck(Bean lb) {
		status = false;
		try {
			query = "select * from userstore where login = ? and password = ?";
			ps = con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, lb.getUserName());
			ps.setString(2, lb.getPassword());
			rs = ps.executeQuery();
			status = rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public int insert(Bean lb) {
		int ret = 0;
		try {
	 query = "insert into patients (Patient_SSN_Id, Patient_Name, Age, Date_of_admission, Type_of_bed, "
	 		+ "Address, City, State) values(?,?,?,?,?,?,?,?)";
	 ps = con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, 
             ResultSet.CONCUR_UPDATABLE);
	 ps.setInt(1,lb.getPatientSsnId());
	 ps.setString(2,lb.getPatientName());
	 ps.setInt(3,lb.getAge());
	 ps.setString(4,lb.getDateOfAdmission());
	 ps.setString(5,lb.getTypeOfBed());
	 ps.setString(6,lb.getAddress());
	 ps.setString(7,lb.getCity());
	 ps.setString(8, lb.getState());
	 ret = ps.executeUpdate();
	 System.out.println(ret);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	public boolean checkPatientExists(Bean lb) {
		status = false;
		try {
			query = "select * from patients where Patient_ID = ?";
			ps = con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, lb.getPatientId());
			rs = ps.executeQuery();
			status = rs.next();
			System.out.println(status);
			if(status) {
				lb.setPatientId(rs.getInt("Patient_ID"));
				lb.setPatientName(rs.getString("Patient_Name"));
				lb.setAge(rs.getInt("Age"));
				lb.setDateOfAdmission(rs.getString("Date_of_admission"));
				lb.setTypeOfBed(rs.getString("Type_of_bed"));
				lb.setAddress(rs.getString("Address"));
				lb.setCity(rs.getString("City"));
				lb.setState(rs.getString("State"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public int update(Bean lb) {
		int ret = 0;
		try {
			
			 query ="update patients set Patient_Name = ?, Age = ?, Date_of_admission = ?, "
			 + "Type_of_bed = ?, Address = ?, City = ?, State = ? where Patient_ID = ?";
			 
			ps = con.prepareStatement(query);
			ps.setString(1,lb.getPatientName()); 
			ps.setInt(2,lb.getAge());
			ps.setString(3,lb.getDateOfAdmission()); 
			ps.setString(4,lb.getTypeOfBed());
			ps.setString(5,lb.getAddress()); 
			ps.setString(6,lb.getCity());
			ps.setString(7, lb.getState());
			ps.setInt(8,lb.getPatientId());
			ret = ps.executeUpdate();
			 System.out.println(ret);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	public int delete(Bean lb) {
		int ret = 0;
		try {
			query = "DELETE FROM patients WHERE Patient_ID = ?";
			ps = con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, lb.getPatientId());
			ret = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
}
