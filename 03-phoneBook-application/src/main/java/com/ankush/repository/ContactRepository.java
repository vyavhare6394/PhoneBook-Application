package com.ankush.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ankush.entity.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Serializable> {
	

}
