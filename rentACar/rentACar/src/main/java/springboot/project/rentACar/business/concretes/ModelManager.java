package springboot.project.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import springboot.project.rentACar.business.abstracts.ModelService;
import springboot.project.rentACar.business.requests.CreateModelRequest;
import springboot.project.rentACar.business.responses.GetAllModelsResponse;
import springboot.project.rentACar.core.utilities.mappers.ModelMapperService;
import springboot.project.rentACar.dataAccess.abstracts.ModelRepository;
import springboot.project.rentACar.entities.concretes.Model;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService 
{
	//Dependency Injection IoC conteiner yapılanması
	private ModelRepository modelRepository;
	
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllModelsResponse> getAll() 
	{
		List<Model> models = modelRepository.findAll();

		List<GetAllModelsResponse> modelResponse = models.stream()
				.map(model -> this.modelMapperService.forRepsonse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());
		
		return modelResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) 
	{
		Model model=this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		
		this.modelRepository.save(model);
	}

}
