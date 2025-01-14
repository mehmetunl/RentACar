package springboot.project.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import springboot.project.rentACar.business.abstracts.BrandService;
import springboot.project.rentACar.business.requests.CreateBrandRequest;
import springboot.project.rentACar.business.requests.UpdateBrandRequest;
import springboot.project.rentACar.business.responses.GetAllBrandsResponse;
import springboot.project.rentACar.business.responses.GetByIdBrandResponse;
import springboot.project.rentACar.business.rules.BrandBusinessRules;
import springboot.project.rentACar.core.utilities.mappers.ModelMapperService;
import springboot.project.rentACar.dataAccess.abstracts.BrandRepository;
import springboot.project.rentACar.entities.concretes.Brand;

@Service // Bu Sınıf Bir Business Nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService 
{
	//Dependency Injection
	private BrandRepository brandRepository;
	
	private ModelMapperService modelMapperService;
	
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		// İş Kuralları
		List<Brand> brands = brandRepository.findAll();

		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forRepsonse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) 
	{
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdBrandResponse getById(int id) 
	{

		Brand brand = this.brandRepository.findById(id).orElseThrow();

		GetByIdBrandResponse response = this.modelMapperService.forRepsonse().map(brand, GetByIdBrandResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) 
	{
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) 
	{
		this.brandRepository.deleteById(id);
	}

}
