package ru.boronin.onlineshop.controllers;

import com.sun.xml.messaging.saaj.util.Base64;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.boronin.onlineshop.entities.Image;
import ru.boronin.onlineshop.repositories.ImagesRepository;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImagesRepository imagesRepository;

  @GetMapping("/images/{id}")
      public ResponseEntity<?> findImageById(@PathVariable Long id) {
     Image image = imagesRepository.findById(id).orElse(null);
      final HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.parseMediaType(image.getContentType()));
      return new ResponseEntity(new InputStreamResource(new ByteArrayInputStream(image.getImageBytes())),headers, HttpStatus.OK);

    }

}

