package testing;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;

	private char gender;

	public final static char MALE = 'M';
	public final static char FEMALE = 'F';

	private Person mother;
	private Person father;

	private List<Person> children = new ArrayList<>();

	public Person(String name, char gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	private char getGender() { //Public? 
		return gender;
	}

	public Person getMother() {
		return mother;
	}

	public Person getFather() {
		return father;
	}

	public int getChildCount() {
		return children.size();
	}

	public Person getChild(int n) {
		if (n > getChildCount() || n < 0) {
			throw new IndexOutOfBoundsException("Child index out of range");
		}
		return children.get(n);
	}

	private void checkGender(Person person, char gender) {
		if (person != null && person.gender != gender) {
			throw new IllegalArgumentException("Wrong gender for parent");
		} 
	}

	private void checkOwnParent(Person person, Person parent) {
		if (person == parent) {
			throw new IllegalArgumentException("A person cannot be its own parent");
		}
	}

	public void setMother(Person mother) {
		checkGender(mother, FEMALE);
		checkOwnParent(this, mother);

		if (mother == this.mother) {
			return; //Retuerner hva?
		}

		if (this.mother != null) {
			this.mother.removeChild(this);
		}

		this.mother = mother;

		if (this.mother != null) {
			this.mother.addChild(this);
		}
	}

	public void setFather(Person person) {
		checkGender(father, MALE);
		checkOwnParent(this, father);

		if (father != null && father.equals(person)) {
			return; //Returnere hva?
		}

		if (person != null) {
			person.removeChild(this);
		}

		father = person;

		if (person != null) {
			person.addChild(this);
		}
	}

	public void addChild(Person person) {
		if (children.contains(person)) {
			return;
		}
		children.add(person);

		if (getGender() == MALE) {
			person.setFather(this);
		} else if (getGender() == FEMALE) {
			person.setMother(this);
		}
	}

	public void removeChild(Person child) {
		if (! children.contains(child)) {
			return;
		}
		children.remove(child);
		// clear mother or father of child
		if (this == child.getFather()) {
			child.setFather(null);
		} else if (this == child.getMother()) {
			child.setMother(null);
		}
	}
}
