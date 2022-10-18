package co.usa.tools.repository.crud;

import co.usa.tools.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mike
 */
public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
    
}
