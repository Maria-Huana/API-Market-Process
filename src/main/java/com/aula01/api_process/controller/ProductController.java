package com.aula01.api_process.controller;

import com.aula01.api_process.entity.ProductEntity;
import com.aula01.api_process.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("/product") // mapeia da internet para a aplicação
public class ProductController {

    @Autowired
    private ProductService productService;

 // Deve criar um produto pelo metodo POST
 @PostMapping
 public ResponseEntity<ProductEntity> create(@RequestBody ProductEntity entity){
     try {
         ProductEntity product = productService.create(entity);
         return ResponseEntity.ok(product);
     }catch (Exception exception){
         System.out.println(exception.getMessage());
         throw new RuntimeException("ERRO AO SALVAR PRODUTO");

 }}
  @GetMapping
    public ResponseEntity<List<ProductEntity>> findAllProducts(){
         List<ProductEntity> productList = productService.findAllProducts();
         return ResponseEntity.ok(productList);

  }

  @PutMapping("/{productId}")
    public ResponseEntity<ProductEntity> update(@RequestParam UUID productId, @RequestBody ProductEntity toUpdate){
    ProductEntity response =  productService.updateProduct(productId, toUpdate);
    return ResponseEntity.ok(response);
  }

}
