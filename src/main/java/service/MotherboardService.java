package service;

import entity.Motherboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import repo.Motherboard_repo;

public class MotherboardService {

    @Autowired
    private Motherboard_repo motherboardRepo;

    public Motherboard findMotherboardById(Integer id) {
        return motherboardRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Motherboard not found"));
    }

    public void deleteMotherboardById(Integer motherboardId){
        motherboardRepo.deleteById(motherboardId);
    }

    public Motherboard updateMotherboardById(Motherboard updatedMotherboard){
        if (updatedMotherboard.getId()==null){
            throw new RuntimeException("id cannot be null");
        }
        try {
            return motherboardRepo.save(updatedMotherboard);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("motherboard must not be null");
        }

    }

    public Motherboard createMotherboard(@RequestBody Motherboard motherboard){
        if(motherboard.getId()!=null){
            throw new RuntimeException("id must be null");
        }
        try{
            return motherboardRepo.save(motherboard);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Motherboard mustn't be null");
        }
    }
}
