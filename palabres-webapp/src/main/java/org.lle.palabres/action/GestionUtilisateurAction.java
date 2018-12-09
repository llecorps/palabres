package org.lle.palabres.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.palabres.business.contract.ManagerFactory;
import org.example.palabres.model.bean.utilisateur.Utilisateur;
import org.example.palabres.model.exception.FunctionalException;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by TheAdmin on 11.11.2018.
 */
public class GestionUtilisateurAction extends ActionSupport {

    // ----- Eléments en sortie

    @Inject
    private ManagerFactory managerFactory;

    private List<Utilisateur> listUtilisateur;

    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }

    public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
        this.listUtilisateur = listUtilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    private Utilisateur utilisateur;



    public String doCreate() {

        String vResult = ActionSupport.INPUT;

        if (this.utilisateur != null) {


            try {

                managerFactory.getUtilisateurManager().addUtilisateur(this.utilisateur);
                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("Utilisateur ajouté avec succès");
            } catch (FunctionalException e) {
                e.printStackTrace();
                vResult = ActionSupport.ERROR;
            }

        }
        return vResult;
        }
}
