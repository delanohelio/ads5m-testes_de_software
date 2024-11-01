package br.edu.ifpe.leilao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeilaoTest {

    private Leilao leilao;
    private Usuario usuario1;
    private Usuario usuario2;

    @Before
    public void setup() {
        leilao = new Leilao("Leilão de um dia com Diogo na feira de Prazeres");
        usuario1 = new Usuario("Lucas Patrick");
        usuario2 = new Usuario("BYanka Mirella");
    }

    @Test
    public void podeProporDoisLancesPorPessoasDiferentes() {
        leilao.propoe(new Lance(usuario1, 1000.0));
        leilao.propoe(new Lance(usuario2, 1500.0));
        assertEquals(2, leilao.getLances().size());
    }

    @Test
    public void podeProporDoisLancesPelaMesmaPessoaNaoEmSequecia() {
        leilao.propoe(new Lance(usuario1, 1000.0));
        leilao.propoe(new Lance(usuario2, 1500.0));
        leilao.propoe(new Lance(usuario1, 1550.0));
        assertEquals(3, leilao.getLances().size());
    }

    @Test
    public void naoPodeProporDoisLancesEmSequencia() {
        leilao.propoe(new Lance(usuario1, 1000.0));
        leilao.propoe(new Lance(usuario1, 1500.0));
        assertEquals(1, leilao.getLances().size());
        assertEquals(1000.0, leilao.getLances().getFirst().getValor(), 0.00001);
    }

    @Test
    public void naoPodeTerMaisQueCincoLancesPorUsuario() {
        leilao.propoe(new Lance(usuario1, 1.0));
        leilao.propoe(new Lance(usuario2, 2.0));
        leilao.propoe(new Lance(usuario1, 3.0));
        leilao.propoe(new Lance(usuario2, 4.0));
        leilao.propoe(new Lance(usuario1, 5.0));
        leilao.propoe(new Lance(usuario2, 6.0));
        leilao.propoe(new Lance(usuario1, 7.0));
        leilao.propoe(new Lance(usuario2, 8.0));
        leilao.propoe(new Lance(usuario1, 9.0));
        leilao.propoe(new Lance(usuario2, 10.0));

        leilao.propoe(new Lance(usuario1, 11.0));

        assertEquals(10, leilao.getLances().size());
        assertEquals(10.0, leilao.getLances().getLast().getValor(), 0.00001);
    }

}
