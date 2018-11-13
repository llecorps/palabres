package org.lle.palabres;

import com.opensymphony.xwork2.ActionSupport;
import org.example.palabres.model.bean.chat.Channel;
import org.example.palabres.model.bean.chat.Message;
import org.example.palabres.model.exception.NotFoundException;
import org.example.palabres.model.exception.TechnicalException;
import org.example.palabres.webapp.WebappHelper;

import java.util.List;

/**
 * Created by TheAdmin on 11.11.2018.
 */
public class GestionChannelAction extends ActionSupport {


    private List<Channel> listChannel;
    public Channel pChannel;

    public List<Message> getListMessage() {
        return listMessage;
    }

    public void setListMessage(List<Message> listMessage) {
        this.listMessage = listMessage;
    }

    public Message getpMessage() {
        return pMessage;
    }

    public void setpMessage(Message pMessage) {
        this.pMessage = pMessage;
    }

    private List<Message> listMessage;
    public Message pMessage;

    public List<Channel> getListChannel() {
        return listChannel;
    }

    public void setListChannel(List<Channel> listChannel) {
        this.listChannel = listChannel;
    }



    public Channel getpChannel() {
        return pChannel;
    }

    public void setpChannel(Channel pChannel) {
        this.pChannel = pChannel;
    }





    public String doList() {

        listChannel = WebappHelper.getManagerFactory().getChatManager().getListChannel();
        return ActionSupport.SUCCESS;
    }

    public String doListMessage() {

        try {
            listMessage = WebappHelper.getManagerFactory().getChatManager().getListNewMessage(pChannel, 1);
            return ActionSupport.SUCCESS;
        } catch (NotFoundException e) {
            e.printStackTrace();
            return ActionSupport.ERROR;
        } catch (TechnicalException e) {
            e.printStackTrace();
            return ActionSupport.ERROR;
        }

    }




}
