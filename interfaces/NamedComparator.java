package interfaces;

import java.util.Comparator; 

public class NamedComparator implements Comparator<Named>{

	@Override
	public int compare(Named named1, Named named2) { //Sammenlikne navn parvis	
		String familyName1 = named1.getFamilyName(); 
		String familyName2 = named2.getFamilyName(); 
		String givenName1 = named1.getGivenName(); 
		String givenName2 = named2.getGivenName(); 
		
		if (familyName1.compareTo(familyName2) == 0) {
			return givenName1.compareTo(givenName2);
		}
		return familyName1.compareTo(familyName2);
	} 
}