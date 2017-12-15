package main.simulation.ecosystemeBambiBase.entites;

/**
 * Objet de localisation g�n�rique.
 * 
 * Cette classe permet les populations d'acceder des informations concernant 
 * le territoire occup� sans l'acceder directement.
 * 
 * Comme cette classe est basiquement un wrapper de quelques informations de territoire,
 * elle n'a pas de teste unitaire.
 * 
 * @author Jo�o Paulo
 */
public class Localisation {
    
	/**
     * Territoire point� par la localisation.
     */
	protected Territoire territoire;
    
	
	/**
	 * Constructeur. Prend r�f�rence au territoire auquel il doit pointer.
	 * @param territoire Territoire point� par la localisation.
	 */
    public Localisation(Territoire territoire) {
        this.territoire = territoire;
    }
    
    
    /**
     * R�cup�re l'index du territoire point�.
     * @return Index trouv� dans le territoire.
     */
    public int indexTerritoire() {
        return this.territoire.index();
    }
    
    
    /**
     * Balance d'eau du mois actuel, c-a-d la diff�rence entre la disponibilit� et le besoin.
     * @return Balance d'eau en Litre.
     */
    public double balanceEau() {
        return this.territoire.balanceEau();
    }
    
    
    /**
     * Penurie en eau r�cup�r�e dans le territoire.
     * @return P�nurie en eau  en %.
     */
    public double penurieEau() {
        return this.territoire.penurieEau();
    }

}
