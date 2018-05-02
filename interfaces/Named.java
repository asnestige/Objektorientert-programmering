package interfaces;

public interface Named {
	public void setGivenName(String givenName);
	public void setFamilyName(String familyName);
	public void setFullName(String familyName);
	public String getGivenName();
	public String getFamilyName();
	public String getFullName();	
}