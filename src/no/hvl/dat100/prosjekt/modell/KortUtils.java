package no.hvl.dat100.prosjekt.modell;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. RekkefÃ¸lgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		
		Kort[] nysamling = samling.getAllekort();
		for (int i = 0;  i<nysamling.length-1; i++) {
			Kort v = nysamling[i];
			Kort b = nysamling[i+1];
			int x = v.compareTo(b);
			if (x==0) {
				nysamling[i]=v;
				nysamling[i+1]=b;}
			if (x<0) {
				nysamling[i]=v;
				nysamling[i+1]=b;
			
			}
			if (x>0) {
				nysamling[i]=b;
				nysamling[i+1]=v;
			}
			
			
		}
		if (samling.getAntalKort()==0) {
			samling.setAntall(0);
		}
		if (samling.erTom()!= true)
			samling.setSamling(nysamling);
	

	
	
	
}
	
	
	
	
		// TODO - END
	
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		
		// TODO - START
		Kort[]stokket = samling.getAllekort();
		Kort[]sortert = stokket;
		for (int i = 0; i<stokket.length; i++) {
			int j = (int)Math.random()*stokket.length;
			Kort temp = sortert[i];
			temp = stokket[j];
			
		}
		if (samling.erTom()!=true)
		samling.setSamling(stokket);
		// TODO - END
	}
	
}
