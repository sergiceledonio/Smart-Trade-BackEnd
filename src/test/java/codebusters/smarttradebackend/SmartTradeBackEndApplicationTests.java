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

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test //Testeo del método findProductsByUserId(); Recoge los productos asociados al id de usuario y los esperados y en el assertEquals comprueba que sean iguales
    void test1() {
        int userId = 1;
        List<Product> expectedProducts = new ArrayList<>();
        when(wlrepo.findProductsByUserId(userId)).thenReturn(expectedProducts);
        List<Product> actualProducts = wldata.getWishProductsById(userId);
        assertEquals(expectedProducts, actualProducts);
    }
    @Test //Testeo del método addWishedProduct(); Añade un producto a un usuario que no estaba en la lista anteriormente y después comprueba que el método devuelva 1(Añadido correctamente)
    void test2() {
        User user = new User("test@example.com", "John Doe", "password", "City", "Street", "123", null, null, "client", "12345678A", null, null);
        Product product = new Product("Product Name", 100.0, "Type", "Description", false, false, 1, new byte[]{});

        when(udata.findById(1)).thenReturn(Optional.of(user));
        when(pdata.findById(452)).thenReturn(Optional.of(product));

        WishList wishList = new WishList(user);
        when(wlrepo.findByUserId(1)).thenReturn(Optional.of(wishList));
        int result1 = wldata.addWishedProduct(1, 452);
        assertEquals(1, result1);
   }

    @Test //Testeo del método addWishedProduct(); Añade un producto a un usuario que ya estaba en la lista anteriormente y después comprueba que el método devuelva -1(No se añade)
    void test3() {
        User user = new User("test@example.com", "John Doe", "password", "City", "Street", "123", null, null, "client", "12345678A", null, null);
        Product product = new Product("Product Name", 100.0, "Type", "Description", false, false, 1, new byte[]{});
        WishList wishList = new WishList(user);

        when(udata.findById(1)).thenReturn(Optional.of(user));
        when(pdata.findById(452)).thenReturn(Optional.of(product));

        when(wlrepo.findByUserId(1)).thenReturn(Optional.of(wishList));
        int result2 = wldata.addWishedProduct(1, 452);
        assertEquals(-1, result2);
   }
//   @Test //Testeo del método delete(); Intenta eliminar el wishproduct seleccionado(Este si que existe)
//    void test4(){
//        int userId = 1;
//        String productName = "Product Name";
//        User user = new User("test@example.com", "John Doe", "password", "City", "Street", "123", null, null, "client", "12345678A", null, null);
//        Product product = new Product("Product Name", 100.0, "Type", "Description", false, false, userId, new byte[]{});
//        WishList wishList = new WishList(user);
//
//        WishProduct wishProduct = new WishProduct(wishList, product);
//
//        when(pdata.findProductByName(productName)).thenReturn(Optional.of(product));
//        when(wpdata.findByProduct(product.getId(), wishList.getId())).thenReturn(wishProduct);
//
//
//        wldata.delete(userId, productName);
//        verify(wpdata).deleteById(wishProduct.getId());
//
//   }



}
