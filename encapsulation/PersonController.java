package encapsulation;

//import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PersonController {
	Person person = new Person();
	
	@FXML TextField name; 
	//@FXML TextField birthday; 
	@FXML TextField email; 
	@FXML TextField gender; 
	@FXML Button register; 
	
	@FXML
	void click(ActionEvent event) {
		String a = name.getText();
		//String b = birthday.getText();
		String c = email.getText();
		String d = gender.getText();
		
		/*String [] g = b.split("-");
		int year = Integer.parseInt(g[0]);
		int month = Integer.parseInt(g[1]);
		int day = Integer.parseInt(g[2]);*/
		
		//Date e = new  Date(year,month,day);
		char f = d.charAt(0);
		
		person.setName(a); 
		//person.setBirthday(e);
		person.setEmail(c); 
		person.setGender(f);
	}
}

    