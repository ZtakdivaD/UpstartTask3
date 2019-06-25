package upstart.task3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import upstart.task3.domain.Product;
import upstart.task3.dto.EventReturnCode;

import upstart.task3.dto.ProductDto;

import upstart.task3.service.IProductService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {

	@Autowired
	IProductService iProductService;

	@PostMapping("/contact")
	public EventReturnCode addProduct(@RequestBody ProductDto productDto) {
		return iProductService.addProduct(productDto);
	}

	@GetMapping("/get/{productId}")
	public ProductDto getProductById(@PathVariable Long productId) {
		return iProductService.getProductById(productId);
	}

	@GetMapping("/all")
	public List<Product> getAllProduct() {
		return iProductService.getAllProduct();
	}

	@DeleteMapping("/contact/{productId}")
	public EventReturnCode removeProductById(@PathVariable Long productId) {
		return iProductService.removeProductById(productId);
	}

	@PutMapping("/contact")
	public ProductDto editProduct(@RequestBody ProductDto productDto) {
		return iProductService.editProduct(productDto);
	}
}
