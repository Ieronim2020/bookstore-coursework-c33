package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.Order;
import by.tms.bookstorecourseworkc33.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findAllByUser_Id(long id){
        orderRepository.findAllByUser_Id(id);
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

}
