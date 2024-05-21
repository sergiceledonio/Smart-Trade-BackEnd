package codebusters.smarttradebackend.Persistence.Repository.OrderRepository;

import codebusters.smarttradebackend.BusinessLogic.Models.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
