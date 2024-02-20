import java.util.List;

//@author Jack Healy
//@version 1
//A generic animal
public abstract class Animal {
	boolean randomAge;
	Field field;
	Location location;
	int age;
	boolean alive;
	//Sets up the animal.
	public Animal(boolean randomAge, Field field, Location location)
	{
		age = 0;
		alive = true;
		this.field = field;
		setLocation(location);
		this.randomAge = randomAge;
	}
	//The animal performs an action.
	abstract public void act(List<Animal> newAnimals);
	//@Return randomAge
	public boolean isRandomAge() {
		return randomAge;
	}
	//@param randomAge
	public void setRandomAge(boolean randomAge) {
		this.randomAge = randomAge;
	}
	//@return field
	public Field getField() {
		return field;
	}
	//@param field
	public void setField(Field field) {
		this.field = field;
	}
	//@return location
	public Location getLocation() {
		return location;
	}
	//@param newLocation
    public void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    //@return age
	public int getAge() {
		return age;
	}
	//@param age
	public void setAge(int age) {
		this.age = age;
	}
	//@return alive
	public boolean isAlive() {
		return alive;
	}
	//@param alive
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
