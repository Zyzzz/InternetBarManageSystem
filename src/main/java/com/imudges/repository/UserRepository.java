package com.imudges.repository;

import com.imudges.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/10/23.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    public List<UserEntity> findByPassword(String password);
    //public List<UserEntity> findByNickname(String nickname);
    public List<UserEntity> findByEmailAndPassword(String email,String password);
}
