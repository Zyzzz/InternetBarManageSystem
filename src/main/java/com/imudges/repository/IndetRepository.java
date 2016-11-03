package com.imudges.repository;

import com.imudges.model.IndentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016/11/3.
 */
public interface IndetRepository extends JpaRepository<IndentEntity,Integer> {
}
