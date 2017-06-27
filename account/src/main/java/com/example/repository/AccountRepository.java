package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer>{

	List<AccountEntity> findByName(String name);
}
