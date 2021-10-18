package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.KortUtils;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Abstrakt klasse som implementerer alle metodene i kontrakten (interfacet) ISpiller,
 * bortsett fra nesteHandling(). Dette er grunnen til at klassen er abstrakt.
 * For ÃƒÂ¥ lage "virkelige" spillere, mÃƒÂ¥ vi arve fra denne klassen og implementere
 * nesteHandling (fra ISpiller).
 * 
 * Klassen har objektvariablene hand (Hand), antalltrekk (heltall) og spiller
 * (Spillere). Den har to konstruktÃƒÂ¸rer. Se beskrivelse av disse.
 * 
 */
public abstract class Spiller implements ISpiller {

	// hand for spilleren (samling)
	private KortSamling hand; 
	
	// antall trekk spilleren har gjort fra fra-bunken
	private int antalltrekk; 
	
	// hvem spilleren er (Nord,Syd,Ingen) - se oppramsklassen Spillere
	private Spillere spiller;

	/**
	 * Standard konstruktÃƒÂ¸r som oppretter en Spiller med en hÃƒÂ¥nd uten kort,
	 * antalltrekk som 0 og setter spiller til Spillere.INGEN.
	 */
	public Spiller() {
		
		// TODO - START
	spiller = Spillere.INGEN; 
	hand = new KortSamling();
	antalltrekk = 0;
	
		// TODO - END
	}

	/**
	 * KonstruktÃƒÂ¸r der vi kan sette hvilken spiller det er (NORD, SYD eller
	 * INGEN).
	 * 
	 * @param spiller
	 *            hvilken spiller det er.
	 */
	public Spiller(Spillere spiller) {
		this.spiller=spiller;
		hand = new KortSamling();
		antalltrekk = 0;
		
		
		}
	
	
		// TODO - END
	

	public int getAntallKort() {
		
		// TODO - START
		
	return hand.getAntalKort();

		// TODO - END
	}

	public KortSamling getHand() {
		
		// TODO - START
		
		return hand;

		// TODO - END
	}

	public int getAntallTrekk() {
		
		// TODO - START
	return antalltrekk;

		// TODO - END
	}

	public Spillere hvem() {
		
		// TODO - START
		
		return spiller;

		// TODO - END
		
	}

	public void setAntallTrekk(int t) {
		
		// TODO - START
		
		antalltrekk = t;
		// TODO - END
	}

	public boolean erFerdig() {
		
		// TODO - START
	boolean a = false;
	if (hand.erTom()==true)
		a=true;
	return a;
		// TODO - END
		
	}

	public void leggTilKort(Kort kort) {
		
		// TODO - START
	hand.leggTil(kort);
		// TODO - END
		
	}

	public void fjernKort(Kort kort) {
		
		// TODO - START
		hand.fjern(kort);
		
		// TODO - END
		
	}

	public void fjernAlleKort() {
		
		// TODO - START
		
	hand.fjernAlle();
		// TODO - END
	}

	public void trekker(Kort kort) {
		
		// TODO - START
		hand.leggTil(kort);
		antalltrekk++;
		// TODO - END
		
	}
}
