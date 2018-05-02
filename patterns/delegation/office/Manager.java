package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
	private Collection<Employee> employees; 
	private int taskCount = 0; 
	private Iterator<Employee> it;
		
	public Manager (Collection<Employee> employees) {
		if (employees.isEmpty()) {
			throw new IllegalArgumentException (); 
		}
		this.employees = employees; 
		newIterator();
	}
		
	private void newIterator() {
		it = employees.iterator();
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		if (!it.hasNext())
			newIterator();
		taskCount += 1; 
		double calculation = it.next().doCalculations(operation, value1, value2);
		return calculation;
	}

	@Override
	public void printDocument(String document) {
		if (!it.hasNext())
			newIterator();
		it.next().printDocument(document);
		taskCount += 1; 
	}

	@Override
	public int getTaskCount() {
		return taskCount; 
	}

	@Override
	public int getResourceCount() {
		int resourceCount = 1; 
		for (Employee e : employees)
			resourceCount += e.getResourceCount(); 
		return resourceCount;
	}
	
	public static void main(String[] args) {
		Printer p = new Printer();
		Collection<Employee> e1 = new ArrayList<>();
		e1.add(new Clerk(p));
		e1.add(new Clerk(p));
		e1.add(new Clerk(p));
		e1.add(new Clerk(p));
		e1.add(new Clerk(p));
		e1.add(new Clerk(p));
		e1.add(new Clerk(p));
		Manager manager = new Manager(e1);
		
		manager.doCalculations((x,y) -> x + y,2,5); 
		manager.doCalculations((x,y) -> x * y,2,5); 
		
		System.out.println(manager.getResourceCount());
		System.out.println(manager.getTaskCount());
	}
}


