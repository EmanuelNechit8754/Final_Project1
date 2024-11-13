package service;

import entity.CPU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import repo.CPU_repo;


public class CPUService {
    @Autowired
    private CPU_repo cpuRepo;

    public CPU findCPUById(Integer id) {
        return cpuRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cpu not found"));
    }

    public void deleteCPUById(Integer CPUId){
        cpuRepo.deleteById(CPUId);
    }

    public CPU updateCPUById(CPU updatedCPU){
        if (updatedCPU.getId()==null){
            throw new RuntimeException("id cannot be null");
        }
        try {
            return cpuRepo.save(updatedCPU);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("CPU must not be null");
        }

    }

    public CPU createCPU(@RequestBody CPU cpu){
        if(cpu.getId()!=null){
            throw new RuntimeException("id must be null");
        }
        try{
            return cpuRepo.save(cpu);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("CPU mustn't be null");
        }
    }
}
