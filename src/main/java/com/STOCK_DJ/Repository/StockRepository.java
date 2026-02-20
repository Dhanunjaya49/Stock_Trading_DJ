package com.STOCK_DJ.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.STOCK_DJ.model.Stock;


@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
	
	Optional<Stock> findBySymbol(String symbol);
	boolean existsBySymbol(String symbol);

}
