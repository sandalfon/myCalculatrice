package com.gvi.calculatrice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gvi.beans.Compute;

/**
 * Servlet implementation class Calculatrice
 */
@WebServlet("/Calculatrice")
public class Calculatrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String calculatriceView = "/WEB-INF/calculatrice.jsp";
    /**
     * Default constructor. 
     */
    public Calculatrice() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(calculatriceView).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//récupération des varaibles
		String numberLeftStr = request.getParameter("numberLeft");
		String numberRightStr = request.getParameter("numberRight");
		String action =request.getParameter("action");
		//Calcul des valeurs
		Compute compute = new Compute(numberLeftStr, action, numberRightStr);
		//assignation des variables
		request.setAttribute("numberRight", numberRightStr);
		request.setAttribute("numberLeft", numberLeftStr);
		request.setAttribute("action", action);
		//La phrase à afficher est directement générée par la classe Compute
		request.setAttribute("resultStr", compute.toString());
		this.getServletContext().getRequestDispatcher(calculatriceView).forward(request, response);
	}

}
