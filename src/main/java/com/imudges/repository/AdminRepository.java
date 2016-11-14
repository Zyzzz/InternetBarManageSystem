package com.imudges.repository;

import com.imudges.model.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/11/14.
 */
@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Integer> {
    public AdminEntity findByAdminname(String adminName);
}
