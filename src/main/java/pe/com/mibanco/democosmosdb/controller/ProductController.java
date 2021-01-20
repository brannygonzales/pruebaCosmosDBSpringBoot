package pe.com.mibanco.democosmosdb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.mibanco.democosmosdb.entity.Product;
import pe.com.mibanco.democosmosdb.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepo;

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> agregar(@RequestBody Product product) {
        return ResponseEntity.ok().body(productRepo.save(product));
    }

    @GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> listar() {
        List<Product> listaProductos = new ArrayList<>();
        productRepo.findAll().forEach(p -> listaProductos.add(p));
        return ResponseEntity.ok().body(listaProductos);
    }

    @GetMapping(value = "/product/{productName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> buscar(@PathVariable("productName") String productName) {
        return ResponseEntity.ok().body(productRepo.findByProductName(productName));
    }

}
