package com.inventory.products.services;

import com.inventory.products.dto.ProductosDTO;
import com.inventory.products.entity.Product;
import com.inventory.products.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class ProductsServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductsService productsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProducts() {
        ProductosDTO productDTO = new ProductosDTO();
        productDTO.setNombre("Product1");
        productDTO.setDescripcion("Description1");
        productDTO.setCategoria("Category1");
        productDTO.setPreciounitario("100");
        productDTO.setPreciomasiva("120");
        productDTO.setCodigoventa("12345");
        productDTO.setStockactual("10");

        Product product = new Product();
        product.setProductoid(1L);
        product.setNombre("Product1");

        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product createdProduct = productsService.createProducts(productDTO);

        assertEquals(1L, createdProduct.getProductoid());
        assertEquals("Product1", createdProduct.getNombre());
    }

    @Test
    public void testGetProducts() {
        Product product = new Product();
        product.setProductoid(1L);
        product.setNombre("Product1");

        when(productRepository.findAll()).thenReturn(Arrays.asList(product));

        List<Product> products = productsService.getProducts();

        assertEquals(1, products.size());
        assertEquals("Product1", products.get(0).getNombre());
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setProductoid(1L);
        product.setNombre("Product1");

        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        Optional<Product> foundProduct = productsService.getProductById(1L);

        assertEquals(true, foundProduct.isPresent());
        assertEquals("Product1", foundProduct.get().getNombre());
    }
}
