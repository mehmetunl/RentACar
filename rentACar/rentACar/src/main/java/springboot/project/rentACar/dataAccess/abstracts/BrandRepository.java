package springboot.project.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.project.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer> 
{
	boolean existsByName(String name);
}
