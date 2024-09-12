package BancoVirtual;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Rodrigo");
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria");

        Conta cc = new ContaCorrente(cliente1);
        Conta poupanca = new ContaPoupaca(cliente2);


        cc.depositar(100);
        cc.transferir(150, poupanca);
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
