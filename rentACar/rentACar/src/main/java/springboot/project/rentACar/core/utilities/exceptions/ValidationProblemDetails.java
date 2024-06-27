package springboot.project.rentACar.core.utilities.exceptions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationProblemDetails extends ProblemDetails //Hangi Alanda Ne hatası var ?
{
	private Map<String,String>	validationErrors;
}
