package upstart.task3.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class ProductDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	private long id;
	@NotBlank
	private String name;
	@NotBlank
	private String description;
	@NotBlank
	private int amount;
	@NotBlank
	private LocalDate date;
	@NotBlank
	private boolean priv;
	
	
}
