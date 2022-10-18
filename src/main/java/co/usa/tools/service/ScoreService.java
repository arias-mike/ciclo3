package co.usa.tools.service;

import co.usa.tools.model.Score;
import co.usa.tools.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mike
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    
    public Score save(Score s){
        if(s.getIdScore()==null){
            return scoreRepository.save(s);
        } else {
            Optional<Score> saux=scoreRepository.getScore(s.getIdScore());
            if(saux.isEmpty()){
                return scoreRepository.save(s);
            } else {
                return s;
            }
        }
    }
    
    public Score update(Score s){
        if(s.getIdScore()!= null){
            Optional<Score> saux = scoreRepository.getScore(s.getIdScore());
            if(!saux.isEmpty()){
                if(s.getMessageText()!= null){
                    saux.get().setMessageText(s.getMessageText());
                }
                if(s.getStars()!= null){
                    saux.get().setStars(s.getStars());
                }
                scoreRepository.save(saux.get());
                return saux.get();
            } else {
                return s;
            }
        }else{
            return s;
        }
    }
    
    public boolean delete(int id){
        Boolean repuesta = getScore(id).map(s ->{
            scoreRepository.delete(s);
            return true;
        }).orElse(false);
        return repuesta;
    }
}
