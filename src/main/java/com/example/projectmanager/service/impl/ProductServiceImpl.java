package com.example.projectmanager.service.impl;

import com.example.projectmanager.model.entity.Retailer;
import com.example.projectmanager.service.ProductService;
import com.example.projectmanager.exception.NotFoundException;
import com.example.projectmanager.mapper.ProductMapper;
import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.entity.enums.RetailerName;
import com.example.projectmanager.factory.RandomProductFactory;
import com.example.projectmanager.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;
    private final RandomProductFactory randomProductFactory;
    private final ProductMapper productMapper;
    private static final List<Product> productsFromDb = new ArrayList<>();

    @Override
    @Transactional
    public void insertRandomProducts(Integer quantity) {
        List<Product> products = IntStream
                .range(0, quantity)
                .mapToObj(i -> randomProductFactory.createRandomProduct())
                .collect(Collectors.toList());
        productRepository.saveAll(products);
        log.info("created products = {}", products);
    }

    @Override
    @Transactional
    public void incrementStockLevelByRetailerName(String name) {
        if (RetailerName.RET_A.name().equals(name)) {
            productRepository.incrementStockLevel(5, name);
        } else if (RetailerName.RET_B.name().equals(name)) {
            productRepository.incrementStockLevel(8, name);
        }
    }

    @Override
    public List<ProductDto> findByKeyWord(String keyword) {
        List<Product> products = productRepository.findByKeyWord("%" + keyword + "%");
        return productMapper.toListProductDto(products);
    }

    @Override
    public List<ProductDto> blogPageable(Pageable pageable) {
        return productMapper.toListProductDto(productRepository.findAll(pageable).getContent());
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("No product found with such id = " + id));
        log.info("Found product with id = {}", id);
        return productMapper.toProductDto(product);
    }

    @Override
    @Transactional
    public ProductDto update(Product product) {
        Product productFromDb = productRepository.findById(product.getId()).orElseThrow(() -> new NotFoundException("No product updated with such id = " + product.getId()));
        productFromDb.setTitle(product.getTitle());
        productFromDb.setDescription(product.getDescription());
        productFromDb.setStockLevel(product.getStockLevel());
//        Long timestamp = product.lastModified();
        return productMapper.toProductDto(productRepository.save(productFromDb));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("No product deleted with such id = " + id));
        product.getRetailers()
                .forEach(retailer -> retailer.getProducts().removeIf(p -> p.getId().equals(product.getId())));
        productRepository.delete(product);
        log.info("Deleted product with id = {}", id);
    }

    @Override
    @Transactional
    public ProductDto create(Product product) {
        return productMapper.toProductDto(productRepository.save(product));
    }

    @Override
    public List<ProductDto> findParamsOfProductFoundByStockLevelRetailerStartDateEndDate(Long stockLevel, String retailer, LocalDate startDate, LocalDate endDate) {

//        return productMapper.toListProductDto(productRepository.findByStockLevelGreaterThanEqual(stockLevel));
        List<Product> byRetailersNameEquals = productRepository.findByRetailersNameEquals(retailer);
        return productMapper.toListProductDto(byRetailersNameEquals);
//        return productMapper.toListProductDto(productRepository.findByStartDateBetween(startDate, endDate));



    }
}
