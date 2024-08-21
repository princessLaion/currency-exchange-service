package com.lrp.currency_exchange_service.controller;

import com.lrp.currency_exchange_service.model.CurrencyExchange;
import com.lrp.currency_exchange_service.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final CurrencyExchangeRepository currencyExchangeRepository;
    private final Environment environment;

    @GetMapping("/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String fromCurrency,
            @PathVariable String toCurrency) {

        CurrencyExchange currencyExchange = currencyExchangeRepository
                .findByFromCurrencyAndToCurrency(
                    fromCurrency,
                    toCurrency
        );

        if (currencyExchange == null) {
            throw new RuntimeException(String.format("Unable to find records from %s, to %s", fromCurrency, toCurrency));
        }
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;

        //Simple
//        return new CurrencyExchange(
//                1,
//                "USD",
//                "INR",
//                BigDecimal.TEN,
//                environment.getProperty("local.server.port")
//        );
    }
}
