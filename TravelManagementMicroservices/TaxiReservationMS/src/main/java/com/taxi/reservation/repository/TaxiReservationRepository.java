package com.taxi.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.reservation.bean.TaxiReservation;

@Repository
public interface TaxiReservationRepository extends JpaRepository<TaxiReservation, Integer> {

}
