package com.aula01.api_process.service;

import com.aula01.api_process.entity.ProductEntity;
import com.aula01.api_process.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductEntity create(ProductEntity product) {

        return productRepository.save(product);
    }

    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity updateProduct(UUID productId, ProductEntity toUpdate) {
        Optional<ProductEntity> inDataBase = productRepository.findById(productId);

        if(inDataBase.isEmpty()) {
            return null;
        }
        ProductEntity toSave = inDataBase.get();
        toSave.setName(toUpdate.getName());
        toSave.setPrice(toUpdate.getPrice());
        toSave.setStock(toUpdate.getStock());
        toSave.setReserve(toUpdate.getReserve());
        return productRepository.save(toSave);
    }

    public void deleteProduct(UUID productId) {
        // orElseThrow()-> ele lança uma exceção para o sistema retornar no front.
        ProductEntity product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        productRepository.delete(product);
    }
    public ProductEntity findProductById(UUID id){
        // 1-> Buscar no banco de dados um produto pelo ID (ok)
        // 2-> Caso não ache, deve lançar um erro (ok)
        // 3-> Uma vez achado, deve retornar um ProductEntity
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
    }
}