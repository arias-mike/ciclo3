package co.usa.tools.service;

import ch.qos.logback.core.util.OptionHelper;
import co.usa.tools.model.Tool;
import co.usa.tools.repository.ToolRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mike
 */
@Service
public class ToolService {
    
    @Autowired
    private ToolRepository toolRepository;
    
    public List<Tool> getAll(){
        return toolRepository.getAll();
    }
    
    public Optional<Tool> getTool(int id){
        return toolRepository.getTool(id);
    }
    
    public Tool save(Tool t){
        if(t.getId()==null){
            return toolRepository.save(t);
        } else {
            Optional<Tool> taux=toolRepository.getTool(t.getId());
            if(taux.isEmpty()){
                return toolRepository.save(t);
            } else {
                return t;
            }
        }
    }
    
    public Tool update(Tool t){
        if(t.getId() != null){
            Optional<Tool> taux = toolRepository.getTool(t.getId());
            if(!taux.isEmpty()){
                if(t.getName() != null){
                    taux.get().setName(t.getName());
                }
                if(t.getBrand() != null){
                    taux.get().setBrand(t.getBrand());
                }
                if(t.getYear() != null){
                    taux.get().setYear(t.getYear());
                }
                if(t.getDescription() != null){
                    taux.get().setDescription(t.getDescription());
                }
                if(t.getCategory() != null){
                    taux.get().setCategory(t.getCategory());
                }
                toolRepository.save(taux.get());
                return taux.get();
            } else {
                return t;
            }
        }else{
            return t;
        }
    }
    
    public boolean delete(int id){
        Boolean respuesta = getTool(id).map(t ->{
            toolRepository.delete(t);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
