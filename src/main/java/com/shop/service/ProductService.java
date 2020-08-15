package com.shop.service;

import com.shop.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询全部产品信息
     * @return
     */
    List<Product> getProductList();

    /**
     * 根据id查询产品信息
     * @param id
     * @return
     */
    Product getProductById(Integer id);

    /**
     * 修改产品信息
     * @param product
     * @return
     */
    int updateProduct(Product product);
}
