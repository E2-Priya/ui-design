package objectInjection;

public class ObjCollege {
	private int collegeId;
	private ObjDept dept;
	public int getCollegeId() {
		return collegeId;
	}
	public ObjDept getDept() {
		return dept;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public void setDept(ObjDept dept) {
		this.dept = dept;
	}
	
public void deptName() {
	dept.deptName();
	System.out.println("College id is "+collegeId);
}
}
