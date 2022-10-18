package co.usa.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Mike
 */
@Entity
@Table(
    name = "message" 
)
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,  generator = "MessageTable")
    private Integer idMessage;
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name = "tool")
    @JsonIgnoreProperties({"messages","reservations","client"})
    private Tool tool;
    
    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


}
