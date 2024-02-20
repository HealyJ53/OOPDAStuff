
public class Instructor extends Person {
	String major;
	String firstName;
	String middleName;
	String lastName;
	String email;
	String ssn;
	int age;
	String department;
	public Instructor(String department) {
		this.department = department;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

}
