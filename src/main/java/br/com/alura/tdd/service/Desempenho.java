package br.com.alura.tdd.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public enum Desempenho {
    A_DESEJAR(new BigDecimal("0.03")),
    BOM(new BigDecimal("0.15")),
    OTIMO(new BigDecimal("0.20"));

    private final BigDecimal percentual;
}
