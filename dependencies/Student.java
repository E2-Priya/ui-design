package dependencies;

public class Student {
	private String studentName;
	private int rollNo;
	public String getStudentName() {
		return studentName;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
    void display() {
	System.out.println(getStudentName());
	System.out.println(getRollNo());
}
}
