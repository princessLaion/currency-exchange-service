package com.lrp.currency_exchange_service.repository;

import com.lrp.currency_exchange_service.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository <CurrencyExchange, Long> {


    CurrencyExchange findByFromCurrencyAndToCurrency (String fromCurrency, String toCurrency);
}
