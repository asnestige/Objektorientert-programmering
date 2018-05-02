package game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SodokuVisual {
	List<Value> values;
	private Stack<String> undo; 
	private Stack<String> redo;
	private String OGBoard;
	
	public SodokuVisual() {
		undo = new Stack<>(); 
		redo = new Stack<>(); 
		
		String template2 = "...6...513....2..66...3..89..4.2.6...3.418.2...8.7.1..59..6...38..3....241...9...";
		OGBoard = template2;
		initisalizeBoard(template2);
	}
		
	public void save(String fileName) {
		try
        {
            PrintWriter outFile = new PrintWriter(fileName);
            outFile.print(saveBoard());
            outFile.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: file 'test.txt' could not be opened for writing.");
            System.exit(1);
        }
	}
	
	public void load(String fileName) {
		Scanner in;
        try
        {
            in = new Scanner(new FileReader(fileName));
             
            while(in.hasNext()){
            		String line = in.nextLine();
            		values.clear();
            		redo.clear(); 
            		undo.clear(); 
    				initisalizeBoard(line);
            }
            in.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: file 'test.txt' could not be opened. Does it exist?");
            System.exit(1);
        }
	}
	
	public void undo() {
		if (!undo.empty()) {
			String saved = undo.pop();
			redo.push(this.saveBoard()); 
			values.clear();
			initisalizeBoard(saved);
			System.out.println(saved);
		}
	}
	
	public void redo() {
		if (!redo.empty()) {
			String saved = redo.pop();
			undo.push(this.saveBoard());
			values.clear();
			initisalizeBoard(saved);
			System.out.println(saved);
		}
	}
	
	public String toString() {
		String s = "";
		int counter = 1;
		int v = 0;
		for (int y = 0; y<13;y++) {
			if (y %4 == 0) {
				s += "  ";
				for (int x = 0; x < 43; x++) {
					if (x % 14 == 0) {
						s += "+";
					} else {
						s += "-";
					}
				}
			} else {
				s += counter+" ";
				counter += 1;
				for (int x = 0; x<25;x++) {
					if (x%8 == 0) {
						s += "|";
					} else if (x%2 == 1) {
						s += " ";
					} else {
						s += values.get(v).toString();
						v += 1;
					}
				}
			}
		s += "\n";	
		}
		s+=("     a   b   c     d   e   f     g   h   i");
		return s;
	}
	
	public void initisalizeBoard(String template) {
		values = new ArrayList<Value>(template.length());
		for (int i = 0; i < template.length(); i++) {
			if(OGBoard.charAt(i) == template.charAt(i)) {
				values.add(new Value(template.charAt(i)));
			} 
			else {
				values.add(new Value(template.charAt(i), true));
			}
		}
	}
	
	public String saveBoard() {
		String out ="";
		for (Value cell : values) {
			out+=cell.getValue();
		}
		return out;
	}
	
	public void updateValue(String newValue) {
		String[] update = newValue.split(" ");
		int value1 = Character.getNumericValue(update[0].charAt(0))-1;
		int value2 = (int) (update[0].charAt(1)-97);
		int numberValue = Character.getNumericValue(update[1].charAt(0));
		//values.get(value1*9+value2).marked(checkReAquring());
		if ((((value1 >= 0 && value1 < 9) && (value2 >= 0 && value2 < 9)) && (numberValue > 0 && numberValue < 10)) && values.get(value1*9+value2).checkValidChange()) {
			undo.push(this.saveBoard());
			redo.clear(); 
			values.get(value1*9+value2).setValue(update[1].charAt(0));
			checkReAquring();
		} else {
			System.out.println("Ikke godkjente verdier.");
		}
	}
	
	public void checkReAquring() {
		for (int i = 0; i < values.size(); i++) {
			values.get(i).marked(false);
		}
		
		for (int i = 1; i < 10; i++) {
			checkHorisontal(i);
			checkVertical(i);
			checkColom(i);
		}
	}
	
	public void checkHorisontal(int val) {
		for (int x = 0; x < 9; x++) {
			List<Integer> num = new ArrayList<Integer>();
			for (int y = 0; y < 9; y++) {
				if (Character.getNumericValue(values.get(x*9+y).getValue()) == val) {
					num.add(x*9+y);
				}
			}
			if (num.size() > 1) {
				for (int k = 0; k < num.size(); k++) {
					values.get(num.get(k)).marked(true);
				}
			}
		}
	}
	public void checkVertical(int val) {
		for (int x = 0; x < 9; x++) {
			List<Integer> num = new ArrayList<Integer>();
			for (int y = 0; y < 9; y++) {
				if (Character.getNumericValue(values.get(x+9*y).getValue()) == val) {
					num.add(x+9*y);
				}
			}
			if (num.size() > 1) {
				for (int k = 0; k < num.size(); k++) {
					values.get(num.get(k)).marked(true);
				}
			}
		}
	}
	public void checkColom(int val) {
		for (int y = 0; y < 3; y++) {
		for (int x = 0; x < 3; x++) {
			List<Integer> num = new ArrayList<Integer>();
			for (int a = 0; a < 3; a++) {
				for (int b = 0; b < 3; b++) {
					if (Character.getNumericValue(values.get(a*9+b+3*x+27*y).getValue()) == val) {
						num.add(a*9+b+3*x+27*y);
					}
				}
			}
			if (num.size() > 1) {
				for (int k = 0; k < num.size(); k++) {
					values.get(num.get(k)).marked(true);
				}
			}
		}
		}
	}
	
	public void getInput(String in) {
		updateValue(in);
	}
	
	public static void main(String[] args) {
		SodokuVisual brett = new SodokuVisual();
		System.out.println(brett.toString());
	}
}
