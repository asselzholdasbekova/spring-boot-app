package kz.assel.springcourse.SpringBootApp.controllers;


import kz.assel.springcourse.SpringBootApp.models.Order;
import kz.assel.springcourse.SpringBootApp.models.Product;
import kz.assel.springcourse.SpringBootApp.services.OrderService;
import kz.assel.springcourse.SpringBootApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping()
    public String getAll(Model model){
        model.addAttribute("orders", orderService.getAll());

        return "orders/basket";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model){
        model.addAttribute("order", orderService.getById(id));

        return "orders/show";
    }

    @GetMapping("/new")
    public String newOrder(Model model){
        Order order = new Order();

        List<Product> options = new LinkedList<>();
        options.addAll(productService.getAll());

        model.addAttribute("options", options);
        model.addAttribute("order", order);

        return "orders/new";
    }

    @PostMapping()
    public String add(@ModelAttribute("order") Order order){


        Product product = productService.getById(order.getProductId());
        order.setPrice(product.getPrice());

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 2);
        Date newDate = cal.getTime();
        order.setDate(newDate);
        order.setTrackerId(100);

        orderService.add(order);

        return "orders/success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        orderService.delete(id);

        return "redirect:/orders";
    }
}
