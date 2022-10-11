package studentInformation;

public class Student {
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", age=" + age + ", phone=" + phone + ", address="
				+ address + ", gender=" + gender + ", subId=" + subId + ", mark=" + mark + "]";
	}
	private int id;
	private String studentName;
	private int age;
	private int phone;
	private String address;
	private String gender;
	private int subId;
	
	
	public int getId() {
		return id;
	}
	public String getStudentName() {
		return studentName;
	}
	public int getAge() {
		return age;
	}
	public int getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public String getGender() {
		return gender;
	}
	public int getSubId() {
		return subId;
	}
	public int getMark() {
		return mark;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	private int mark;
	

}
