
public class Student extends Person{
	String major;
	String firstName;
	String middleName;
	String lastName;
	String email;
	String ssn;
	int age;
	public Student(String major) {
		super();
		this.major = major;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

}
