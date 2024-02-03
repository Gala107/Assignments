package com.taxi.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taxi.reservation.bean.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query("select * from Client c where c.email = :email")
	public Client findByEmail(@Param("email") String email);
	
	@Query("select * from Client c where c.phone = :phone")
	public Client findByPhone(@Param("phone") String phone);
}
