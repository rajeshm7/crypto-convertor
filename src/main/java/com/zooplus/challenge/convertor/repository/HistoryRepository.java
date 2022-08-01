package com.zooplus.challenge.convertor.repository;

import com.zooplus.challenge.convertor.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findByUsername(String username);

}
