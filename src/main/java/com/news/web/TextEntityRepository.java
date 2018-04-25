package com.news.web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextEntityRepository extends JpaRepository<TextEntity, Integer> {

}
