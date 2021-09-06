package com.keyes.mattel.repository;

import com.keyes.mattel.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query(value = "SELECT * FROM REQUEST WHERE created_at >= (now() - INTERVAL 30 DAY) AND status != 'PENDING'", nativeQuery = true)
    List<Request> findAllWithDateBefore();

    @Query(value = "SELECT * FROM REQUEST WHERE status = 'PENDING'", nativeQuery = true)
    List<Request> findAllByPending();
}
