package upstart.task3.service;

import java.util.List;


import upstart.task3.domain.Product;
import upstart.task3.dto.EventReturnCode;

import upstart.task3.dto.ProductDto;

public interface IProductService {

	public EventReturnCode addProduct(ProductDto personDto);

	public ProductDto getProductById(Long id);

	public List<Product> getAllProduct();

	public EventReturnCode removeProductById(Long id);

	public ProductDto editProduct(ProductDto personDto);
}
