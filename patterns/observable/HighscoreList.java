package patterns.observable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HighscoreList {
	int maxSize;
	private Collection<HighscoreListListener> listListener = new ArrayList<>(); 
	List<Integer> list = new ArrayList<>(); 
	
	public HighscoreList(int maxSize) {//konstruktøren tar inn maks antall resultater som lista skal kunne holde. Denne verdien må brukes av addResult, slik at resultater som er for dårlige kastes.
		this.maxSize = maxSize; 
	}
	
	public int size() { //returnerer antall elementer i lista, som altså aldri skal overstige maks-antallet
		return list.size(); 
	}
	
	public int getElement(int element) {//returnerer resultatet i posisjonen angitt av argumentet
		return list.get(element);
	}
	
	public void addResult(int result) { //registrere et nytt resultat, og dersom resultatet er godt nok til å komme med på lista, så legges det inn på riktig plass. Dersom lista blir for lang, så må dårligste resultat kastes. Alle registrerte lyttere må få beskjed om en evt. endring av lista, inkludert på hvilken posisjon som ble endret.
		int temp = 0; 
		while (temp < size() && result >= list.get(temp)) {
			temp ++; 
		}
		if (temp < maxSize) {
			while (size() >= maxSize) {
				list.remove((size() - 1));
			}
		list.add(temp, result); 
		fireListChanged(temp);
		}
}
	
	public void addHighscoreListListener(HighscoreListListener listener) { //registrerer en ny lytter
		if (! listListener.contains(listener)) {
			listListener.add(listener);
		}
	}
	
	public void removeHighscoreListListener(HighscoreListListener listener) {//fjerner en tidligere registrert lytter
		if (listListener.contains(listener)) {
			listListener.remove(listener);
		}
	}
	private void fireListChanged(int temp) {
		for (HighscoreListListener listListener : listListener) {
			listListener.listChanged(this, temp);
		}
	}
}
