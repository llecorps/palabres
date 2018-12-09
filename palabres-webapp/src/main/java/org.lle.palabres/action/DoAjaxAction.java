package org.lle.palabres.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.palabres.business.contract.ManagerFactory;
import org.example.palabres.model.bean.chat.Channel;
import org.example.palabres.model.bean.chat.Message;
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
    public String execute() {
        return ActionSupport.SUCCESS;
    }


    /**
     * Action "AJAX" renvoyant la liste des projets
     *
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