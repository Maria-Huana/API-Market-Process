package com.aula01.api_process.controller;

import com.aula01.api_process.entity.ProductEntity;
import com.aula01.api_process.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    //Deve Listar os produtos pelo metodo GET
  @GetMapping
    public ResponseEntity<List<ProductEntity>> findAllProducts(){
         List<ProductEntity> productList = productService.findAllProducts();
         return ResponseEntity.ok(productList);

  }
  // Deve buscar um produto pelo Id
  @GetMapping("/{productId}")
  public ResponseEntity<ProductEntity> findProductById(@PathVariable UUID productId){
     ProductEntity product = productService.findProductById(productId);
     return ResponseEntity.ok(product);
  }


    //Deve Atualizar um produto pelo ID usando o metodo PUT
  @PutMapping("/{productId}")
    public ResponseEntity<ProductEntity> update(@PathVariable UUID productId, @RequestBody ProductEntity toUpdate){
     System.out.println(productId);
    ProductEntity response =  productService.updateProduct(productId, toUpdate);
    System.out.println(response);
    return ResponseEntity.ok(response);

  }
  // Deve Deletar um produto pelo ID usando o metodo DELETE
  @DeleteMapping("/{productId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID productId){
     productService.deleteProduct(productId);
     return ResponseEntity.ok(HttpStatus.ACCEPTED);
  }

}
