import java.util.HashMap;
import java.util.Scanner;

public class Driver {
	
	private static Person makePerson(Scanner sc)
	{
		Person person = new Person();
		System.out.println("Enter first name.");
		person.setFirstName(sc.next());
		System.out.println("Enter middle name.");
		person.setMiddleName(sc.next());
		System.out.println("Enter last name.");
		person.setLastName(sc.next());
		while (person.getEmail() == null) {
		System.out.println("Enter email");
		person.setEmail(sc.next());
		}
		while (person.getSsn() == null)
		{
		System.out.println("Enter SSN in ###-##-#### format");
		person.setSsn(sc.next());
		}
		while (person.getAge() == 0)
		{
		System.out.println("Enter age");
		person.setAge(sc.nextInt());
		}
		return person;
	}
	private static Student makeStudent(Scanner sc)
	{
		Student student = new Student("temp");
		System.out.println("Enter first name.");
		student.setFirstName(sc.next());
		System.out.println("Enter middle name.");
		student.setMiddleName(sc.next());
		System.out.println("Enter last name.");
		student.setLastName(sc.next());
		while (student.getEmail() == null) {
			System.out.println("Enter email");
			student.setEmail(sc.next());
			}
			while (student.getSsn() == null)
			{
			System.out.println("Enter SSN in ###-##-#### format");
			student.setSsn(sc.next());
			}
			while (student.getAge() == 0)
			{
			System.out.println("Enter age");
			student.setAge(sc.nextInt());
			}
		System.out.println("Enter major");
		student.setMajor(sc.next());
		return student;
	}
	private static Instructor makeInstructor(Scanner sc)
	{
		Instructor instructor = new Instructor("temp");
		System.out.println("Enter first name.");
		instructor.setFirstName(sc.next());
		System.out.println("Enter middle name.");
		instructor.setMiddleName(sc.next());
		System.out.println("Enter last name.");
		instructor.setLastName(sc.next());
		while (instructor.getEmail() == null) {
			System.out.println("Enter email");
			instructor.setEmail(sc.next());
			}
			while (instructor.getSsn() == null)
			{
			System.out.println("Enter SSN in ###-##-#### format");
			instructor.setSsn(sc.next());
			}
			while (instructor.getAge() == 0)
			{
			System.out.println("Enter age");
			instructor.setAge(sc.nextInt());
			}
		System.out.println("Enter department");
		instructor.setDepartment(sc.next());
		return instructor;
	}
	private static void loopThrough(HashMap<Long, Person> list, String eType)
	{
		for(long i = Person.firstId; i < Person.lastId+1; i++)
		{
				System.out.println(i);
				System.out.println(list.get(i).toString() + " " + list.get(i).getClass().getSimpleName());
				System.out.println(list.get(i).getEmailDomain());
				System.out.println(list.get(i).getLast4SSN());
				System.out.println(eType + " = " + Person.loop.get(eType.toLowerCase()).test(list.get(i)));
				if(list.get(i) instanceof Student)
				{
					System.out.println(((Student) list.get(i)).getMajor());
				}
				else if(list.get(i) instanceof Instructor)
				{
					System.out.println(((Instructor) list.get(i)).getDepartment());
				}
		}
	}
public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);
	System.out.println("How would you like to evaluate?");
	String evaluatorType = sc.nextLine();
	HashMap<Long, Person> list = new HashMap<>();
	list.put(Person.lastId+1, makePerson(sc));
	list.put(Person.lastId+1, makeStudent(sc));
	list.put(Person.lastId+1, makeInstructor(sc));
	sc.close();
	loopThrough(list, evaluatorType);
}
}
