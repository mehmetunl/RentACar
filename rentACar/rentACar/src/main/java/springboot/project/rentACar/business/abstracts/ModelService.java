package springboot.project.rentACar.business.abstracts;

import java.util.List;

import springboot.project.rentACar.business.requests.CreateModelRequest;
import springboot.project.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService
{
	List<GetAllModelsResponse> getAll();
	
	void add(CreateModelRequest createModelRequest);

}
