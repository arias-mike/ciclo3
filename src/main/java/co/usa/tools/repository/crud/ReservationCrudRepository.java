package co.usa.tools.repository.crud;

import co.usa.tools.model.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mike
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
}
