package encapsulation;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Person {
	private static String[] cc = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
	private List<String> newList = Arrays.asList(cc);
	private String firstName, sirName;
	private String email;
	private Date birthday;
	private char gender; 
	
	
	public Person() {
		
	}
	
	public Person(String name, String email, Date birthday, char gender) {
		setName(name);
		setEmail(email);
		setBirthday(birthday);
		setGender(gender);
	}
	
	public void setName(String name) { //Fornavn + etternavn (minst to bokstaver)
		String [] splited = name.split("\\s+");
		int teller = 0; 
		char[] fullName = name.toCharArray();
		for (int i = 0; i < fullName.length; i++) {
			if (!Character.isLetter(fullName[i])) {
				teller ++;
			}
		}
		if (teller != 1) {
			throw new IllegalArgumentException();
		}
		if (splited[0].length() < 2 || splited[1].length() < 2 || splited.length > 2) {
			throw new IllegalArgumentException();
		}
		else {
			this.firstName = splited[0];
			this.sirName = splited[1];
		}
	}
	
	public String getName () {
		return firstName + " " + sirName;
	}
	
	public void setEmail(String email) { //Sjekk om det stemmer overens med navnet + fornavn.etternavn@domene.landskode eller ikke noe
		if (email == null) {
			this.email = email;
			return;
		}
		if (email.indexOf('@') == -1) {
			throw new IllegalArgumentException("Mangler @");
		}
			
		String [] emailSplit = email.split("@");
		String [] nameSplit = emailSplit[0].split("\\.");
		String [] domeneSplit = emailSplit[1].split("\\.");
		
		if (nameSplit.length != 2) {
			throw new IllegalArgumentException("For mange navn");
		}
		if (!nameSplit[0].equals(firstName.toLowerCase()) || !nameSplit[1].equals(sirName.toLowerCase())) {
			throw new IllegalArgumentException("Feil navn");
		}
		if (domeneSplit.length != 2) {
			throw new IllegalArgumentException("Feil antall etter @");
		}
		if (!newList.contains(domeneSplit[1])) {
			throw new IllegalArgumentException("Feil");
		}
		this.email = email;
	}
	
	public String getEmail () {
		return email;
	}
	
	public void setBirthday(Date birthday) { //Dato-objekt (java.util.Date) og ikke frem i tid
		Date today = new Date();
		boolean before = today.before(birthday);
		if (before == false) {
			this.birthday = birthday;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public Date getBirthday () {
		return birthday; 
	}
	
	public void setGender(char gender) { //'M', 'F' eller '\0' (null-tegnet)
		if (gender == 'M' || gender == 'F' || gender == '\0') {
			this.gender = gender;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public static void main(String[] args) {
		
		Person p = new Person("Gunn Pedersen","gunn.pedersen@ntnu.no", new Date(), 'F');
	}
}

