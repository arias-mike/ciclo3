package co.usa.tools.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Mike
 */
@Entity
@Table(
    name = "score" 
)
public class Score implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,  generator = "ScoreTable")
    private Integer idScore;
    private String messageText;
    private Integer stars;

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
    
}
