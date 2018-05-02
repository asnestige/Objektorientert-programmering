package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class PersonTest extends TestCase{
	private Person p1;
	private Person p2; 
	private Person p3; 
	private Person p4; 
	
	@Before
	public void setUp() throws Exception { //Oppretter kontoer for testing 
		p1 = new Person("Mamma Kari", 'F');
		p2 = new Person("Pappa Karl", 'M');
		p3 = new Person("Sønn Henning", 'M');
		p4 = new Person("Datter Lise", 'F');
		p1.addChild(p3);
		p1.addChild(p4);
		p2.addChild(p3);
		p2.addChild(p4);
		
		}
	
	@Test
	public void testgetName() {
		assertEquals("Mamma Kari", p1.getName());
	}
	
	@Test
	public void testgetParents() {
		assertEquals(p1, p3.getMother());
		assertEquals(p2, p3.getFather());
		}
	
	@Test
	public void testgetChild() {
		assertEquals(p3, p1.getChild(0));
		assertEquals(p4, p1.getChild(1));
		
		try {
			p1.getChild(3); 
			fail("Ikke så få barn...");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			p1.getChild(-1); 
			fail("Ikke så få barn...");
		}
		catch (IndexOutOfBoundsException e) {
		}
	}
	
	@Test
	public void testgetChildrenCount() {
		assertEquals(2, p1.getChildCount());
	}
	
	@Test
	public void testremoveChild() {
		p1.removeChild(p3);
		assertEquals(1, p1.getChildCount());
		assertEquals(p4, p1.getChild(0));
		
		p2.removeChild(p4);
		assertEquals(1, p2.getChildCount());
		
		try {
			p3.getMother();
			fail("Mother is removed"); //Mother and father does not get removed 
		}
		catch (IllegalArgumentException e) {
		}
		try {
			p4.getFather();
			fail("Father is removed");
		}
		catch (IllegalArgumentException e) {
		}
	}
}
/* 
 * fail("Not yet implemented");
Person(String name, char gender) - tar inn navn og kjønn, som kun skal kunne settes i konstruktøren
!getName() - returnerer navnet knyttet til dette Person-objektet
getGender() - returnerer tegnet som representerer kjønnet, enten 'F' eller 'M'
!getMother() - returnerer Person-objektet som er moren, evt. null
!getFather() - returnerer Person-objektet som er faren, evt. null
!getChildCount() - returnerer antall barn dette Person-objektet har
!getChild(int n) - returnerer barn nr. n (altså et Person-objekt), evt. utløser (et passende) unntak om n er for stor (eller liten)
?addChild(Person) - oppretter en kobling til et barn (et annet Person-objekt). Dersom Person-objektet som metoden kalles på, er en kvinne, så skal denne bli barnets mor, og motsatt, dersom Person-objektet som metoden kalles på, er en mann, så skal denne bli barnets far.
!removeChild(Person) - fjerner en kobling til et barn (et annet Person-objekt). Dersom Person-objektet som metoden kalles på, er moren til argumentet, så skal mother-koblingen fjernes, og motsatt, dersom Person-objektet som metoden kalles på, er argumentets far, så skal father-koblingen fjernes.
setMother(Person) - setter argumentet (en kvinne) som moren til Person-objektet som metoden kalles på. Argumentet får samtidig registrert Person-objektet som metoden kalles på, som sitt barn.
 */
