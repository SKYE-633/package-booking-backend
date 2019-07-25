package com.oocl.packagebooking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.packagebooking.entity.PackageItem;
import com.oocl.packagebooking.service.PackageItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PackageItemController.class)
public class PackageItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PackageItemService packageItemService;

    @Test
    void should_save_package_item() throws Exception {
        PackageItem packageItem = createPackageItem();

        when(packageItemService.save(ArgumentMatchers.any())).thenReturn(packageItem);

        mvc.perform(post("/items")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(packageItem)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    void should_return_list_package_item() throws Exception {
        List<PackageItem> items = Arrays.asList(createPackageItem(),createPackageItem());

        when(packageItemService.findAll()).thenReturn(items);

        mvc.perform(get("/items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void should_return_list_package_item_filter_by_status() throws Exception {
        List<PackageItem> items = Arrays.asList(createPackageItem(),createPackageItem());

        when(packageItemService.findByStatus(anyString())).thenReturn(items);

        mvc.perform(get("/items/is_received"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    PackageItem createPackageItem(){
        PackageItem packageItem = new PackageItem();
        packageItem.setId(1);
        packageItem.setReceiverName("Smith");
        packageItem.setReceiverPhone("13312341234");
        packageItem.setStatus("DSADA");
        return packageItem;
    }

}
