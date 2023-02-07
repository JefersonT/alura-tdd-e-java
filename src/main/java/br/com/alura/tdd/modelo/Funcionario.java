package br.com.alura.tdd.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Funcionario {

	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;

}