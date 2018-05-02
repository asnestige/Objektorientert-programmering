package stateandbehavior;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AccountController {
	Account account = new Account(); 
	
    @FXML private TextField deposit;
    @FXML private TextField interestRate;
    @FXML private Button registerDeposit;
    @FXML private Button registerInterestRate;

    @FXML
    void handleClickDeposit(ActionEvent event) {
    		String a = deposit.getText();

    		int amount = Integer.parseInt(a); 
    		account.deposit(amount);	
    }

    @FXML
    void handleClickInterest(ActionEvent event) {
		String a = interestRate.getText();
		
		double amount = Double.parseDouble(a);
		account.setInterestRate(amount);
    }
}
