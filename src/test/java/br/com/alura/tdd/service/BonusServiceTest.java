package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService bonusService = new BonusService();

//        // 1ª Forma de Testar uma Exception
//        assertThrows(IllegalArgumentException.class,
//                () -> bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal(25000))));

        // 2ª Forma de Testar uma Exception
        try {
            bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal(25000)));
            fail("Não deu a Exception esperada!");
        }catch (Exception e){
            // Validar Mensagem da Exception (OPCIONAL)
            assertEquals("Funcionário com salário maior do que R$1000 nao pode receber bonus!", e.getMessage());

        }

    }

    @Test
    void bonusDeveriaSerDezPorcentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal(2500)));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorcentoParaSalarioDeExatamenteDezMil() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal(10000)));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}