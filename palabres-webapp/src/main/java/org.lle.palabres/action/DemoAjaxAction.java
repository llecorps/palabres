package org.lle.palabres.action;



import com.opensymphony.xwork2.ActionSupport;
import org.example.palabres.business.contract.ManagerFactory;
import org.example.palabres.model.bean.chat.Channel;
import org.example.palabres.model.bean.chat.Message;
import org.example.palabres.model.exception.NotFoundException;
import org.example.palabres.model.exception.TechnicalException;

import javax.inject.Inject;
import java.util.List;

/**
 * Action de démo pour les appels AJAX
 */
public class DemoAjaxAction extends ActionSupport {

    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;

    public Channel channel;

    // ----- Eléments en sortie
    private List<Channel> listChannel;
    private List<Message> listMessage;

    // ==================== Getters/Setters ====================
    public List<Channel> getListChannel() {
        return listChannel;
    }


    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public List<Message> getListMessage() {
        return listMessage;
    }

    public void setListMessage(List<Message> listMessage) {
        this.listMessage = listMessage;
    }
    // ==================== Méthodes ====================
    public String execute() {
        listChannel = managerFactory.getChatManager().getListChannel();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action "AJAX" renvoyant la liste des projets
     * @return success
     */
    public String doAjaxGetListMessage() throws NotFoundException, TechnicalException {
        if (channel == null) {
            addActionError("Channel non précisé !");
        } else {

            listMessage = managerFactory.getChatManager().getListNewMessage(channel, null);
        }
        return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
 }
