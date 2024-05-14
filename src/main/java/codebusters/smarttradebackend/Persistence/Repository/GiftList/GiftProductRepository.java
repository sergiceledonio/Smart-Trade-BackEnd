package codebusters.smarttradebackend.Persistence.Repository.GiftList;

import codebusters.smarttradebackend.BusinessLogic.Models.GiftList.GiftProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftProductRepository extends JpaRepository<GiftProduct, Integer> {

}
