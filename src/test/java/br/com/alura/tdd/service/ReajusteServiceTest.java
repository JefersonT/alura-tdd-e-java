package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService reajuste;
    private Funcionario funcionario;

    @BeforeEach // Executa esse método antes de qualquer outro metodo
    public void inicializar(){
        System.out.println("Inicio");
        reajuste = new ReajusteService();
        funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @AfterEach // Executa este método depois de cada metodo
    public void finalizar(){
        System.out.println("Fim");
    }

    @BeforeAll // Executa esse metodo uma vez, antes de todos
    public static void antesDeTodos(){
        System.out.println("Antes de Todos");
    }

    @AfterAll // Executa esse metodo uma vez, depois de todos
    public static void depoisDeTodos(){
        System.out.println("Depois de Todos");
    }

    @Test
    public void reajusteDeveriaSerDeTresPorcentoParaDesempenhoADesejar(){
        reajuste.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoParaDesempenhoBom(){
        reajuste.concederReajuste(funcionario, Desempenho.BOM);

        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeVintePorcentoParaDesempenhoOtimo(){
        reajuste.concederReajuste(funcionario, Desempenho.OTIMO);

        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
