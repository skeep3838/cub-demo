package com.cub.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cub.demo.entity.CurrencyEneity;

public interface CurrencyRepository extends JpaRepository<CurrencyEneity, Integer> {

}
