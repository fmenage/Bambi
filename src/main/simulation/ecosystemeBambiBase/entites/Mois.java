package main.simulation.ecosystemeBambiBase.entites;

import main.domain.MoisEnum;


/**
 * Mois
 * 
 * Objet de r�f�rence de temps (it�ration et mois de l'ann�e)
 * pour les objets de la simulation.
 * 
 * @author Jo�o Paulo
 */
public abstract class Mois {
	
	/**
	 * It�ration (initialis�e � 0).
	 */
    protected int iteration = 0;
    
    
    /**
     * Enum�ration de mois.
     */
    protected MoisEnum mois;
    
    
    /**
     * Getter d'it�ration.
     * @return It�ration actuelle.
     */
    public int getIteration() {
        return this.iteration;
    }

    
    /**
     * Getter d'�num�ration de mois.
     * @return Mois actuel en enum.
     */
    public MoisEnum getMois() {
        return this.mois;
    }
}
