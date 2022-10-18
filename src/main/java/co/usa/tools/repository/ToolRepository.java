package co.usa.tools.repository;

import co.usa.tools.model.Tool;
import co.usa.tools.repository.crud.ToolCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mike
 */
@Repository
public class ToolRepository {
    
    @Autowired
    private ToolCrudRepository toolCrudRepository;
    
    public List<Tool> getAll(){
        return (List<Tool>) toolCrudRepository.findAll();
    }
    
    public Optional<Tool> getTool(int id){
        return toolCrudRepository.findById(id);
    }
    
    public Tool save(Tool t){
        return toolCrudRepository.save(t);
    }
    
    public void delete(Tool t){
        toolCrudRepository.delete(t);
    }
}
