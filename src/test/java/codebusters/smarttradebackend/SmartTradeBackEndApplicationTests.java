package codebusters.smarttradebackend;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishList;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishProduct;
import codebusters.smarttradebackend.BusinessLogic.Service.WishList.WishListService;
import codebusters.smarttradebackend.Persistence.Repository.ProductRepository;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
import codebusters.smarttradebackend.Persistence.Repository.WishList.WishListRepository;
import codebusters.smarttradebackend.Persistence.Repository.WishList.WishProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class SmartTradeBackEndApplicationTests {


    @Mock
    private WishListRepository wlrepo;
    @Mock
    private ProductRepository pdata;
    @Mock
    private WishProductRepository wpdata;
    @Mock
    private UserRepository udata;

    @InjectMocks
    private WishListService wldata;
    User user;
    Product product;
    WishList wishList;
    WishProduct wishProduct;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("TEST 1")
    //Testeo del método findProductsByUserId(); Recoge los productos asociados al id de usuario y los esperados y en el assertEquals comprueba que sean iguales
    void test1() {
        List<Product> expectedProducts = new ArrayList<>();
        when(wlrepo.findProductsByUserId(1)).thenReturn(expectedProducts);
        List<Product> actualProducts = wldata.getWishProductsById(1);
        assertEquals(expectedProducts, actualProducts);
    }
    @Test
    @DisplayName("TEST 2")
    //Testeo del método addWishedProduct(); Añade un producto a un usuario que no estaba en la lista anteriormente y después comprueba que el método devuelva 1(Añadido correctamente)
    void test2() {
        user = new User();
        product = new Product();

        when(udata.findById(1)).thenReturn(Optional.of(user));
        when(pdata.findById(1)).thenReturn(Optional.of(product));

        wishList = new WishList(user);
        when(wlrepo.findByUserId(1)).thenReturn(Optional.of(wishList));
        int result1 = wldata.addWishedProduct(1, 1);
        assertEquals(1, result1);
   }
   @Test
   @DisplayName("TEST 3")
   void test3(){
       user = new User();
       product = new Product();
       wishList = new WishList(user);
       wishProduct = new WishProduct(wishList, product);

       when(udata.findById(1)).thenReturn(Optional.of(user));
       when(pdata.findById(1)).thenReturn(Optional.of(product));
       when(wlrepo.findByUserId(1)).thenReturn(Optional.of(wishList));
       when(wpdata.findByProduct(product.getId(), wishList.getId())).thenReturn((wishProduct));

       int result = wldata.addWishedProduct(1, 1);

       assertEquals(-1, result);
   }



}
