package ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Student {
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	int id;
	String name;

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return " ------>  id=" + id + ", name=" + name + "  <-------";
	}

}

public class AddDetails {
	static AddDetails ad;
	ArrayList<Student> student = new ArrayList<Student>();

	public static void main(String[] args) {

		ad = new AddDetails();
		ad.function();

	}

	void function() {

		Scanner scan = new Scanner(System.in);

		System.out.println("enter student id : ");
		int id = scan.nextInt();
		System.out.println("enter student name : ");
		String name = scan.next();
		Student s = new Student(id, name);

		student.add(s);

		Iterator it = student.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		ad.loop();

	}

	void loop() {
		ad.function();
	}
}
