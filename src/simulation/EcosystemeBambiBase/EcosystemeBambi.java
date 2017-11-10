package simulation.ecosystemeBambiBase;

import java.util.ArrayList;
import java.util.List;
import domain.ParametrageSimulation;
import simulation.ecosystemeBambiBase.entites.ControleurMois;
import simulation.ecosystemeBambiBase.entites.LocalisationAnimale;
import simulation.ecosystemeBambiBase.entites.PopulationAnimale;
import simulation.ecosystemeBambiBase.entites.PopulationVegetale;
import simulation.ecosystemeBambiBase.entites.Territoire;
import simulation.ecosystemeBambiBase.entitesData.DataPopulationAnimale;
import simulation.ecosystemeBambiBase.entitesData.DataPopulationVegetale;
import simulation.ecosystemeBambiBase.entitesData.DataTerritoire;
import simulation.ecosystemeBambiBase.enums.StatusMigrationEnum;
import simulation.gestionDeSimulation.Ecosysteme;

public final class EcosystemeBambi extends Ecosysteme {
    private TableauxVariablesSimulation tableauxVariablesSimulation;

    private ControleurMois controleurMois;

    private List<Territoire> territoires = new ArrayList<Territoire>();

    private PopulationAnimale bambis;

    public EcosystemeBambi(ParametrageSimulation parametrageSimulation) {
    	super(parametrageSimulation);
    	
    	this.tableauxVariablesSimulation = new TableauxVariablesSimulation(5);
    	
    	super.resultatSimulation = tableauxVariablesSimulation;
    	
    	this.controleurMois = new ControleurMois(parametrageSimulation.mois0());
    	
    	this.territoires = new ArrayList<Territoire>();
    	for (int i = 0; i < 5; i++) {
    		
    		// Data Vegetation
    		DataPopulationVegetale dataveg = new DataPopulationVegetale();
    		dataveg.besoinEauParIndividu              = parametrageSimulation.besoinEauVegetal();
    		dataveg.besoinVegetalParIndividu          = 0;  // vegetal ne mange pas vegetal
    		dataveg.populationVegetaleMinimale        = parametrageSimulation.stockVegetauxMinimal();
    		dataveg.quantiteIndividus                 = parametrageSimulation.stockVegetaux(i);
    		dataveg.tauxCroissanceVegetale            = parametrageSimulation.tauxCroissanteVegetal();
    		dataveg.tauxPerteVegetaleParPenurieEauMax = parametrageSimulation.tauxPerteVegetalPenurieMax();
    		
    		// Vegetation
    		PopulationVegetale veg = new PopulationVegetale(dataveg, this.controleurMois);
    		
    		// DataTerritoire
    		DataTerritoire dataterr = new DataTerritoire();
    		dataterr.index                   = i;
    		dataterr.cumulEau                = parametrageSimulation.stockEau(i);
    		dataterr.pluviometrie            = parametrageSimulation.pluviometrie(i, 0);
    		dataterr.surface                 = parametrageSimulation.surfaceTerritoire(i);
    		dataterr.tauxPerteEauEvaporation = parametrageSimulation.tauxPerteEauEvaporation(i);
    		
    		// Territoire
    		Territoire t = i == 0 ? 
    				Territoire.CreerTerritoire(dataterr, veg) :
    				Territoire.CreerTerritoireAuNord(this.territoires.get(i-1), dataterr, veg);
    				
			this.territoires.add(t);
			
			
    	}
    	
    	// Data Bambis
    	DataPopulationAnimale databambis = new DataPopulationAnimale();
    	databambis.besoinEauParIndividu                  = parametrageSimulation.besoinEauAnimal();
    	databambis.besoinVegetalParIndividu              = parametrageSimulation.besoinVegetalAnimal();
    	databambis.quantiteIndividus                     = parametrageSimulation.nombreIndividusAnimale0();
    	databambis.statusMigration                       = StatusMigrationEnum.Fixe;
    	databambis.tauxMortaliteParPenurieAlimentaireMax = parametrageSimulation.tauxMortaliteParPenurieAlimentaireMaximal();
    	databambis.tauxMortalitePredateur                = parametrageSimulation.tauxMortalitePredateur();
    	databambis.tauxNaissanceMax                      = parametrageSimulation.tauxNaissanceAnimalMaximal();
    	
    	// Localisation des bambis
    	int t0 = parametrageSimulation.localisationInitiale();
    	LocalisationAnimale local = new LocalisationAnimale(this.territoires.get(t0));
    	
    	// Bambis
    	this.bambis = new PopulationAnimale(databambis, local, this.controleurMois);
    	
    }

    public void PrendreUnePhotoDeLaSimulation() {
    	for (int i = 0; i < 5; i++) {
    		Territoire territ = this.territoires.get(i);
    		
    		int population = 
    				this.bambis.indexTerritoireOccuppe() == territ.index() ?
    				(int) this.bambis.quantiteIndividus() : 0;

    		double stockEau = territ.disponibiliteEau();
    		
    		double stockVeg = territ.disponibiliteVegetal();
    				
        	this.tableauxVariablesSimulation.ajouterPopAnimale(i, population);
        	this.tableauxVariablesSimulation.ajouterStockEau  (i, stockEau);
        	this.tableauxVariablesSimulation.ajouterStockVeg  (i, stockVeg);
    	}
    }

    protected final void ChangerSysteme() {
    	for (Territoire territ : this.territoires) {
    		territ.recalculerCumulEau();
    		territ.recalculerPopulations();
    	}
    	
    	bambis.migrer();
    	
    	for (Territoire territ : this.territoires) {
    		territ.affecterCumulEau();
    		territ.affecterPopulations();
    	}
    	
    	this.controleurMois.incrementer();
    }

}
