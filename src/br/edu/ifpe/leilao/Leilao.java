package br.edu.ifpe.leilao;

import java.util.ArrayList;
import java.util.List;

public class Leilao {

    private String nome;
    private List<Lance> lances;

    public Leilao(String nome) {
        this.nome = nome;
        this.lances = new ArrayList<Lance>();
    }

    public String getNome() {
        return nome;
    }

    public List<Lance> getLances() {
        return lances;
    }

    public void propoe(Lance lance) {
        if (lances.isEmpty() ||
                podeDarLance(lance.getUsuario())) {
            lances.add(lance);
        }

    }

    private boolean podeDarLance(Usuario usuario) {
        return !getUltimoLance().getUsuario().equals(usuario) && getLancesDo(usuario) < 5;
    }

    private long getLancesDo(Usuario usuario) {
        return lances.stream().filter(l -> l.getUsuario().equals(usuario)).count();
    }

    private Lance getUltimoLance() {
        return lances.getLast();
    }
}
