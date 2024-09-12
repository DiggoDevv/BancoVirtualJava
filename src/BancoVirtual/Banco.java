package BancoVirtual;

import java.util.List;

public class Banco {
    private String nome;

    public void setContaList(List<Conta> contaList) {
        this.contaList = contaList;
    }

    public List<Conta> getContaList() {
        return contaList;
    }

    private List<Conta> contaList;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
