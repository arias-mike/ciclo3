package co.usa.tools.service;

import co.usa.tools.model.Category;
import co.usa.tools.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mike
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category c){
        if(c.getId()==null){
            return categoryRepository.save(c);
        } else {
            Optional<Category> caux=categoryRepository.getCategory(c.getId());
            if(caux.isEmpty()){
                return categoryRepository.save(c);
            } else {
                return c;
            }
        }
    }
    
    public Category update(Category c){
        if(c.getId() != null){
            Optional<Category> caux = categoryRepository.getCategory(c.getId());
            if(!caux.isEmpty()){
                if(c.getDescription()!= null){
                    caux.get().setDescription(c.getDescription());
                }
                if(c.getName() != null){
                    caux.get().setName(c.getName());
                }
                categoryRepository.save(caux.get());
                return caux.get();
            } else {
                return c;
            }
        }else{
            return c;
        }
    }
    
    public boolean delete(int id){
        Boolean repuesta = getCategory(id).map(c ->{
            categoryRepository.delete(c);
            return true;
        }).orElse(false);
        return repuesta;
    }
}
