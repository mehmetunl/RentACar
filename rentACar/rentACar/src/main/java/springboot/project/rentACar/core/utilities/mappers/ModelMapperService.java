package springboot.project.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService
{
	ModelMapper forRepsonse();
	
	ModelMapper forRequest();
}
