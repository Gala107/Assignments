package com.taxi.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.reservation.bean.TaxiInfo;

@Repository
public interface TaxiInfoRepository extends JpaRepository<TaxiInfo, Integer> {

}
