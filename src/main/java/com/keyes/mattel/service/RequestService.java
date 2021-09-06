package com.keyes.mattel.service;

import com.keyes.mattel.Status;
import com.keyes.mattel.exception.RequestNotFoundException;
import com.keyes.mattel.model.Request;
import com.keyes.mattel.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;

    public List<Request> getAllRequestsFromLastThirtyDays() {
        return requestRepository.findAllWithDateBefore();
    }

    public List<Request> getAllPending() {
        return requestRepository.findAllByPending();
    }

    public Request getRequestById(long id) {
        return requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException("No Request found with id + " + id));
    }

    public Request createRequest(Request request) {
        request.setCreatedAt(Instant.now());
        return requestRepository.save(request);
    }

    public void setStatus(long id, Status status) {
         requestRepository.findById(id).map(request -> {
             request.setStatus(status);
             return requestRepository.save(request);
         }).orElseThrow(() -> new RequestNotFoundException("No Request found with id + " + id));
    }
}
