package onetoone;

public class Address {
	private int address_id;
	private int flat_no;
	private String street_name;
	private String city;
	private int emp_id;
	private Employee emp;
	
	public int getAddress_id() {
		return address_id;
	}
	public int getFlat_no() {
		return flat_no;
	}
	
	public String getStreet_name() {
		return street_name;
	}
	public String getCity() {
		return city;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public void setFlat_no(int flat_no) {
		this.flat_no = flat_no;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	@Override
	public String toString() { 
		return emp+"                     " + address_id + "         " + flat_no + "         " + street_name + "        "
				+ city;
	}
	
	
}
