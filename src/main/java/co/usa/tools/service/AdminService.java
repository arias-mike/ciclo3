package co.usa.tools.service;

import co.usa.tools.model.Admin;
import co.usa.tools.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mike
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    
    public Admin save(Admin a){
        if(a.getIdAdmin()==null){
            return adminRepository.save(a);
        } else {
            Optional<Admin> aaux=adminRepository.getAdmin(a.getIdAdmin());
            if(aaux.isEmpty()){
                return adminRepository.save(a);
            } else {
                return a;
            }
        }
    }
    
    public Admin update(Admin a){
        if(a.getIdAdmin() != null){
            Optional<Admin> aaux = adminRepository.getAdmin(a.getIdAdmin());
            if(!aaux.isEmpty()){
                if(a.getPassword()!= null){
                    aaux.get().setPassword(a.getPassword());
                }
                if(a.getName() != null){
                    aaux.get().setName(a.getName());
                }
                adminRepository.save(aaux.get());
                return aaux.get();
            } else {
                return a;
            }
        }else{
            return a;
        }
    }
    
    public boolean delete(int id){
        Boolean repuesta = getAdmin(id).map(a ->{
            adminRepository.delete(a);
            return true;
        }).orElse(false);
        return repuesta;
    }
}
