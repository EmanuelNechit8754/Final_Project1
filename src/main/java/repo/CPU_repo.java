package repo;

import entity.CPU;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CPU_repo extends JpaRepository<CPU, Integer> {
}
