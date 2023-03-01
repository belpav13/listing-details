package com.pavel.listingdetails.controller;

import com.pavel.listingdetails.helper.CSVHelper;
import com.pavel.listingdetails.message.ResponseMessage;
import com.pavel.listingdetails.model.DetailsEntity;
import com.pavel.listingdetails.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@SpringBootTest
@AutoConfigureMockMvc
public class CSVControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void restAPIShouldReturnDetails() throws Exception {

        this.mockMvc.perform(get("/detailsEntity").param())
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(""));
    }

}

