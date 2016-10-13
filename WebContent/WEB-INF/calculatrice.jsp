<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!-- des id sont définis pour chaque élément en vu d'un potentiel css pour améliorer le viseul de la page -->
<html>
    <head>
        <meta charset="utf-8" />
        <title>Calculatrice</title>
    </head>
    <body>
    	<!-- affichage de la phrase réponse  -->
        <p>${ ! empty compute.toString() ? compute.toString()  : '' } </p>
        <!-- formulaire à remplir -->
        <form method="post" action="">
	        <input type="number" name="numberLeft" id="numberLeft">        
	        <select name="action" id="action">
	           <option value="add">+</option>
	           <option value="sub">-</option>
	           <option value="times">*</option>
	           <option value="div">/</option>
	           <option value="mod">%</option>
	       </select> 
	       <input type="number" name="numberRight" id = "numberRight"> 
	       <input type="submit" value=Calculer id="calculer">
        </form>
    </body>
</html>