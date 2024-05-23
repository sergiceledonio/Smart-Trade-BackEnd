package codebusters.smarttradebackend.Persistence.Repository.OrderRepository;

import codebusters.smarttradebackend.BusinessLogic.Models.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.cart.user = :user")
    public List<Order> findByUserId(int user);
}
