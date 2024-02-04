package com.fare.calculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fare.calculation.bean.TaxiFare;

@Repository
public interface TaxiFareRepository extends JpaRepository<TaxiFare, Integer> {

	@Query("select f from TaxiFare f where f.pickupLocation = :pickupLocation and f.destination = :destination and f.passengerNum = :passengerNum")
	public TaxiFare getTaxiFare(@Param("pickupLocation") String pickupLocation, @Param("destination") String destination,
			@Param("passengerNum") int passengerNum);
}
