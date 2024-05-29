package codebusters.smarttradebackend;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishList;
import codebusters.smarttradebackend.BusinessLogic.Service.WishList.WishListService;
import codebusters.smarttradebackend.Persistence.Repository.ProductRepository;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
import codebusters.smarttradebackend.Persistence.Repository.WishList.WishListRepository;
import codebusters.smarttradebackend.Persistence.Repository.WishList.WishProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class SmartTradeBackEndApplicationTests {


    @Mock
    private WishListRepository wishListRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private WishProductRepository wishProductRepository;
    @Mock
    private UserRepository userRepository;

    @Autowired
    private WishListService wldata;

    @Test
    void test1() {
        int userId = 1;
        List<Product> expectedProducts = new ArrayList<>();
        when(wishListRepository.findProductsByUserId(userId)).thenReturn(expectedProducts);

        List<Product> actualProducts = wldata.getWishProductsById(userId);

        assertEquals(expectedProducts, actualProducts);
    }
    @Test
    void test2() {
        User user = new User("test@example.com", "John Doe", "password", "City", "Street", "123", null, null, "client", "12345678A", null, null);
        Product product = new Product("Product Name", 100.0, "Type", "Description", false, false, 1, new byte[]{});

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(productRepository.findById(452)).thenReturn(Optional.of(product));

        WishList wishList = new WishList(user);
        when(wishListRepository.findByUserId(1)).thenReturn(Optional.of(wishList));
        int result1 = wldata.addWishedProduct(1, 452);
        assertEquals(1, result1);
   }

    @Test
    void test3() {
        User user = new User("test@example.com", "John Doe", "password", "City", "Street", "123", null, null, "client", "12345678A", null, null);
        Product product = new Product("Product Name", 100.0, "Type", "Description", false, false, 1, new byte[]{});
        WishList wishList = new WishList(user);

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(productRepository.findById(452)).thenReturn(Optional.of(product));

        when(wishListRepository.findByUserId(1)).thenReturn(Optional.of(wishList));
        int result2 = wldata.addWishedProduct(1, 452);
        assertEquals(-1, result2);

   }
    @Test
    void test4() {
        User user = new User("test@example.com", "John Doe", "password", "City", "Street", "123", null, null, "client", "12345678A", null, null);

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(productRepository.findById(453)).thenReturn(Optional.empty());
        int result4 = wldata.addWishedProduct(1, 453);
        assertEquals(-1, result4);
    }

}
