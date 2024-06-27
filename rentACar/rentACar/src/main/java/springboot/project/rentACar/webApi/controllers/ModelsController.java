package springboot.project.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import springboot.project.rentACar.business.abstracts.ModelService;
import springboot.project.rentACar.business.requests.CreateModelRequest;
import springboot.project.rentACar.business.responses.GetAllModelsResponse;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

	private ModelService modelService;

	@GetMapping()
	public List<GetAllModelsResponse> getAll()
	{
		return this.modelService.getAll();
	}

	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid CreateModelRequest createModelRequest) 
	{
		this.modelService.add(createModelRequest);
	}
}