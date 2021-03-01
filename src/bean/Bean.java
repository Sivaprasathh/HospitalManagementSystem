package bean;
import java.io.*;

public class Bean implements Serializable {
	private String userName;
	private String password;
	private int patientSsnId;
	private int patientId;
	private String patientName;
	private int age;
	private String dateOfAdmission;
	private String typeOfBed;
	private String address;
	private String city;
	private String state;
	
	public Bean() {
		userName = "";
		password = "";
		patientSsnId = 0;
		patientId = 0;
		patientName="";
		age = 0;
		dateOfAdmission="";
		typeOfBed = "";
		address="";
		city="";
		state="";
	}

	public int getPatientSsnId() {
		return patientSsnId;
	}

	public void setPatientSsnId(int patientSsnId) {
		this.patientSsnId = patientSsnId;
	}

	public String getTypeOfBed() {
		return typeOfBed;
	}

	public void setTypeOfBed(String typeOfBed) {
		this.typeOfBed = typeOfBed;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(String dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

}
