package main.simulation.ecosystemeBambiBase.entitesData;

import java.util.*;

import main.simulation.ecosystemeBambiBase.enums.StatusMigrationEnum;

/**
 * Sp�cification de la data de population pour les animaux (sousclasse de DataPopulation).
 * 
 * Quantite individu : UP = nombre d'individu
 * Besoin eau par individu : Litre / individu / mois
 * Besoin vegetal par individu : kg / individu / mois
 * 
 * @author Jo�o Paulo
 */
public class DataPopulationAnimale extends DataPopulation {
	
	/**
	 * Taux de mortalit� par pr�dateur.
	 */
    public double tauxMortalitePredateur;
    

    /**
     * Taux de mortalit� par p�nurie alimentaire maximale.
     */
    public double tauxMortaliteParPenurieAlimentaireMax;

    
    /**
     * Taux de naissance maximale d'une population animale pendant un mois.
     */
    public double tauxNaissanceMax;

    
    /**
     * Historique de p�nurie en nourriture. Liste de %.
     */
    public List<Double> historiquePenurieEau = new ArrayList<>();

    
    /**
     * Historique de p�nurie en nourriture. Liste de %.
     */
    public List<Double> historiquePenurieNourriture = new ArrayList<>();
    
    /**
     * Status de migration des animaux.
     */
    public StatusMigrationEnum statusMigration;

}
