package com.pet.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pet.clinic.bean.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
	
	@Query("select o from Owner o where o.email = :email")
	public Owner findByEmail(@Param("email") String email);

	@Query("select o from Owner o where o.phone = :phone")
	public Owner findByPhone(@Param("phone") String phone);

}
