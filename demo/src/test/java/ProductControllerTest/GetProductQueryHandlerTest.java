package ProductControllerTest;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Exceptions.ProductNotValidException;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.ProductDTO;
import com.example.demo.Product.ProductRepository;
import com.example.demo.Product.queryhandlers.GetProductQueryHandler;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SpringBootApplication.class})
public class GetProductQueryHandlerTest {

    @InjectMocks
    private GetProductQueryHandler productQueryHandler;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void getProductQueryHandler_validId_returnsProductDTO(){
        Product product = new Product();
        product.setId(1);
        product.setPrice(9.99);
        product.setName("Best chocolate");
        product.setDescription("Silky dark");
        product.setQuantity(12);

        ProductDTO expectedDTO = new ProductDTO(product);

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        ResponseEntity<ProductDTO> actualResponse = productQueryHandler.execute(product.getId());
        assertNotEquals(expectedDTO, actualResponse.getBody());
        assertEquals(HttpStatus.OK,actualResponse.getStatusCode());


    }
    @Test
    public void getProductQueryHandler_invalidId_throwsProductNotFoundException(){
        when(productRepository.findById(1)).thenReturn((Optional.empty()));
        ProductNotFoundException exception =
                assertThrows(ProductNotFoundException.class,
                        ()->productQueryHandler.execute(1));
        assertEquals("Product Not Found", exception.getSimpleResponse().getMessage());
    }
}
