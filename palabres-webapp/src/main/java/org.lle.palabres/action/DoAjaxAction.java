package org.lle.palabres.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.palabres.business.contract.ManagerFactory;
import org.example.palabres.model.bean.chat.Channel;
import org.example.palabres.model.bean.chat.Message;
import org.example.palabres.model.bean.utilisateur.Utilisateur;
import org.example.palabres.model.exception.FunctionalException;
import org.example.palabres.model.exception.NotFoundException;
import org.example.palabres.model.exception.TechnicalException;

import javax.inject.Inject;
import java.util.List;


public class DoAjaxAction extends ActionSupport {

    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;

    private Message message;
    private List<Channel> listChannel;
    public Channel channel;
    private List<Message> listMessage;

    public List<Message> getListMessage() {
        return listMessage;
    }

    public void setListMessage(List<Message> listMessage) {
        this.listMessage = listMessage;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public List<Channel> getListChannel() {
        return listChannel;
    }

    public void setListChannel(List<Channel> listChannel) {
        this.listChannel = listChannel;
    }


    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    // ==================== Méthodes ====================

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }


    private String pseudo;
    private String texte;




    // ==================== Méthodes ====================
    public String execute() throws NotFoundException, TechnicalException, FunctionalException {
        listMessage = managerFactory.getChatManager().getListNewMessage(channel, null);
        return ActionSupport.SUCCESS;
    }




    public String doAjaxGetListMessage() throws NotFoundException, TechnicalException, FunctionalException {

        if (channel == null) {
            addActionError("Channel non précisé !");
        } else {




            listMessage = managerFactory.getChatManager().getListNewMessage(channel, null);


        }
            return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
        }

    public void  doAjaxAddMessage() throws FunctionalException, NotFoundException, TechnicalException{

        //if ((channel == null) || (message == null)) {

            if (channel == null)  {

            addActionError("Message non posté  !");

        } else {

                Utilisateur vUtilisateur = new Utilisateur();

                vUtilisateur.setPseudo(pseudo);

                Message vMessage = new Message();

                vMessage.setAuthor(vUtilisateur);
                vMessage.setMessage(texte);


                managerFactory.getChatManager().addMessage(channel, vMessage);
        }


        }

    }