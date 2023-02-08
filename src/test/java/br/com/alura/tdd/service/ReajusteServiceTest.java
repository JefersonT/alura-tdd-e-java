package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerDeTresPorcentoParaDesempenhoADesejar(){
        ReajusteService reajuste = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
        reajuste.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoParaDesempenhoBom(){
        ReajusteService reajuste = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
        reajuste.concederReajuste(funcionario, Desempenho.BOM);

        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeVintePorcentoParaDesempenhoOtimo(){
        ReajusteService reajuste = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
        reajuste.concederReajuste(funcionario, Desempenho.OTIMO);

        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
