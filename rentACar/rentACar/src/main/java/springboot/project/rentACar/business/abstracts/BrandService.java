package springboot.project.rentACar.business.abstracts;

import java.util.List;

import springboot.project.rentACar.business.requests.CreateBrandRequest;
import springboot.project.rentACar.business.requests.UpdateBrandRequest;
import springboot.project.rentACar.business.responses.GetAllBrandsResponse;
import springboot.project.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService 
{
	List<GetAllBrandsResponse> getAll();
	
	GetByIdBrandResponse getById(int id);
	
	void add(CreateBrandRequest createBrandRequest);
	
	void update(UpdateBrandRequest updateBrandRequest);
	
	void delete(int id);

}

