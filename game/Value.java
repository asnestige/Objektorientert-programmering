package game;

public class Value {
	private Boolean fixed;
	private char value;
	private boolean reAquring;
	public Value(char value){
		setValue(value);
		reAquring = false;
		if (fixed == null && (value == '.' || value == '0')) {
			fixed = false;
		} else if (fixed == null && Character.isDigit(value)) {
			fixed = true;
		}
	}
	
	public Value(char value, boolean notNew){
		setValue(value);
		reAquring = false;
		fixed = false;
	}
	
	public boolean checkValidChange() {
		return ! fixed;
	}
	
	public void setValue(char value) {
		if(fixed == null || checkValidChange()) {
			this.value = value;
		}
		if (fixed == null && (value == '.' || value == '0')) {
			fixed = false;
		} else if (fixed == null && Character.isDigit(value)) {
			fixed = true;
		}
	}
	public Boolean getFixed() {
		return this.fixed;
	}
	public char getValue() {
		return this.value;
	}
	
	public void marked(boolean value) {
		if (value) {
			this.reAquring = true;
		} else {
			this.reAquring = false;
		}
	}
	
	@Override
	public String toString() {
		if (fixed == true) {
			return "("+value+")";
		} else if(reAquring) {
			return " "+value+"*";
		} else {
			return " "+value+" ";
		}
	}
	
}
