package patterns.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
	Map<Employee, List<String>> printHistory = new HashMap<>();
	public void printDocument(String document, Employee employee) {
		if (!printHistory.containsKey(employee)) {
			List<String> printedDocuments = new ArrayList<>(); 
			printHistory.put(employee, printedDocuments);
		}
		printHistory.get(employee).add(document); 	
		System.out.println(document);
	}
	public List<String> getPrintHistory(Employee employee) {
		List<String> tmp = printHistory.get(employee);
		return tmp == null ? new ArrayList<String>() : tmp;
	}
}
