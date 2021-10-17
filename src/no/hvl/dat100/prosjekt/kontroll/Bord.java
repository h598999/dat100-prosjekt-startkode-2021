package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.KortUtils;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Klasse som implementerer bordet som spilles pÃ¥. 
 * 
 * Klassen har objektvariablene bunkeTil og bunkeFra som skal brukes til Ã¥ representere 
 * kortene som er i de to bunker pÃ¥ border. 
 */
public class Bord {

	private KortSamling bunkeFra;
	private KortSamling bunkeTil;
	
	/**
	 * Metoden oppretter to bunker, til- og fra-bunken
	 * Alle kortene legges til fra-bunken. 
	 */
	public Bord() {
		
		// TODO - START
	bunkeFra = new KortSamling();
	bunkeTil = new KortSamling();
			

	bunkeFra.leggTilAlle();
	bunkeTil.setSamling(new Kort[4*Regler.MAKS_KORT_FARGE]);
		// TODO - END
	}
	
	/**
	 * Gir peker/referanse til til-bunken.
	 * 
	 * @return referanse/peker til til-bunken.
	 */
	public KortSamling getBunkeTil() {
		
		return bunkeTil;
		
	}

	/**
	 * Gir peker/referanse til fra-bunken.
	 * 
	 * @return referanse/peker til fra-bunken.
	 */
	public KortSamling getBunkeFra() {
		
		return bunkeFra;
		
	}
	
	/**
	 * Sjekker om til-bunken er tom.
	 * 
	 * @return true om til-bunken er tom, false ellers.
	 */
	public boolean bunketilTom() {
		
		// TODO - START
				
	boolean a = false;
		if (bunkeTil.erTom()==true)
			a=true;
		return a;

		// TODO - END
	}

	/**
	 * Sjekker om fra-bunken er tom.
	 * 
	 * @return true om fra-bunken er tom, false ellers.
	 */
	public boolean bunkefraTom() {
		
		// TODO - START
		
		boolean a = false;
		if(bunkeFra.erTom()==true)
			a=true;
		return a;
	
		// TODO - END
		
	}
	
	/**
	 * Gir antall kort i fra-bunken.
	 * 
	 * @return antall kort i fra-bunken.
	 */
	public int antallBunkeFra() {
		
		// TODO - START
		
		int x = bunkeFra.getAntalKort();
		return x;

		// TODO - END
	}

	/**
	 * Gir antall kort i til-bunken.
	 * 
	 * @return antall kort i til-bunken.
	 */
	public int antallBunkeTil() {
		
		// TODO - START
		
	int x =bunkeTil.getAntalKort();
	return x;

		// TODO - END
	}
	
	/**
	 * Tar Ã¸verste kortet fra fra-bunken og legger dettte til til-bunken (med
	 * billedsiden opp, men det trenger ikke gruppen tenke pÃ¥).
	 */
	public void vendOversteFraBunke() {
		
		// TODO - START
		
		Kort[] samling = bunkeFra.getAllekort();
		Kort v = samling[samling.length-1];
		bunkeFra.fjern(v);
		bunkeTil.leggTil(v);
		
		// TODO - END
		
	}
		
	/**
	 * Tar Ã¸verste kortet fra fra-bunken.
	 * 
	 * @return peker/referanse til det kort som blev tatt fra fra-bunken
	 */
	
	public Kort taOversteFraBunke() {
		
		// TODO - START
Kort[] samling = bunkeFra.getAllekort();
Kort v = samling[samling.length-1];
bunkeFra.fjern(v);
return v;
		// TODO - END
	}
	
	/**
	 * Metode som leser Ã¸verste kortet i til-bunken. Kortet vil fremdeles vÃ¦re
	 * Ã¸verst i til-bunken etter at metoden er utfÃ¸rt.
	 * 
	 * @return peker/referanse til Ã¸verste kortet i til-bunken.
	 */
	public Kort seOversteBunkeTil() {
		
		// TODO - START
		
	return bunkeTil.seSiste();

		// TODO - END
	}
	
	/**
	 * NÃ¥r fra-bunken blir tom, tar man vare pÃ¥ kortet pÃ‚ toppen av til-bunken.
	 * Deretter legges alle den andre kortene i til-bunken over i fra-bunken.
	 * Denne stokkes og kortet som man har tatt vare pÃ‚ legges tilbake i
	 * til-bunken. Det vil nÃ¥ vÃ¦re det eneste kortet i til-bunken.
	 */
	public void snuTilBunken() {

		// TODO - START
		
		if (bunkeFra.erTom()==true) {
			Kort v = bunkeTil.taSiste();
		for (int i = 0; i<bunkeTil.getAntalKort(); i++) {
			
			Kort samling[]=bunkeTil.getAllekort();
			Kort b = samling[i];
			bunkeFra.leggTil(b);
		}
		bunkeTil.fjernAlle();
		KortUtils.stokk(bunkeFra);
		bunkeTil.leggTil(v);
		
		}
			
		// TODO - END
	}
		
	/**
	 * Metode som legger et kort i til-bunken. 
	 * 
	 * @param k
	 * 			kort som skal legges ned. 
	 * 	
	 */
	public void leggNedBunkeTil(Kort k) {
		
		// TODO - START
		bunkeTil.leggTil(k);
		// TODO - END
				
	}
}
