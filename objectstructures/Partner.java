package objectstructures;

public class Partner {
	private String name;
	private Partner partner; 
	
	public Partner (String name) {
		this.name = name; 
	}
	
	public void setPartner(Partner partner) { //Sette og oppløse partnerskap 
		Partner oldPartner = this.partner; 
		
		if (partner != null) { //Sjekker om vi ønsnsker å få partner 
			this.partner = partner; //Setter vår nye partner som vår partner 
			
			if (oldPartner != null) { //Sjekker om vår gamle partner eksiterer 
				oldPartner.setPartner(null); //Setter den gamle partneren vår til null
			}
			if (partner.getPartner() != this) { //Sjekker om vår partner sin gamle partner ikke var oss 
				partner.setPartner(this); //Setter den gamle partneren til partneren vår til null 
			}
		}
		
		if (partner == null) { //Sjekker om vi vil bli single eller ikke 
			this.partner = null; //Setter oss selv til null 
			if (oldPartner != null && oldPartner.getPartner() == this) {
				oldPartner.setPartner(null); //Setter den gamle partneren vår til null  
			} 
		}
	}

	public String getName() {
		return name; 
	}
	
	public Partner getPartner() {
		return partner;
	}
	
	@Override
	public String toString() {
		return String.format("%s er partner med %s", name, (partner != null ? partner.name : null)) ;
	}
	
	public static void main (String[] args) {
		Partner p1 = new Partner("Gunnar");
		Partner p2 = new Partner("Nina");
		Partner p3 = new Partner("Ole");
		Partner p4 = new Partner("Trine");
		
		p1.setPartner(p2);
		p3.setPartner(p4);
		
		System.out.println("Hyggelig forhold:");
		System.out.println(p1.getPartner());
		System.out.println(p2.getPartner());
		System.out.println(p3.getPartner());
		System.out.println(p4.getPartner());
		System.out.println("\n");
		System.out.println("Firkantdrama:");
		
		p2.setPartner(p4);
		
		System.out.println(p1.getPartner());
		System.out.println(p2.getPartner());
		System.out.println(p3.getPartner());
		System.out.println(p4.getPartner());
	}
}