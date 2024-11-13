package service;


import entity.PSU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import repo.PSU_repo;

public class PSUService {
    @Autowired
    private PSU_repo psuRepo;

    public PSU findPSUById(Integer id) {
        return psuRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PSU not found"));
    }

    public void deletePSUById(Integer PSUId){
        psuRepo.deleteById(PSUId);
    }

    public PSU updatePSUById(PSU updatedPSU){
        if (updatedPSU.getId()==null){
            throw new RuntimeException("id cannot be null");
        }
        try {
            return psuRepo.save(updatedPSU);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("PSU must not be null");
        }

    }

    public PSU createMotherboard(@RequestBody PSU psu){
        if(psu.getId()!=null){
            throw new RuntimeException("id must be null");
        }
        try{
            return psuRepo.save(psu);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("PSU mustn't be null");
        }
    }
}
