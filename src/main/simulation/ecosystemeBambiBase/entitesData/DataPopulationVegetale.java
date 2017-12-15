package main.simulation.ecosystemeBambiBase.entitesData;

/**
 * Sp�cification de la data de population pour les v�g�taux (sousclasse de DataPopulation).
 * 
 * Quantite individu : UP = kg
 * Besoin eau par individu : Litre / kg / mois
 * Besoin vegetal par individu :-
 * 
 * @author Jo�o Paulo
 */
public class DataPopulationVegetale extends DataPopulation {
	
	/**
	 * Taux de croissance de la population v�g�tal dans un mois. En %.
	 */
    public double tauxCroissanceVegetale;


    /**
     * Taux de perte de v�g�tal par p�nurie en eau maximale. En %.
     */
    public double tauxPerteVegetaleParPenurieEauMax;


    /**
     * Population v�g�tale minimale dans un territoire. En tonne.
     */
    public double populationVegetaleMinimale;
    
    /**
     * Population v�g�tale maximale dans un territoire. En tonne.
     * 1000 fois la quantit� minimale.
     * @return Population v�g�tale maximale en tonne.
     */
    public double populationVegetaleMaximale() {
    	return 1000 * populationVegetaleMinimale;
    };
}
