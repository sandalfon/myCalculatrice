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
		//V�rification de la partie gauche du signe non vide 
		if(numberLeft != null && !numberLeft.isEmpty()) { 
			//cast du string renvoy� par le getParameters en double
			this.numberLeft =Double.parseDouble(numberLeft);
		}
		//V�rification de la partie droite  du signe non vide
		if(numberRight != null && !numberRight.isEmpty()) { 
			//cast du string renvoy� par le getParameters en double
			this.numberRight =Double.parseDouble(numberRight);
		}
		this.execCompute();
	}

	//effectuer le calcul
	private void execCompute() {
		if(! Double.isNaN(this.numberLeft) & ! Double.isNaN(this.numberRight)){
			//Gestion des cas des diff�rents op�rateurs
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
				//V�rification de la division par 0
				if( this.numberRight!=0){
					this.result=this.numberLeft/this.numberRight;
				}
				break;
			case "mod":
				//V�rification de la division par 0
				if(this.numberRight!=0){
					this.result=this.numberLeft%this.numberRight;
				}
				break;
			default:
				this.result =Double.NaN;
			}
		}
	}

	//G�n�rer la phrase de sortie
	public String toString() {
		//v�rification de la conformit� des nombres gauche et droit
		if( Double.isNaN(this.numberLeft)){
			return "Nombre de gauche manquant";
		}
		if( Double.isNaN(this.numberRight)){
			return "Nombre de droite manquant";
		}
		//Gestion des cas des diff�rents op�rateurs
		switch(this.action){
		case "add":
			return "R�sultat de : " +  this.numberLeft + " + " + this.numberRight + " = "+this.result;
		case "sub":
			return "R�sultat de : " +  this.numberLeft + " - " + this.numberRight + " = "+this.result;
		case "times":
			return "R�sultat de : " +  this.numberLeft + " * " + this.numberRight + " = "+this.result;
		case "div":
			//V�rification de la division par 0
			if(this.numberRight==0){
				return "Impossible de diviser par z�ro";
			}else{
				return "R�sultat de : " +  this.numberLeft + " / " + this.numberRight + " = "+this.result;
			}
		case "mod":
			//V�rification de la division par 0
			if(this.numberRight==0){
				return "Impossible de diviser par z�ro";
			}else{
				return "R�sultat de : " + this.numberLeft + " modulo " + this.numberRight + " la partie enti�re est "+this.result;
			}
		default:
			return " Erreur op�rateur inconnu";
		}

	}

	//renvoie la valeur num�rique 
	public double getResults(){
		return(this.result);
	}
	//renvoie la valeur sous forme de text 

}
