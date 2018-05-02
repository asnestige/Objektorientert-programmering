package patterns.observable;

public class HighscoreProgram implements HighscoreListListener{
	private HighscoreList list; 
	private int element; 
	
	@Override
	public void listChanged(HighscoreList list, int element) { //observerer endringer i HighscoreList-instansen og skriver ut posisjonsargumentet, samt selve listen, til konsollet
			
	}
	public void init() { //oppretter en ny HighscoreList og registrerer seg selv (altså HighscoreListProgram-instansen) som lytter
	
	}
	public void run() { //leser inn tall (resultater) fra konsollet og legger dem til i listen
	
	}
}
