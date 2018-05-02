package interfaces;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator {
	private Iterator<Double> iterator1, iterator2; //Liste med x og y verdi 
	private BinaryOperator<Double> operator; //Metoren for å iterere 
	private Double default1, default2; //Verdier vi setter inn om vi ikke har fått y (Null om det ikke er nødvendig)
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1; 
		this.iterator2 = iterator2; 
		this.operator = operator; 
	}
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1; 
		this.iterator2 = iterator2; 
		this.operator = operator; 
		this.default1 = default1;
		this.default2 = default2;
	}
	
	public boolean hasNext() {
		if (iterator1.hasNext() && iterator2.hasNext()) {
			return true;
		}
		if (iterator1.hasNext() && (default2 != null)) {
			return true;
		} 
		if ((default1 != null) && iterator2.hasNext()) {
			return true;
		} 
		return false; 
	}
	
	public Double next() {
		if (iterator1.hasNext() && iterator2.hasNext())
			return operator.apply(iterator1.next(), iterator2.next()); 
		if (iterator1.hasNext() && !iterator2.hasNext())
			return operator.apply(iterator1.next(), default2);
		if (!iterator1.hasNext() && iterator2.hasNext())
			return operator.apply(default1, iterator2.next());
		return null; 
	}
}