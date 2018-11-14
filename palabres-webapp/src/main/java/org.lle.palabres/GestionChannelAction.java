package org.lle.palabres;

import com.opensymphony.xwork2.ActionSupport;
import org.example.palabres.model.bean.chat.Channel;
import org.example.palabres.model.bean.chat.Message;
import org.example.palabres.model.exception.FunctionalException;
import org.example.palabres.model.exception.NotFoundException;
import org.example.palabres.model.exception.TechnicalException;
import org.example.palabres.webapp.WebappHelper;

import java.util.List;

/**
 * Created by TheAdmin on 11.11.2018.
 */
public class GestionChannelAction extends ActionSupport {


    private List<Channel> listChannel;
    public Channel channel;
    private String channelName;
    private List<Message> listMessage;
    public Message pMessage;

    public String getChannelName() {
        return channelName;
    }
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

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

    public List<Channel> getListChannel() {
        return listChannel;
    }
    public void setListChannel(List<Channel> listChannel) {
        this.listChannel = listChannel;
    }

    public Channel getChannel() {
        return channel;
    }
    public void setChannel(Channel channel) {
        this.channel = channel;
    }




    public String doList() {

        listChannel = WebappHelper.getManagerFactory().getChatManager().getListChannel();
        return ActionSupport.SUCCESS;
    }

    public String doListMessage() {

        Channel vChannel = new Channel();
        vChannel.setName(channelName);

        try {
            listMessage = WebappHelper.getManagerFactory().getChatManager().getListNewMessage(vChannel, null);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return ActionSupport.ERROR;
        } catch (TechnicalException e) {
            e.printStackTrace();
            return ActionSupport.ERROR;
        }

        return ActionSupport.SUCCESS;
    }

    public String doCreate() {

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        if (this.channel != null) {

            try {
                WebappHelper.getManagerFactory().getChatManager().addChannel(channel);
                vResult = ActionSupport.SUCCESS;
            } catch (FunctionalException e) {
                e.printStackTrace();
                vResult = ActionSupport.ERROR;
            } catch (TechnicalException e) {
                e.printStackTrace();
                vResult = ActionSupport.ERROR;
            }

        }

        return vResult;
    }


}
