package net.ayman.demobdccspringdata.web;

import net.ayman.demobdccspringdata.entities.Product;
import net.ayman.demobdccspringdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;
@RestController
@RequestMapping("/api")
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/products")
    public List<Product> allProduct(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findBuId(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found") );
    }
    @GetMapping("/find/products")
    public List<Product> findProducts(@RequestParam(name = "kw", defaultValue = "") String kw){
        return productRepository.findByNameContains(kw);
    }

    @PostMapping("/products")
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Long id){
        productRepository.deleteById(id);
    }


}
