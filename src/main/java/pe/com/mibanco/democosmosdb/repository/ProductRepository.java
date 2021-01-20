package pe.com.mibanco.democosmosdb.repository;

import java.util.List;

import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;

import org.springframework.stereotype.Repository;

import pe.com.mibanco.democosmosdb.entity.Product;

@Repository
public interface ProductRepository extends CosmosRepository<Product, String> {
    
    List<Product> findByProductName(String productName);

}
