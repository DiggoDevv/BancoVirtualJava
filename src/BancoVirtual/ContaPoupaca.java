package BancoVirtual;

public class ContaPoupaca extends Conta {

    public ContaPoupaca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato conta poupança: ");
        super.imprimirInfosComuns();
    }
}
