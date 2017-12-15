package main.simulation.ecosystemeBambiBase.entites;

import main.simulation.ecosystemeBambiBase.entitesData.DataPopulation;


/**
 * Classe abstraite d'une population g�n�rique.
 * Contient les attribus et m�thodes en commun aux 2 types de population (v�g�tale ou animale).
 * 
 * @author Jo�o Paulo
 */
public abstract class Population {
	
	/**
	 * Data de population. 
	 * Les infos qui ne sont pas en fonction directe d'autres valeurs.
	 */
    protected DataPopulation dataPopulation;
    
    /**
     * Objet de localisation.
     * Encapsule les infos r�f�rentes au territoire occup�.
     * Les sousclasses font r�f�rence au m�me objet mais avec les variables sp�cifiques.
     */
    protected Localisation localisation;
    
    /**
     * R�f�rence de temps de la simulation.
     */
    protected Mois mois;
    

    /**
     * Constructeur.
     * 
     * @param dataPopulation Data de population.
     * @param mois Objet de mois (r�f de temps).
     */
    public Population(DataPopulation dataPopulation, Mois mois) {
    	// data
        this.dataPopulation = dataPopulation;
        
        // mois
        this.mois = mois;
    }
    
    
    /**
     * M�thode qui prend un objet de localisation.
     * Elle ne peut �tre appell�e que si l'objet de localisation n'est pas sett�e.
     * 
     * @param localisation L'objet de localisation.
     * @throws Exception Exception lanc�e en cas d'appel si la localisation est d�j� sett�e.
     */
    public void setLocalisation(Localisation localisation) throws Exception {
    	
    	// v�rifie s'il y a un objet d�j� accept�
    	if (this.localisation != null)
    		// lance exception
    		throw new Exception("Localisation already set.");
    	
    	// sinon
    	else
    		// affecte la variable
    		this.localisation = localisation;
    }
    
    
    /**
     * Quantit� d'individus dans la population.
     * 
     * @return Quantit� d'individus de la data.
     */
    public double quantiteIndividus() {
        return this.dataPopulation.quantiteIndividus;
    }

    /**
     * Besoin d'eau de la population.
     * 
     * @return Produit entre le besoin par individu et nombre d'individu.
     */
    public double besoinEauPopulation() {
        return this.dataPopulation.besoinEauParIndividu * this.dataPopulation.quantiteIndividus;
    }

    /**
     * Besoin de v�g�tal de la population.
     * 
     * @return Produit entre le besoin par individu et nombre d'individu.
     */
    public double besoinVegetalPopulation() {
        return this.dataPopulation.besoinVegetalParIndividu * this.dataPopulation.quantiteIndividus;
    }

    /**
     * R�cup�re l'index du territoire occup�.
     * 
     * @return L'index trouv� dans la localisation.
     */
    public Integer indexTerritoireOccuppe() {
        return this.localisation.indexTerritoire();
    }

    /**
     * M�thode abstraite de calcul de quantit� d'individus du mois prochain.
     * Chaque type de population doit avoir sa propre loi.
     * Cette m�thode n'affecte pas directement la quantit� d'individus parce que 
     * ceci pourrait changer le r�sultat d'un autre calcul. En effet, le r�sultat 
     * est sauvegard� dans la data pour �tre affect� ult�ri�rement.
     */
    public abstract void calculerNouvelleQuantiteIndividus();

    /**
     * Affecte la quantit� d'individus du mois prochain dans la qtt� actuelle.	
     */
    public void affecterQuantiteIndividus() {
    	// copie
        this.dataPopulation.quantiteIndividus = this.dataPopulation.quantiteIndividusMoisProchain;
    }

}
