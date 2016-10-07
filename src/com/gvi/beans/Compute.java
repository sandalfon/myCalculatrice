package com.gvi.beans;



public class Compute {
	private double numberRight;
	private double numberLeft;
	private String action;
	private double result;

	public Compute (String numberLeft, String action, String numberRight){

		this.action=action;
		this.result=Double.NaN;
		this.numberLeft=Double.NaN;
		this.numberRight=Double.NaN;
		//Vérification de la partie gauche du signe non vide 
		if(numberLeft != null && !numberLeft.isEmpty()) { 
			//cast du string renvoyé par le getParameters en double
			this.numberLeft =Double.parseDouble(numberLeft);
		}
		//Vérification de la partie droite  du signe non vide
		if(numberRight != null && !numberRight.isEmpty()) { 
			//cast du string renvoyé par le getParameters en double
			this.numberRight =Double.parseDouble(numberRight);
		}
		this.execCompute();
	}

	//effectuer le calcul
	private void execCompute() {
		if(! Double.isNaN(this.numberLeft) & ! Double.isNaN(this.numberRight)){
			//Gestion des cas des différents opérateurs
			switch(this.action){
			case "add":
				this.result=this.numberLeft+this.numberRight;
				break;
			case "sub":
				this.result=this.numberLeft-this.numberRight;
				break;
			case "times":
				this.result=this.numberLeft*this.numberRight;
				break;
			case "div":
				//Vérification de la division par 0
				if( this.numberRight!=0){
					this.result=this.numberLeft/this.numberRight;
				}
				break;
			case "mod":
				//Vérification de la division par 0
				if(this.numberRight!=0){
					this.result=this.numberLeft%this.numberRight;
				}
				break;
			default:
				this.result =Double.NaN;
			}
		}
	}

	//Génèrer la phrase de sortie
	public String toString() {
		//vérification de la conformité des nombres gauche et droit
		if( Double.isNaN(this.numberLeft)){
			return "Nombre de gauche manquant";
		}
		if( Double.isNaN(this.numberRight)){
			return "Nombre de droite manquant";
		}
		//Gestion des cas des différents opérateurs
		switch(this.action){
		case "add":
			return "Résultat de : " +  this.numberLeft + " + " + this.numberRight + " = "+this.result;
		case "sub":
			return "Résultat de : " +  this.numberLeft + " - " + this.numberRight + " = "+this.result;
		case "times":
			return "Résultat de : " +  this.numberLeft + " * " + this.numberRight + " = "+this.result;
		case "div":
			//Vérification de la division par 0
			if(this.numberRight==0){
				return "Impossible de diviser par zéro";
			}else{
				return "Résultat de : " +  this.numberLeft + " / " + this.numberRight + " = "+this.result;
			}
		case "mod":
			//Vérification de la division par 0
			if(this.numberRight==0){
				return "Impossible de diviser par zéro";
			}else{
				return "Résultat de : " + this.numberLeft + " modulo " + this.numberRight + " la partie entière est "+this.result;
			}
		default:
			return " Erreur opérateur inconnu";
		}

	}

	//renvoie la valeur numérique 
	public double getResults(){
		return(this.result);
	}
	//renvoie la valeur sous forme de text 

}
