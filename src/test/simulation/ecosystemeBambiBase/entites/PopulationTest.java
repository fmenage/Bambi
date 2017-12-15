package test.simulation.ecosystemeBambiBase.entites;

import static org.junit.Assert.*; 	

import org.junit.Before;
import org.junit.Test;

import main.domain.MoisEnum;
import main.simulation.ecosystemeBambiBase.entites.*;
import main.simulation.ecosystemeBambiBase.entitesData.*;


/******************************** CODE DES TESTES *******************************************/ 

/**
 * Classe de teste de Population.
 * Comme cette classe est abstraite, une classe concr�te vide a �t� impl�ment�e
 * pour pouvoir la tester tel qu'elle est.
 * 
 * @author Jo�o Paulo
 */
public class PopulationTest {

	/******************** ATTRIBUS AUXILIAIRES ********************/
	
    /** 
     * valeurs : attendue, r�ele, tol�rance de diff�rence
     */
    double expected, actual, delta = 0.001;
    
	/**
	 * Objete de data de population.
	 */
	private DataPopulation dataPopulation;
	
	/**
	 * Controleur de mois.
	 */
	private ControleurMois ctrl;
	
	/**
	 * Objet de population.
	 */
	private PopulationVide population;
	
	
	/**
	 * M�thode d'initialisation des valeurs de teste.
	 * 		besoinEauParIndividu          = 180
	 * 		besoinVegetalParIndividu      = 150
	 * 		quantiteIndividus             = 100
	 * 		quantiteIndividusMoisProchain = 0
	 * 		
	 * 		mois0 = Janvier
	 * 		
	 * @throws Exception (m�thode de set localisation).
	 */
	@Before
	public void setUp() throws Exception {
		// controleur de mois]
		ctrl = new ControleurMois(MoisEnum.Janvier);
		
		// data population
		dataPopulation = new DataPopulation();
		dataPopulation.besoinEauParIndividu     = 180;  // 6 * 30
		dataPopulation.besoinVegetalParIndividu = 150;  // 5 * 30
		dataPopulation.quantiteIndividus        = 100;  
		dataPopulation.quantiteIndividusMoisProchain = 0;
		
		// population
		population = new PopulationVide(dataPopulation, ctrl);
	}
	
	
	/**
	 * Teste la m�thode de calcul de b�soin d'eau.
	 */
	@Test
	public void testBesoinEauPopulation() {
		// expected
		expected = 180.0 * 100.0;
		
		// r�cup�re la valeur de la population
		actual = population.besoinEauPopulation();
		
		// comparaison
		assertEquals(expected, actual, delta);
	}
	
	
	/**
	 * Teste la m�thode de calcul de b�soin de v�g�tal.
	 */
	@Test
	public void testBesoinVegetalPopulation() {
		// expected
		expected = 150.0 * 100.0;
		
		// r�cup�re la valeur de la population
		actual = population.besoinVegetalPopulation();
		
		// comparaison
		assertEquals(expected, actual, delta);
	}
	
	
	/**
	 * Teste l'affectation de la quantit� d'invidus.
	 */
	@Test
	public void testProchainePopulation0() {
		// expected
		expected = 100;
		
		// r�cup�re la valeur de la population
		actual = population.quantiteIndividus();
		
		// comparaison
		assertEquals((int)expected, (int)actual);
		
		// affectation
		population.affecterQuantiteIndividus();

		// expected
		expected = 0;
		
		// r�cup�re la valeur de la population
		actual = population.quantiteIndividus();
		
		// comparaison
		assertEquals((int)expected, (int)actual);
	}

}


/******************************** CODE AUXILIAIRE *******************************************/ 

/**
 * Classe vide qui impl�mente la clases abstraite pour la tester.
 * @author Jo�o Paulo
 */
class PopulationVide extends Population {

	/**
	 * Constructeur qui appelle celui de Population.
	 */
	public PopulationVide(DataPopulation dataPopulation, Mois mois) {
		super(dataPopulation, mois);
	}

	/**
	 * Fonction qui ne fait rien du tout.
	 */
	@Override
	public void calculerNouvelleQuantiteIndividus() {
	}
}
