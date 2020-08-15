package com.shop.service.impl;

import com.shop.dao.ProductMapper;
import com.shop.domain.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> getProductList() {
        //List<Product> products = productMapper.selectByExample(null);
        List<Product> products = productMapper.selectByExampleWithBLOBs(null);
        return products;
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public int updateProduct(Product product) {
        int row = productMapper.updateByPrimaryKeySelective(product);
        return row;
    }
}
