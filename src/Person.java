
import java.util.HashMap;
import java.util.function.Predicate;

public class Person {
	static final long firstId = 916421999;
	static long lastId = 916421998;
	long id;
	static int minAge = 1000;
	static int maxAge = 0;
	String firstName;
	String middleName;
	String lastName;
	String email;
	String ssn;
	int age;
	public Person()
	{
		this.id = ++lastId;
		age = 0;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(Person.validateEmail(email))
		{
		this.email = email;
		}
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		if(Person.validateSSN(ssn))
		{
		this.ssn = ssn;
		}
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(Person.validateAge(age))
		{
		this.age = age;
		if (age >= maxAge)
		{
			maxAge = age;
		}
		if (age <= minAge)
		{
			minAge = age;
		}
		}
	}
	public long getId() {
		return id;
	}
	public String toString()
	{
		return firstName + " " + middleName + " " + lastName;
	}
	public String getEmailDomain()
	{
		return email.substring(email.indexOf('@')+1);
	}
	public String getLast4SSN()
	{
		return ssn.substring(7, 11);
	}
	public static boolean validateSSN(String ssn)
	{
		if (ssn.length() != 11)
		{
			System.out.println("Incorrect length.");
			return false;
		}
		int temp = 0;
		for(int i = 0; i < 11; i++)
		{
			if (ssn.charAt(i) == '-')
			{
				temp++;
			}
		}
		if (temp < 2)
		{
			System.out.println("Not enough hyphens.");
			return false;
		}
		if (temp > 2)
		{
			System.out.println("Too many hyphens.");
			return false;
		}
		return true;
	}
	public static boolean validateAge(int age)
	{
		if (age < 16)
		{
			System.out.println("Cannot be younger than 16.");
			return false;
		}
		return true;
	}
	public static boolean validateEmail(String email)
	{
		if(!email.contains("@"))
		{
			System.out.println("Invalid email: must have @.");
			return false;
		}
		return true;
	}
	static Predicate<Person> oldest = Person -> {
		if (Person.getAge() >= maxAge)
		{
			return true;
		}
		return false;
		};
	static Predicate<Person> youngest = Person -> {
		if (Person.getAge() <= minAge)
		{
			return true;
		}
		return false;
	};
	public static HashMap<String, Predicate<Person>> loop;
	static {
		loop = new HashMap<>();
		loop.put("oldest", oldest);
		loop.put("youngest", youngest);
	};
}
