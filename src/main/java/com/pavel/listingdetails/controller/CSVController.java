package com.pavel.listingdetails.controller;

import com.pavel.listingdetails.dto.RequestDTO;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/csv")
public class CSVController {
    @Autowired
    CSVService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @GetMapping("/detailsEntity")
    public ResponseEntity<List<DetailsEntity>> getAllDetails() {
        try {
            List<DetailsEntity> detailsEntity = fileService.getAllDetails();

            if (detailsEntity.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(detailsEntity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listings")
    public ResponseEntity<DetailsEntity> getDetailsByQuery(@RequestBody RequestDTO requestDTO) {
        try {
            List<DetailsEntity> detailsEntities = fileService.getAllDetails();

            if (detailsEntities.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            detailsEntities = detailsEntities.stream()
                    .filter(d -> d.getPrice() > requestDTO.getMinPrice())
                    .filter(d -> d.getPrice() < requestDTO.getMaxPrice())
                    .filter(d -> d.getPrice() > requestDTO.getMinMinCpm())
                    .filter(d -> d.getPrice() < requestDTO.getMaxMaxCpm())
                    .collect(Collectors.toList());

            return new ResponseEntity(detailsEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

