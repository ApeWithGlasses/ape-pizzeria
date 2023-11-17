package com.apewithglasses.pizza.persistence.repository;

import com.apewithglasses.pizza.persistence.entity.OrderEntity;
import com.apewithglasses.pizza.persistence.projection.OrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findAllByDateAfter(LocalDateTime date);
    List<OrderEntity> findAllByMethodIn(List<String> methods);

    @Query(value = "SELECT * FROM tbl_order_pizza WHERE id_customer = :id", nativeQuery = true)
    List<OrderEntity> findCustomerOrders(@Param("id") String idCustomer);

    @Query(value = "SELECT op.id_order AS idOrder, " +
            " cu.name AS customerName, " +
            " op.date AS orderDate, " +
            " op.total AS orderTotal, " +
            " group_concat(pi.name) AS pizzaNames " +
            "FROM tbl_order_pizza op " +
            "    INNER JOIN tbl_customer cu ON op.id_customer = cu.id_customer " +
            "    INNER JOIN tbl_order_item oi ON op.id_order = oi.id_order " +
            "    INNER JOIN tbl_pizza pi ON oi.id_pizza = pi.id_pizza " +
            "WHERE op.id_order = :orderId " +
            "GROUP BY op.id_order, cu.name, op.date, op.total;", nativeQuery = true)
    OrderSummary findSummary(@Param("orderId") int orderId);

    @Procedure(value = "take_random_pizza_order", outputParameterName = "order_taken")
    boolean saveRandomOrder(@Param("id_customer") String idCustomer, @Param("method") String method);
}
