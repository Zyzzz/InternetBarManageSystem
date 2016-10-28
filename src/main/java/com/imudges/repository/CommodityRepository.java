package com.imudges.repository;

import com.imudges.model.CommodityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/10/28.
 */
@Repository
public interface CommodityRepository extends JpaRepository<CommodityEntity,Integer> {
}
