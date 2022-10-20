package onetomany;

import java.util.List;
import java.util.Set;

public class Department {
	private int deptId;
	private String deptName;
	private Set<Student> st;
	public int getDeptId() {
		return deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public Set<Student> getSt() {
		return st;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public void setSt(Set<Student> st) {
		this.st = st;
	}
	

}
