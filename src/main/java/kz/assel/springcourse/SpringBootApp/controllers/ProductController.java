package kz.assel.springcourse.SpringBootApp.controllers;

import kz.assel.springcourse.SpringBootApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping()
//    public String basket(Model model){
//        model.addAttribute("products", productDao.index());
//
//        return "products/basket";
//    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getById(id));

        return "products/show";
    }

//    @GetMapping("/new")
//    public String newProduct(@ModelAttribute("product") Product product){
//        return "products/new";
//    }

//    @PostMapping()
//    public String create(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return "";
//        }
//        productDao.save(product);
//
//        return "redirect:/products";
//    }

//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id){
//        productDao.delete(id);
//
//        return "redirect:/products";
//    }
}

