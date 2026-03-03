package com.practice.RedisServerForGlobalCache.Service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.practice.RedisServerForGlobalCache.Entity.Product;
import com.practice.RedisServerForGlobalCache.Repo.ProductRepository;

@Service
public class ProductService {
	
	//Best Practice for Dependency Injection instead of @Autowired above private ProductRepository jpa;
	private ProductRepository repository;
	
	public ProductService(ProductRepository repository) {
		this.repository=repository;
	}
	
	
	@CachePut(cacheNames = "product" , key="#result.id" )  //This will create  a map of name product in which the values will be product object but we need to give key , and syntax of key is key="#result.primary_key attribute name" so here our primary key is id so we will give #result.id
	public Product addProduct(Product p) {
		return repository.save(p);  //Here data will be stored in the database and not in Cache so to put the data in cache we will use annotation @CachePut
	}

	
	@Cacheable(cacheNames = "product" , key="#id") //When we are storing we will use #result.id but when we are fetching we will use Cacheable annotation which is used for read operations and key would be key=#id
	public Product getById(int id) {
		return repository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Id not present"));
	}
	
	@CachePut(cacheNames = "product", key = "#result.id")
	public Product updateProduct(Product p) {
		Product existing = repository.findById(p.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
		
		existing.setName(p.getName());
		
		return repository.save(existing);
	}
	
	@CacheEvict(cacheNames = "product", key = "#id")
    public void deleteProduct(int id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }

        repository.deleteById(id);
    }
}
