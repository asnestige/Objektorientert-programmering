package interfaces;

public class Person1 implements Named{
	private String givenName;
	private String familyName; 
	
	public Person1 (String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName; 
	}
	
	@Override
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	@Override
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@Override
	public void setFullName(String fullName) {
		this.givenName = fullName.split(" ")[0];
		this.familyName = fullName.split(" ")[1];
	}

	@Override
	public String getGivenName() {
		return givenName;
	}

	@Override
	public String getFamilyName() {
		return familyName;
	}

	@Override
	public String getFullName() {
		String fullName = givenName + " " + familyName;
		return fullName;
	}	
}
