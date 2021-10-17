package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for Ã¥ lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. NÃ¥r
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det vÃ¦re praktisk Ã¥ ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		
		// TODO - START
		this.antall = 0;
		this.samling = new Kort[MAKS_KORT];
		// TODO - END
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke vÃ¦re
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan fÃ¥
	 * tilgang til antallet ved Ã¥ bruke metoden getAntallKort(). Metoden er
	 * fÃ¸rst og fremst ment Ã¥ brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {
		
		return samling;
		
	}
	
	public void setSamling(Kort[]tabell) {
		samling=tabell;
	}
	
	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		
		// TODO - START
		
	return antall;
		
		// TODO - END
	}
	
	public void setAntall(int x) {
		antall=x;
	}
	
	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
		
		// TODO - START
				
		boolean a = false;
		if (antall==0)
			a = true;
		return a;
		
		// TODO - END
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		
		// TODO - START
	samling[antall]=kort;
	antall++;
		// TODO - END
		
	}
	
	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil vÃ¦re sortert
	 * slik at de normalt mÃ¥ stokkes fÃ¸r bruk.
	 */
	public void leggTilAlle() {
		
		// TODO - START
		// Husk: bruk Regler.MAKS_KORT_FARGE for Ã¥ fÃ¥ antall kort per farge	for (int i =0; i<Regler.MAKS_KORT_FARGE; i++) {
for (Kortfarge f : Kortfarge.values()) {
	for (int i=1; i<=Regler.MAKS_KORT_FARGE;i++) {
		Kort v = new Kort(f,i);
		leggTil(v);
		
	}
		
	}
	
}
	
	
	
	
		// TODO - END
	

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		
		// TODO - START
		int o = antall;
		for (int i=0; i<o; i++) {
			samling[i]=null;
			antall--;
			
		}
		// TODO - END
	}
	
	/**
	 * Ser pÃ¥ siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort seSiste() {
		
		// TODO - START
		int i = antall-1;
		Kort v=samling[0];
		if(i<0)
		v = samling[antall];
		if (i>0) {
		v = samling[antall-1];}
		return v;

		// TODO - END
		
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		
		// TODO - START
		
int i = antall-1;
Kort v = samling[0];
if (0<=i) {
	v=samling[antall-1];
	samling[antall-1]=null;
	antall--;
}

		return v;
		// TODO - END
	}
	
	/**
	 * UndersÃ¸ker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		
		// TODO - START
	boolean a = false;
	int i = 0;
	while (i<samling.length&&kort!=null) {
		Kort v = samling[i];
		if (v!=null) {
	
		if (v.lik(kort)==true)
			a = true;}
		
		i++;
	}
		return a;
	}

	
		// return false;
		// TODO - END
		
	

	/**
	 * Fjernar et kort frÃ¥ samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting med samilingen
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */
			 
	public boolean fjern(Kort kort) {
boolean a = false;
int i =0;
while (i<samling.length&&a==false&&kort!=null) {
	Kort v = samling[i];
	if (v!=null) {
		if (v.lik(kort)==true) {
			samling[i]=null;
			antall--;
			a=true;}}
	
		i++;
	}
	
	
	
return a;
		
		
		
	
		
	}
	
		// TODO - END
	

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefÃ¸lge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {
		
		// TODO - START
		
		Kort[] nytabell = new Kort[antall];
		for (int i=0; i<antall; i++) {
			nytabell[i]=samling[i];
			
		}
		return nytabell;

		// TODO - END
	
	}
	
}
