package springboot.project.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.project.rentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> 
{

}
