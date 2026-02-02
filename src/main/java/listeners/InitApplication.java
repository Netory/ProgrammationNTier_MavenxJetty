package listeners;

import facade.FacadeParis;
import facade.FacadeParisStaticImpl;
import facade.exceptions.InformationsSaisiesIncoherentesException;
import facade.exceptions.UtilisateurDejaConnecteException;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import modele.Utilisateur;

@WebListener
public class InitApplication implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent
                                           servletContextEvent) {

        FacadeParis facadeParis = new FacadeParisStaticImpl();
        servletContextEvent.getServletContext().setAttribute("facade",facadeParis);

        /*try {
            facadeParis.connexion("yo","yo");
        } catch (UtilisateurDejaConnecteException | InformationsSaisiesIncoherentesException e) {
            throw new RuntimeException(e);
        }*/ //ça connecte automatique l'utilisateur (ça pose pb)
    }


    @Override
    public void contextDestroyed(ServletContextEvent
                                         servletContextEvent) {
    }
}