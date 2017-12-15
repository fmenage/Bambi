package main.simulation.ecosystemeBambiBase.entites;

import main.domain.MoisEnum;

/**
 * ControleurMois (sousclasse de Mois)
 * 
 * Objet qui controle les action d'incr�mentation de la 
 * r�f�rence de mois et d'it�ration.
 * 
 * @author Jo�o Paulo
 *
 */
public class ControleurMois extends Mois  {
	
	/**
	 * Constructeur.
	 * 
	 * @param mois0 Mois initial de la simulation.
	 */
    public ControleurMois(MoisEnum mois0) {
    	// enum de mois
    	super.mois = mois0;
    	
    	// it�ration 0
    	super.iteration = 0;
    }

    /**
     * M�thode d'incr�mentation d'un mois.
     */
    public void incrementer() {
    	// incr�mente l'it�ration
        super.iteration++;
        
        // changement de mois
        super.mois = super.mois == MoisEnum.Decembre ? MoisEnum.Janvier : super.mois.next();
    }

}
