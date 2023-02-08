package br.com.alura.tdd.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Funcionario {

	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;

	public void reajustaSalario(BigDecimal reajuste) {
		this.salario = this.salario.add(reajuste);
		arredondaSalario();
	}

	private void arredondaSalario(){
		this.salario = this.salario.setScale(2, RoundingMode.HALF_UP);
	}
}