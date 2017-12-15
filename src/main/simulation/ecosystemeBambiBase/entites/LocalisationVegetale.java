package main.simulation.ecosystemeBambiBase.entites;

/**
 * Objet de localisation v�g�tale.
 * Sousclasse de Localisation avec des particularit�s pour les v�g�taux.
 * 
 * Cette classe permet les populations d'acceder des informations concernant 
 * le territoire occup� sans l'acceder directement.
 * 
 * Comme cette classe est basiquement un wrapper de quelques informations de territoire
 * elle n'a pas de teste unitaire.
 * 
 * @author Jo�o Paulo
 */
public class LocalisationVegetale extends Localisation {
	
	/**
	 * Constructeur.
	 * Appelle le constructeur de Localisation.
	 * @param territoire Le territoire point� par la localisation.
	 */
	public LocalisationVegetale(Territoire territoire) {
		super(territoire);
	}

    /**
     * Quantit� de v�g�tal non mang� pendant le mois actuel.
     * @return Quantit� de v�g�tal non mang� en kg.
     */
    public double quantiteVegetalNonMange() {
        return this.territoire.quantiteVegetalNonMange();
    }

}
