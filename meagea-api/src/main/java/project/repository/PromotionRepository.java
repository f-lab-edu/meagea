package project.repository;

import entity.Animal;
import entity.Promotion;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
    Promotion findByNo(int no);
    List<Promotion> findAll();
}
