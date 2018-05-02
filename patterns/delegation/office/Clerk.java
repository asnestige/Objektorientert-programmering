package patterns.delegation.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee{
	private int taskCount = 0; 
	private Printer printer; 
	
	public Clerk(Printer printer) {
		this.printer = printer; 
	}
	
	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		taskCount += 1; 
		return operation.apply(value1, value2);
	}

	@Override
	public void printDocument(String document) {
		printer.printDocument(document, this);
		taskCount += 1; 
	}
		
	@Override
	public int getTaskCount() {
		return taskCount; 
	}

	@Override
	public int getResourceCount() {
		return 1; 
	}
	
}
