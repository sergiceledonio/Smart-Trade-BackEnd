package codebusters.smarttradebackend.Persistence.Repository;

import codebusters.smarttradebackend.BusinessLogic.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
