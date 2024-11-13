package service;

import entity.CPU;
import entity.GPU;
import entity.Motherboard;
import entity.PSU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.CPU_repo;
import repo.GPU_repo;
import repo.Motherboard_repo;
import repo.PSU_repo;

@Service
public class CompatibilityService {

    @Autowired
    private CPU_repo cpuRepo;

    @Autowired
    private Motherboard_repo motherboardRepo;

    @Autowired
    private GPU_repo gpuRepo;

    @Autowired
    private PSU_repo psuRepo;

    public String addCpuToMotherboard(CPU cpu, Motherboard motherboard) {
        try {
            if (!cpu.getSocketType().equals(motherboard.getSocketType())) {
                return "Error: CPU socket type does not match Motherboard socket type.";
            }

            cpu.setMotherboard(motherboard);
            cpuRepo.save(cpu);

            return "CPU successfully added to the Motherboard.";

        } catch (Exception e) {

            return "An error occurred while adding the CPU to the Motherboard: " + e.getMessage();

        } finally {

            System.out.println("Attempted to add CPU to Motherboard. Finalized the method call.");
        }
    }

    public String addGPUToPSU(GPU gpu, PSU psu) {
        try {

            if (!gpu.getVoltage().equals(psu.getVoltage())) {
                return "Error: GPU voltage does not match PSU voltage.";
            }

            gpu.setPsu(psu);
            gpuRepo.save(gpu);

            return "GPU successfully added to the PSU.";

        } catch (Exception e) {

            return "An error occurred while adding the GPU to the PSU: " + e.getMessage();

        } finally {

            System.out.println("Attempted to add GPU to PSU. Finalized the method call.");
        }
    }
}
