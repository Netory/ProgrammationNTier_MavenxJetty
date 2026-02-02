package controleur;


import facade.FacadeParis;
import facade.exceptions.InformationsSaisiesIncoherentesException;
import facade.exceptions.UtilisateurDejaConnecteException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Utilisateur;

import java.io.IOException;

@WebServlet(name="controleur",urlPatterns = "/pel/*")
public class Controleur extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException{
        String[] url = req.getRequestURI().split("/");
        String clefNavigation=url[url.length-1];
        String destination ="/WEB-INF/welcome.jsp";

        switch (clefNavigation){
            case "home":
                break;
            case "menu":
                destination="/WEB-INF/menu.jsp";
                break;


        }
        req.getServletContext()
                .getRequestDispatcher(destination)
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] url = req.getRequestURI().split("/");
        String clefNavigation=url[url.length-1];
        String destination ="/WEB-INF/welcome.jsp";


        FacadeParis facadeParis = (FacadeParis)this.getServletContext().getAttribute("facade");

        switch (clefNavigation){
            case "home":

                break;
            case "menu":
                String login=req.getParameter("login");
                String password=req.getParameter("password");
                try {
                    Utilisateur utilisateur = facadeParis.connexion(login, password);
                    req.getSession().setAttribute("utilsateur",utilisateur);
                    destination="/WEB-INF/menu.jsp";
                } catch (UtilisateurDejaConnecteException | InformationsSaisiesIncoherentesException e) {
                    throw new RuntimeException(e); //gestion des erreurs plus tard
                }

                break;


        }
        req.getServletContext()
                .getRequestDispatcher(destination)
                .forward(req,resp);
    }

}


