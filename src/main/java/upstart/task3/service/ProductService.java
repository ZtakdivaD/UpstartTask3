package upstart.task3.service;

import java.io.Serializable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import upstart.task3.dao.ProductRepository;

import upstart.task3.domain.Product;
import upstart.task3.dto.EventReturnCode;

import upstart.task3.dto.ProductDto;
import upstart.task3.exceptions.UserConflictException;

@Service
public class ProductService implements IProductService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	ProductRepository productRepository;

	@Override
	public EventReturnCode addProduct(ProductDto productDto) {
		if (productRepository.existsById(productDto.getId())) {
			throw new UserConflictException("Person with ID [" + productDto.getId() + "] already exist");
		}
		Product person = new Product(productDto);
		productRepository.save(person);
		return EventReturnCode.OK;
	}

	@Override
	public ProductDto getProductById(Long id) {
		if (!productRepository.existsById(id)) {
			throw new UserConflictException("Person with ID [" + id + "] does not exist");
		}
		
		productRepository.findById(id).orElse(null);
		ProductDto dto = convertToProductDto(productRepository.findById(id).orElse(null));
		return dto;
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public EventReturnCode removeProductById(Long id) {
		if (!productRepository.existsById(id)) {
			throw new UserConflictException("Person with ID [" + id + "] does not exist");
		}
		productRepository.deleteById(id);
		return EventReturnCode.DELETED;
	}
	
	private ProductDto convertToProductDto(Product product) {
		return ProductDto.builder().id(product.getId()).name(product.getName())
				.description(product.getDescription()).amount(product.getAmount())
				.date(product.getDate()).priv(product.isPriv())
				.build();
	}

	@Override
	public ProductDto editProduct(ProductDto productDto) {
		if (!productRepository.existsById(productDto.getId())) {
			throw new UserConflictException("Person with ID [" + productDto.getId() + "] does not exist");
		}
		
		Product product = productRepository.findById(productDto.getId()).get();

		if (productDto.getName() != null) {
			product.setName(productDto.getName());
		}
		if (productDto.getDescription() != null) {
			product.setDescription(productDto.getDescription());
		}
		if (productDto.getAmount() !=0) {
			product.setAmount(productDto.getAmount());
		}
		if (productDto.getDate() != null) {
			product.setDate(productDto.getDate());
		}
		if (productDto.isPriv()) {
			product.setPriv(productDto.isPriv());
		}
		
		productRepository.save(product);
		return convertToProductDto(product);
	}

}
