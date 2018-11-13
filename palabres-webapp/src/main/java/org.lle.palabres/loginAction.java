package org.lle.palabres;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.example.palabres.model.bean.utilisateur.Utilisateur;
import org.example.palabres.model.exception.NotFoundException;
import org.example.palabres.webapp.WebappHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class loginAction extends ActionSupport implements ServletRequestAware, SessionAware {

    // ----- Eléments Struts
    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    private HttpServletRequest servletRequest;

    @Override
    public void setServletRequest(HttpServletRequest pRequest) {
        this.servletRequest = pRequest;
    }

    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private String login;

    // ==================== Getters/Setters ====================
    public String getLogin() {
        return login;
    }
    public void setLogin(String pLogin)  {
        login = pLogin;}

        // ==================== Méthodes ====================
        /**
         * Action permettant la connexion d'un utilisateur
         * @return input / success
         */
        public String doLogin() {
            String vResult = ActionSupport.INPUT;
            if (!StringUtils.isAllEmpty(login)) {

                Utilisateur vUtilisateur
                        = null;
                try {
                    vUtilisateur = WebappHelper.getManagerFactory().getUtilisateurManager()
                    .getUtilisateur(login);
                    if (vUtilisateur.getPseudo().equals(login))  {
                        // Ajout de l'utilisateur en session
                        this.session.put("utilisateur", vUtilisateur);
                        vResult = ActionSupport.SUCCESS;
                    }
                } catch (NotFoundException e) {
                    e.printStackTrace();
                   // this.addActionError("Identifiant ou mot de passe invalide !");
                    vResult = ActionSupport.ERROR;
                }



            }

            return vResult;
        }




        /**
         * Action de déconnexion d'un utilisateur
         * @return success
         */
        public String doLogout() {


            // Invalidation de la session
            this.servletRequest.getSession().invalidate();

            return ActionSupport.SUCCESS;
        }



    }
