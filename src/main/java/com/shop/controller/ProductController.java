package com.shop.controller;

import com.shop.domain.Product;
import com.shop.exception.MyException;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("product")
    public ModelAndView productList() throws MyException {

        /*if (true){
            throw new MyException("出bug了，没有找到商品列表！");
        }*/

        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.getProductList();

        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("productList");
        return modelAndView;
    }

   /* @RequestMapping("/productSearch")
    public ModelAndView productSearch(CustomerVo customerVo){

        return null;
    }*/

    @RequestMapping("/getProductById/{id}")//Restful风格
    public ModelAndView getProductById(@PathVariable(value = "id") String id){
        ModelAndView modelAndView = new ModelAndView();
        Product product = null;
        if (id!=null&&id!=""){
            product = productService.getProductById(Integer.parseInt(id));
        }
        modelAndView.addObject("item",product);
        modelAndView.setViewName("productItem");
        return modelAndView;
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(Product product, MultipartFile pictureFile) throws Exception {
        //自己封装时间
        //product.setCreatetime(new Date());

        //获取到最原始的文件名称
        String filename = pictureFile.getOriginalFilename();

        //将原始的文件名称设置成唯一文件名
        String newFilename = UUID.randomUUID().toString()+filename.substring(filename.lastIndexOf("."));

        //上传
        pictureFile.transferTo(new File("E:\\images\\"+newFilename));

        product.setPic(newFilename);
        productService.updateProduct(product);
        return "redirect:product";
    }
}
