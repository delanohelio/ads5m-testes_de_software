package br.edu.ifpe.leilao;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AvaliadorTest {

    private Usuario joao;
    private Usuario vitor;
    private Usuario maria;
    private Leilao leilao;
    private Avaliador leiloeiro;

    @Before
    public void criadorDeLeilao(){
        joao = new Usuario("Joao");
        vitor = new Usuario("Vitor");
        maria = new Usuario("Maria");
        leilao = new Leilao("Playstation 5 Novo");
        leiloeiro = new Avaliador();
    }

    @Test
    public void deveSaberQualOMaiorTest() {
        leilao.propoe(new Lance(joao,50.0));
        leilao.propoe(new Lance(vitor,100.0));
        leilao.propoe(new Lance(maria,250.0));

        leiloeiro.avalia(leilao);

        double valorMaiorEsperado = 250.0;
        assertEquals(valorMaiorEsperado, leiloeiro.getMaiorLance(),0.00001);
    }

    @Test
    public void deveSaberQualOMenorTest() {
        leilao.propoe(new Lance(joao,50.0));
        leilao.propoe(new Lance(vitor,100.0));

        leiloeiro.avalia(leilao);

        double valorMenorEsperado = 50.0;
        assertEquals(valorMenorEsperado, leiloeiro.getMenorLance(),0.00001);
        // mesmo assert mas com hamcrest
        assertThat(leiloeiro.getMenorLance(), equalTo(valorMenorEsperado));
    }

    @Test
    public void deveEncontrarOsTresMaioresLancesTest() {
        leilao.propoe(new Lance(joao, 50.0));
        leilao.propoe(new Lance(vitor, 100.0));
        leilao.propoe(new Lance(maria, 250.0));

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());

    }
}
