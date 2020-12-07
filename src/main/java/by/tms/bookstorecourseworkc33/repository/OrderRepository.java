package by.tms.bookstorecourseworkc33.repository;

import by.tms.bookstorecourseworkc33.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUser_Id(Long id);
}
