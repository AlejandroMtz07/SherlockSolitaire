package ProductControllerTest;

import com.example.demo.Exceptions.ProductNotValidException;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.ProductRepository;
import com.example.demo.Product.commandHandlers.CreateProductCommandHandler;
import com.example.demo.SpringBootCourseApplication;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = {SpringBootCourseApplication.class})
public class CreateProductCommandHandlerTest {


    @InjectMocks
    private CreateProductCommandHandler createProductCommandHandler;

    @Mock
    private ProductRepository productRepository;

    //MethodName_StateUnderTest_ExpectedBehavior
    @Test
    public void createProductCommandHandler_validProduct_returnsSuccess(){
        //Given When Then
        //Arrange Act Assert

        //Given
        Product product = new Product();
        product.setId(1);
        product.setPrice(9.99);
        product.setName("Best chocolate");
        product.setDescription("Silky dark");
        product.setQuantity(12);
        ResponseEntity response = createProductCommandHandler.execute(product);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    //MethodName_StateUnderTest_ExpectedBehavior
    @Test
    public void createProductCommandHandler_invalidPrice_throwsInvalidPriceException(){
        //Given
        Product product = new Product();
        product.setId(1);
        product.setPrice(-9.99);
        product.setName("Best chocolate");
        product.setDescription("Silky dark");
        product.setQuantity(12);

        //When / Then
        ProductNotValidException exception =
                assertThrows(ProductNotValidException.class,()->
                        createProductCommandHandler.execute(product));
        //Then
        assertEquals("Product price cannot be less than 0", exception.getSimpleResponse().getMessage());
    }

}
