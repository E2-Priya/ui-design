package constructorInjection;

public class ConStudent {
	private String studentName;
	private int rollNo;
	public String getStudentName() {
		return studentName;
	}
	public int getRollNo() {
		return rollNo;
	}
	
 
	public ConStudent(String studentName, int rollNo) {

		this.studentName = studentName;
		this.rollNo = rollNo;
	}
	void display() {
	System.out.println(getStudentName());
	System.out.println(getRollNo());
}
}
