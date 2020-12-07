package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.Order;

import java.util.List;

public interface OrderService {
    Order findAllByUser_Id(long id);

    List<Order> findAll();
}
