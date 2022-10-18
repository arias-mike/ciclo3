package co.usa.tools.service;

import co.usa.tools.model.Message;
import co.usa.tools.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mike
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        } else {
            Optional<Message> maux=messageRepository.getMessage(m.getIdMessage());
            if(maux.isEmpty()){
                return messageRepository.save(m);
            } else {
                return m;
            }
        }
    }
    
    public Message update(Message m){
        if(m.getIdMessage() != null){
            Optional<Message> maux = messageRepository.getMessage(m.getIdMessage());
            if(!maux.isEmpty()){
                if(m.getMessageText()!= null){
                    maux.get().setMessageText(m.getMessageText());
                }
                messageRepository.save(maux.get());
                return maux.get();
            } else {
                return m;
            }
        }else{
            return m;
        }
    }
    
    public boolean delete(int id){
        Boolean repuesta = getMessage(id).map(m ->{
            messageRepository.delete(m);
            return true;
        }).orElse(false);
        return repuesta;
    }
}
