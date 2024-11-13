package service;

import entity.GPU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import repo.GPU_repo;

public class GPUService {
    @Autowired
    private GPU_repo gpuRepo;

    public GPU findGPUById(Integer id) {
        return gpuRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Motherboard not found"));
    }

    public void deleteGPUById(Integer GPUId){
        gpuRepo.deleteById(GPUId);
    }

    public GPU updateGPUById(GPU updatedGPU){
        if (updatedGPU.getId()==null){
            throw new RuntimeException("id cannot be null");
        }
        try {
            return gpuRepo.save(updatedGPU);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("GPU must not be null");
        }

    }

    public GPU createGPU(@RequestBody GPU gpu){
        if(gpu.getId()!=null){
            throw new RuntimeException("id must be null");
        }
        try{
            return gpuRepo.save(gpu);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("GPU mustn't be null");
        }
    }
}
