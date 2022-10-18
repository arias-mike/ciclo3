package co.usa.tools.repository;

import co.usa.tools.model.Score;
import co.usa.tools.repository.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mike
 */
@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    
    public Score save(Score s){
        return scoreCrudRepository.save(s);
    }
    
    public void delete(Score s){
        scoreCrudRepository.delete(s);
    }
}
