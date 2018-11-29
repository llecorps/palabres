package org.lle.palabres;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.example.palabres.business.contract.ManagerFactory;
import org.example.palabres.model.bean.chat.Channel;
import org.example.palabres.model.bean.chat.Message;
import org.example.palabres.model.exception.FunctionalException;
import org.example.palabres.model.exception.NotFoundException;
import org.example.palabres.model.exception.TechnicalException;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by TheAdmin on 11.11.2018.
 */
public class GestionChannelAction extends ActionSupport implements SessionAware {

    @Inject
    private ManagerFactory managerFactory;

    private List<Channel> listChannel;
    public Channel channel;
    //private String channelName;
    private List<Message> listMessage;
    public Message pMessage;

    private Map<String, Object> session;
/*
    public String getChannelName() {
        return channelName;
    }
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
*/
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

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }


    public String doList() {

        String vRetour = ActionSupport.INPUT;
/*
       if (this.session.get("utilisateur") == null) {
            vRetour = "error-forbidden";
        } else
*/
           // if (StringUtils.isNotEmpty(this.channel.getName())) {
if(this.channel != null) {
            try {
                channel = managerFactory.getChatManager().getChannel(this.channel.getName());
            } catch (NotFoundException pE) {
                this.addActionError(pE.getMessage());
            }
            vRetour = ActionSupport.SUCCESS;
        } else {
            listChannel = managerFactory.getChatManager().getListChannel();

       }
        return vRetour;

    }

    public String doListMessage() throws TechnicalException {

        String vRetour = ActionSupport.ERROR;
       // if (this.session.get("utilisateur") == null) {
         //   vRetour = "error-forbidden";
        //} else
          //  if (StringUtils.isNotEmpty(channel.getName())) {
                if (this.channel != null) {
            try {
              //  channel = managerFactory.getChatManager().getChannel(channelName);
                listMessage = managerFactory.getChatManager().getListNewMessage(channel, null);
                vRetour = ActionSupport.SUCCESS;
            } catch (NotFoundException pE) {
                this.addActionError(pE.getMessage());
            }
        } else {
            this.addActionError("Channel non précisé !");
        }
        return vRetour;
    }

    public String doCreate() {

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        if (this.channel != null) {

            try {

                managerFactory.getChatManager().addChannel(channel);
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
