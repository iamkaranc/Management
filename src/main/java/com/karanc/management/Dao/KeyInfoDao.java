package com.karanc.management.Dao;


import com.karanc.management.Entity.KeyInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface KeyInfoDao extends JpaRepository<KeyInfo,Long> {

    @Query("select k from KeyInfo k where k.isBlocked = 0 order by k.id asc limit 1")
    KeyInfo getAvailableKey();

    @Query("select k from KeyInfo k where k.name =:name ")
    KeyInfo getKey(@Param("name") String key);

//    @Modifying
//    @Query("delete from KeyInfo k where k.name =?name ")
    void deleteByName(String key);
}
