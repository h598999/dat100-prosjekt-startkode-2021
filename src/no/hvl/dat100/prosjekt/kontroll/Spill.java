package no.hvl.dat100.prosjekt.kontroll;

import java.util.ArrayList;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.KortUtils;

/**
 * Klassen har objektvariaber som er referanser til de spillerne, nord og syd
 * (type ISpiller). Den har ogsÃƒâ€š en bunke man deler/trekker fra og en bunke man
 * spiller til.
 * 
 */
public class Spill {

	private ISpiller nord;
	private ISpiller syd;
	
	private Bord bord;
	
	// antall kort som skal deles ut til hver spiller ved start
	public final static int ANTALL_KORT_START = Regler.ANTALL_KORT_START;
	
	public Spill() {
		
		// TODO - START
		bord = new Bord();
		nord = new NordSpiller(Spillere.NORD);
		syd = new SydSpiller(Spillere.SYD);
		
		
		// TODO - END
		
	}
	
	/**
	 * Gir referanse/peker til bord.
	 * 
	 * @return referanse/peker bord objekt.
	 */
	public Bord getBord() {
		
		// TODO - START
		return bord;

		// TODO - END
		
	}
	
	/**
	 * Gir referanse/peker til syd spilleren.
	 * 
	 * @return referanse/peker til syd spiller.
	 */
	public ISpiller getSyd() {
		
		// TODO - START
		
		return syd;

		// TODO - END
		
	}

	/**
	 * Gir referanse/peker til nord.
	 * 
	 * @return referanse/peker til nord.
	 */
	public ISpiller getNord() {
		
		// TODO - START

	return nord;

		// TODO - END
	}

	/**
	 * Metoden oppretter to spillere, nord og syd. Det opprettes to bunker, fra
	 * og til. Alle kortene legges til fra. Bunken fra stokkes. Deretter deles
	 * det ut kort fra fra-bunken til nord og syd i henhold til regler. Til
	 * slutt tas ÃƒÂ¸verste kortet fra fra-bunken og legges til til-bunken.
	 * 
	 * Nord har type RandomSpiller (som er forhÃƒÂ¥ndefinert). Syd vil vÃƒÂ¦re spiller
	 * av en klasse laget av gruppen (implementeres i oppgave 3).
	 */
	public void start() {
		
		// TODO - START
	ISpiller spillernord = nord;
	ISpiller spillersyd = syd;
	Bord bordspill = bord;
	delutKort();
	Kort v = bordspill.getBunkeFra().taSiste();
	bordspill.getBunkeTil().leggTil(v);
		
		// TODO - END
	}

	/**
	 * Deler ut kort til nord og syd.
	 * 
	 */
	private void delutKort() {

		// TODO - START
	
	KortSamling kortstokk = bord.getBunkeFra();
	KortUtils.stokk(kortstokk);
	for (int i = 0; i<Regler.ANTALL_KORT_START; i++) {
		Kort v = kortstokk.taSiste();
		nord.leggTilKort(v);
	}
	
	for (int i = 0; i<Regler.ANTALL_KORT_START; i++) {
		Kort v = kortstokk.taSiste();
		syd.leggTilKort(v);
	}
		// TODO - END
	}

	/**
	 * Trekker et kort fra fra-bunken til spilleren gitt som parameter. Om
	 * fra-bunken er tom, mÃƒÂ¥ man "snu" til-bunken. Se info om metoden
	 * snuTilBunken().
	 * 
	 * @param spiller
	 *            spilleren som trekker.
	 * 
	 * @return kortet som trekkes.
	 */
	public Kort trekkFraBunke(ISpiller spiller) {

		// TODO - START
		Kort v = null;
				
				bord.snuTilBunken();
				v = bord.getBunkeFra().taSiste();
				spiller.leggTilKort(v);
				int x = spiller.getAntallTrekk();
				spiller.setAntallTrekk(x+1);
				return v;
		


		// TODO - END
	}

	/**
	 * Gir neste handling for en spiller (spilt et kort, trekker et kort, forbi)
	 * 
	 * @param spiller
	 *            spiller som handle.
	 * 
	 * @return handlingen som blir utfÃƒÂ¸rt.
	 */
	public Handling nesteHandling(ISpiller spiller) {
		
		// TODO - START
	return spiller.nesteHandling(bord.seOversteBunkeTil());

		// TODO - END
		
	}

	/**
	 * Metoden spiller et kort. Den sjekker at spiller har kortet. Dersom det er
	 * tilfelle, fjernes kortet fra spilleren og legges til til-bunken. Metoden
	 * nulltiller ogsÃƒÂ¥ antall ganger spilleren har trukket kort.
	 * 
	 * @param spiller
	 *            den som spiller.
	 * @param kort
	 *            kort som spilles.
	 * 
	 * @return true dersom spilleren har kortet, false ellers.
	 */
	public boolean leggnedKort(ISpiller spiller, Kort kort) {
		
		// TODO - START
		boolean a = false;
	if (spiller.getHand().har(kort)==true) {
		a=true;
		spiller.getHand().fjern(kort);
		bord.leggNedBunkeTil(kort);
		spiller.setAntallTrekk(0);
	}
	return a;
	

		// TODO - END
	}

	/**
	 * Metode for ÃƒÂ¥ si forbi. MÃƒÂ¥ nullstille antall ganger spilleren har trukket
	 * kort.
	 * 
	 * @param spiller
	 *            spilleren som er i tur.
	 */
	public void forbiSpiller(ISpiller spiller) {
		
		// TODO - START
	Handling forbi = new Handling(HandlingsType.FORBI, null);
	forbi.skifteTur();
	spiller.setAntallTrekk(0);
		// TODO - END
	}

	/**
	 * Metode for ÃƒÂ¥ utfÃƒÂ¸re en handling (trekke, spille, forbi). Dersom handling
	 * er kort, blir kortet ogsÃƒÂ¥ spilt.
	 * 
	 * @param spiller
	 *            spiller som utfÃƒÂ¸rer handlingen.
	 * @param handling
	 *            handling som utfÃƒÂ¸res.
	 * 
	 * @return kort som trekkes, kort som spilles eller null ved forbi.
	 */
	public Kort utforHandling(ISpiller spiller, Handling handling) {

		// TODO - START
		Kort kort = null;

		// Hint: del opp i de tre mulige handlinger og vurder 
		// om noen andre private metoder i klassen kan brukes
		// til ÃƒÂ¥ implementere denne metoden
				

if (handling.getType()==HandlingsType.FORBI) {
 kort = null;
	forbiSpiller(spiller);
}
		
	
if (handling.getType()==HandlingsType.TREKK) {
	kort = bord.getBunkeFra().taSiste();
	spiller.getHand().leggTil(kort);}

if (handling.getType()==HandlingsType.LEGGNED) {
	Kort[] hand = spiller.getHand().getSamling();
	kort = hand[0];
	spiller.getHand().fjern(kort);
	bord.getBunkeTil().leggTil(kort);}
return kort;	
	
}

		// TODO - END
	}


