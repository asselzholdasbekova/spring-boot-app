package kz.assel.springcourse.SpringBootApp.services;

import kz.assel.springcourse.SpringBootApp.models.Order;
import kz.assel.springcourse.SpringBootApp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderService {
    public final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public Object getById(int id){
        Optional<Order> order =  orderRepository.findById(id);

        return order.orElse(null);
    }

    @Transactional
    public void add(Order order){
        orderRepository.save(order);
    }

    @Transactional
    public void delete(int id){
        orderRepository.deleteById(id);
    }
}
