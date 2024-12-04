package com.ib.flowsync;

import com.ib.flowsync.entity.Product;
import com.ib.flowsync.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @BeforeEach
    public void setUp() {

    }

    // Verifies that a valid product is correctly created
    @Test
    public void createValidProductTest() throws Exception {
    }

    // Verifies that the creation fails with invalid data
    @Test
    public void createInvalidProductTest() throws Exception {
    }

    // Checks behavior when required fields are missing
    @Test
    public void createPartialProductTest() throws Exception {
    }

    // Checks that creation fails when an identical product already exists
    @Test
    public void createDuplicateProductTest() throws Exception {
    }

    // Verifies the creation with limit values
    @Test
    public void createProductWithDataLimitsTest() throws Exception {
    }

    @Test
    public void readAllProductsTest() throws Exception {
        when(productService.getAllProduct()).thenReturn(List.of());

        this.mockMvc.perform(get("/products")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
    }

    @Test
    public void readExistingProductByIdTest() throws Exception {
        when(productService.getProductById(1)).thenReturn(new Product());

        this.mockMvc.perform(get("/products/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":null,\"name\":null,\"price\":null,\"vat\":null,\"category\":null,\"supplier\":null}")));
    }

    @Test
    public void readInexistingProductByIdTest() throws Exception {
        when(productService.getProductById(2)).thenReturn(null);

        this.mockMvc.perform(get("/products/2")).andDo(print()).andExpect(status().isNotFound());
    }

    // Verifies that an existing product is updated correctly with valid data
    @Test
    public void updateExistingProductTest() throws Exception {
    }

    // Verifies that attempting to update a non-existent product fails correctly
    @Test
    public void updateInexistingProductTest() throws Exception {
    }

    // Verifies that update fails when invalid fields are provided
    @Test
    public void updateProductWithInvalidFieldsTest() throws Exception {
    }

    // Checks that only part of the fields are updated correctly
    @Test
    public void updateProductPartiallyTest() throws Exception {
    }

    // Checks behavior when update conflicts with another resource
    @Test
    public void updateProductWithConflictTest() throws Exception {
    }

    // Verifies that an existing product is deleted correctly
    @Test
    public void deleteExistingProductTest() throws Exception {
    }

    // Verifies that the attempt to delete a non-existent product fails
    @Test
    public void deleteInexistingProductTest() throws Exception {
    }

    // Checks that the deletion fails if the user or process does not have the necessary rights
    @Test
    public void deleteProductWithNoPermissionsTest() throws Exception {
    }
}
