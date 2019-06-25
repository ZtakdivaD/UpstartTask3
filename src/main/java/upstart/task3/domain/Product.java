package upstart.task3.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import upstart.task3.dto.ProductDto;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@ToString
@Setter
@Entity
public class Product {
	@Id
	private long id;

	private String name;

	private String description;

	private int amount;

	private LocalDate date;

	private boolean priv;
	
	public Product(ProductDto productDto) {
		this.id = productDto.getId();
		this.name = productDto.getName();
		this.description = productDto.getDescription();
		this.amount = productDto.getAmount();
		this.date = productDto.getDate();
		this.priv = productDto.isPriv();
	}
}
