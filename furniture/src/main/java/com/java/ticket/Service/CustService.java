package com.java.ticket.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.ticket.Model.User;
import com.java.ticket.Repository.CustRepo;

@Service
public class CustService {
    @Autowired
    private CustRepo custRepo;

    public User saveDetails(User user){
        return custRepo.save(user);
    }
    
    public java.util.List<User> getAllDetails(){
        return custRepo.findAll();
    }
    
    public User updateDetail(User user){
        User updateUser=custRepo.findById(user.getId()).orElse(null);
        if(updateUser!=null){
            updateUser.setAge(user.getAge());
            updateUser.setEmail(user.getEmail());
            updateUser.setName(user.getName());
            updateUser.setphonenumber(user.getphonenumber());
            custRepo.save(updateUser);
            return updateUser;


        }
        return null;
    }
    public String deleteDetail(int id){
        if(custRepo.existsById(id)){
            
            custRepo.deleteById(id);
            return "deleted id: "+id;
        }
        else{
            return "id"+id+" not exists";
        }
    }
}
