package com.imudges.repository;


import com.imudges.model.ShoppingcarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/10/29.
 */
@Repository
public interface ShopCarRepository  extends JpaRepository<ShoppingcarEntity,Integer> {
    public ShoppingcarEntity findByCookie(String cookie);
}
