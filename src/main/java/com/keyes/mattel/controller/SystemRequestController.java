package com.keyes.mattel.controller;

import com.keyes.mattel.Status;
import com.keyes.mattel.model.Request;
import com.keyes.mattel.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/request")
public class SystemRequestController {

    private final RequestService requestService;

    @GetMapping
    public ResponseEntity<List<Request>> getLastThirtyDaysRequestsNotPending() {
        return new ResponseEntity<List<Request>>(requestService.getAllRequestsFromLastThirtyDays(), OK);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Request>> getAllPending() {
        return new ResponseEntity<List<Request>>(requestService.getAllPending(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable long id) {
        return new ResponseEntity<Request>(requestService.getRequestById(id), OK);
    }

    @PostMapping
    public ResponseEntity<Object> createRequest(@Valid @RequestBody Request request) {
        Request savedRequest =  requestService.createRequest(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRequest.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity<Object> updateStatus(@PathVariable long id, @PathVariable Status status) {
        requestService.setStatus(id, status);
        return new ResponseEntity<>(OK);
    }

}
