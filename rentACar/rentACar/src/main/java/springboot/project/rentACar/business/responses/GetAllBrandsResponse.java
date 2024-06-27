package springboot.project.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse //Request Response Patterns
{
	private int  id;
	
	private String name;
}
