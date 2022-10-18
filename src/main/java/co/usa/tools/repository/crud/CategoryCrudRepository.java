package co.usa.tools.repository.crud;

import co.usa.tools.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mike
 */
public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
    
}
