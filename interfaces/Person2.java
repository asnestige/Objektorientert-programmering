package interfaces;

public class Person2 implements Named{
	private String fullName; 
	
	public Person2 (String fullName) {
		this.fullName = fullName; 
	}
	
	@Override
	public void setGivenName(String givenName) {
		String[] temp = this.fullName.split(" ");
		temp[0] = givenName; 
		this.fullName = temp[0] + " " + temp[1];
	}

	@Override
	public void setFamilyName(String familyName) {
		String[] temp = this.fullName.split(" ");
		temp[1] = familyName; 
		this.fullName = temp[0] + " " + temp[1];
	}

	@Override
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String getGivenName() {
		return fullName.split(" ")[0];
	}

	@Override
	public String getFamilyName() {
		return fullName.split(" ")[1];
	}

	@Override
	public String getFullName() {
		return fullName; 
	}
}
