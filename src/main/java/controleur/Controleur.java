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
import java.util.Collection;

@WebServlet(name="controleur",urlPatterns = "/pel/*")
public class Controleur extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException{
        String[] url = req.getRequestURI().split("/");
        String clefNavigation=url[url.length-1];
        String destination ="/WEB-INF/welcome.jsp";
        FacadeParis facadeParis = (FacadeParis)this.getServletContext().getAttribute("facade");
        String login=req.getParameter("login");
        Utilisateur utilisateur= (Utilisateur) req.getSession().getAttribute("utilisateur");
        switch (clefNavigation){
            case "home":
                break;
            case "menu":
                destination="/WEB-INF/menu.jsp";
                break;
            case "deconnexion":
                facadeParis.deconnexion(utilisateur.getLogin());
                destination="/WEB-INF/welcome.jsp";
                break;
            case "listesParis":
                req.setAttribute("lesMatchs",facadeParis.getMatchsPasCommences());
                destination="/WEB-INF/listesParis.jsp";
                break;
            case "mesparis":
                req.setAttribute("mesParis",facadeParis.getMesParis(login));
                destination="/WEB-INF/mesparis.jsp";
                break;

            case "validerParis":
                Long idmatch1= Long.valueOf(req.getParameter("idmatch"));
                req.setAttribute("match",facadeParis.getMatch(idmatch1));
                destination="/WEB-INF/validerParis";
                break;
            case "parier":
                Long idmatch= Long.valueOf(req.getParameter("idmatch"));
                req.setAttribute("match",facadeParis.getMatch(idmatch));
                destination="/WEB-INF/parier.jsp";
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
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        switch (clefNavigation){
            case "menu":
                try {
                    Utilisateur utilisateur = facadeParis.connexion(login, password);
                    req.getSession().setAttribute("utilisateur",utilisateur);
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


