package codebusters.smarttradebackend;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishList;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishProduct;
import codebusters.smarttradebackend.BusinessLogic.Service.Product.ProductService;
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
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class SmartTradeBackEndApplicationTests {
    @Mock
    private WishListRepository wlrepo;
    @Mock
    private ProductRepository prepo;
    @Mock
    private WishProductRepository wpdata;
    @Mock
    private UserRepository udata;
    @Mock
    private ProductService pdata;
    @InjectMocks
    private WishListService wldata;
    User user;
    Product product;
    WishList wishList;
    WishProduct wishProduct;
    private List<Product> mockProducts;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        product = new Product();
        wishList = new WishList(user);
        wishProduct = new WishProduct(wishList, product);

        mockProducts = new ArrayList<>();
        mockProducts.add(new Product());
        mockProducts.add(new Product());
        mockProducts.add(product);
    }

    @Test
    @DisplayName("TEST 1")
    //Testeo del método findProductsByUserId(); Recoge los productos asociados al id de usuario y los esperados
    // y en el assertEquals comprueba que sean iguales
    void test1() {
        List<Product> expectedProducts = new ArrayList<>();
        when(wldata.getWishProductsById(1)).thenReturn(expectedProducts);
        List<Product> actualProducts = wldata.getWishProductsById(1);
        assertEquals(expectedProducts, actualProducts);
    }
    @Test
    @DisplayName("TEST 1.5")
    void test1_5(){
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product());
        expectedProducts.add(new Product());
        expectedProducts.add(new Product());

        when(wldata.getWishProductsById(1)).thenReturn(mockProducts);
        List<Product> products = wldata.getWishProductsById(1);
        assertEquals(expectedProducts.size(), products.size());
    }
    @Test
    @DisplayName("TEST 2")
    //Testeo del método addWishedProduct(); Añade un producto a un usuario que no estaba en la lista anteriormente
    // y después comprueba que el método devuelva 1(Añadido correctamente)
    void test2() {
        when(udata.findById(1)).thenReturn(Optional.of(user));
        when(prepo.findById(1)).thenReturn(Optional.of(product));

        when(wlrepo.findByUserId(1)).thenReturn(Optional.of(wishList));
        int result1 = wldata.addWishedProduct(1, 1);

        assertEquals(1, result1);
   }
   @Test
   @DisplayName("TEST 3")
   //Testeo del método addWishedProduct(); No añade un producto a un usuario que estaba en la lista anteriormente
   // y después comprueba que el método devuelva -1(No se ha añadido)
   void test2_5(){
       when(udata.findById(1)).thenReturn(Optional.of(user));
       when(prepo.findById(10)).thenReturn(Optional.of(product));

       List<Product> wishProducts = new ArrayList<>();
       wishProducts.add(product);
       wishProducts.add(new Product());
       wishProducts.add(new Product());

       when(wlrepo.findByUserId(1)).thenReturn(Optional.of(wishList));
       when(wldata.getWishProductsById(wishList.getId())).thenReturn(mockProducts);
       System.out.println("Size1(): " + wldata.getWishProductsById(wishList.getId()).size());

       int result = wldata.addWishedProduct(1, 10);

       System.out.println("Size2(): " + wldata.getWishProductsById(wishList.getId()).size());

       assertEquals(-1, result);
   }
    @Test
    @DisplayName("TEST 4")
    //Delete product
    void test3(){
        when(udata.findById(1)).thenReturn(Optional.of(user));
        when(wlrepo.findByUserId(1)).thenReturn(Optional.of(wishList));
        when(pdata.getProductByName("prod")).thenReturn(Optional.of(product));
        when(pdata.getProductById(10)).thenReturn(Optional.of(product));
        when(wpdata.findByProduct(product.getId(), wishList.getId())).thenReturn(wishProduct);

        List<Product> wishProducts = new ArrayList<>();
        wishProducts.add(product);
        wishProducts.add(new Product());
        wishProducts.add(new Product());

        when(wldata.getWishProductsById(1)).thenReturn(wishProducts);

        assertTrue(wldata.getWishProductsById(1).contains(product));

        wldata.delete(1, "prod");
        assertFalse(wldata.getWishProductsById(1).contains(product));
    }
}
