package springboot.project.rentACar.business.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import springboot.project.rentACar.core.utilities.exceptions.BusinessException;
import springboot.project.rentACar.dataAccess.abstracts.BrandRepository;

@AllArgsConstructor
@Service
public class BrandBusinessRules
{
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) 
	{
		if(this.brandRepository.existsByName(name))
		{
			throw new BusinessException("Brand Already Exist");
		}
	}
}
