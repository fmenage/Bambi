package main.animation;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.*;
import java.awt.Font;
import java.awt.FontMetrics;

public class IhmUnTerritoire extends JPanel {
		
	private double eau;
	private double veg;
	
	private double maxEau;
	private double maxVeg;
	
	//attributs pour les dimensions des jauges
	int epaisseur =  3;
	int largeur = 25;
	int longueurMax = 300;
	int xVeg = 120;
	int yVeg = 50;
	int xEau = 120;
	int yEau = 100;
	
	private JLabel labLegendeEau;
	private JLabel labQEau;
	private JLabel labLegendeVeg;
	private JLabel labQVeg;
	
	private int popAnimale;
	
	public void setEauEtVegEtPop(final double eau, final double veg, final int popAnimale) {
		this.eau=eau;
		this.veg=veg;
		this.popAnimale=popAnimale;
		
		labQEau.setText(String.valueOf(eau));
		labQVeg.setText(String.valueOf(veg));
		repaint();

	}
	
	
	public IhmUnTerritoire(double maxEau, double maxVeg) {
		this.setLayout(null);
		this.maxEau = maxEau;
		this.maxVeg = maxVeg;
		
		labLegendeEau = new JLabel("Quantit� eau : ");
		this.add(labLegendeEau);
		
		labQEau = new JLabel();
		this.add(labQEau);
		labQEau.setLocation(500, 50);
		
		labLegendeVeg = new JLabel("Quantit�s v�g�taux : ");
		this.add(labLegendeVeg);
		
		labQVeg = new JLabel();
		this.add(labQVeg);		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		if(popAnimale!=0) {
			g.setColor(Color.red);
		}
		
		else g.setColor(Color.blue);
		
		//On trace le territoire
		g.fillRect(20, yVeg, 80, (yEau-yVeg) + 2*largeur);
		
		// On calcule la longueur des jauges
		int longueurEau = (int) ((eau/maxEau)*longueurMax);
		int longueurVeg = (int) ((veg/maxVeg)*longueurMax);
		
		//On dessine les jauges de v�g�taux
		g.setColor(Color.black);
		g.fillRect(xVeg-epaisseur,yVeg-epaisseur,longueurMax+2*epaisseur,2*epaisseur + largeur);
		g.setColor(Color.green);
		g.fillRect(xVeg, yVeg,longueurEau, largeur);		
		g.setColor(Color.black);
		g.fillRect(xEau-epaisseur,yEau-epaisseur,longueurMax+2*epaisseur,2*epaisseur + largeur);
		g.setColor(Color.blue);
		g.fillRect(xEau, yEau,longueurVeg, largeur);
		
		//On dessine le texte qui indique les quantit�s
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 12)); 
		g.drawString(String.valueOf(popAnimale), 60, 90);
		g.setColor(Color.white);
		g.drawString(String.valueOf(eau),xVeg + longueurMax-50, yEau+15);
		g.drawString(String.valueOf(veg),xVeg + longueurMax-50, yVeg+15);
		
	}
	
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(font);
	    // Determine the X coordinate for the text
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Set the font
	    g.setFont(font);
	    // Draw the String
	    g.drawString(text, x, y);
	}
}