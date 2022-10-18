package co.usa.tools.service;

import co.usa.tools.model.Reservation;
import co.usa.tools.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mike
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        } else {
            Optional<Reservation> raux=reservationRepository.getReservation(r.getIdReservation());
            if(raux.isEmpty()){
                return reservationRepository.save(r);
            } else {
                return r;
            }
        }
    }
    
    public Reservation update(Reservation r){
        if(r.getIdReservation()!= null){
            Optional<Reservation> raux = reservationRepository.getReservation(r.getIdReservation());
            if(!raux.isEmpty()){
                if(r.getStartDate()!= null){
                    raux.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!= null){
                    raux.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getStatus()!= null){
                    raux.get().setStatus(r.getStatus());
                }
                reservationRepository.save(raux.get());
                return raux.get();
            } else {
                return r;
            }
        }else{
            return r;
        }
    }
    
    public boolean delete(int id){
        Boolean repuesta = getReservation(id).map(r ->{
            reservationRepository.delete(r);
            return true;
        }).orElse(false);
        return repuesta;
    }
}
