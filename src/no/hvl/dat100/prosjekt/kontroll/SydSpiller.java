package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Klasse som for Ã¥ representere en vriÃ¥tter syd-spiller. Strategien er Ã¥ lete
 * gjennom kortene man har pÃ¥ hand og spille det fÃ¸rste som er lovlig.
 *
 */
public class SydSpiller extends Spiller {

	/**
	 * KonstruktÃ¸r.
	 * 
	 * @param spiller
	 *            posisjon for spilleren (nord eller syd).
	 */
	public SydSpiller(Spillere spiller) {
		super(spiller);
	}

	/**
	 * Metode for Ã¥ implementere strategi. Strategien er Ã¥ spille det fÃ¸rste
	 * kortet som er lovlig (ogsÃ¥ en Ã¥tter selv om man har andre kort som ogsÃ¥
	 * kan spilles). Dersom man ikke har lovlige kort Ã¥ spille, trekker man om
	 * man ikke allerede har trukket maks antall ganger. I sÃ¥ fall sier man
	 * forbi.
	 * 
	 * @param topp
	 *            kort som ligg Ã¸verst pÃ¥ til-bunken.
	 */
	@Override
	public Handling nesteHandling(Kort topp) {

		// TODO - START
		/* first-fit strategi */
		
		
	Handling forbi = new Handling(HandlingsType.FORBI, null);
	Handling leggned = new Handling(HandlingsType.LEGGNED, null);
	Handling trekk = new Handling(HandlingsType.TREKK, null);
	for (int i = 0; i<getHand().getAntalKort(); i++) {
		Kort v = getHand().getSamling()[i];
		if (Regler.kanLeggeNed(v, topp)==true) {
			return leggned;
			
		}
		else if (Regler.kanLeggeNed(v, topp)==false&&getAntallTrekk()<1) {
			
		
		}
		
		else {
			return forbi;
		}
		
	}
	
		// TODO - END
	}
}
