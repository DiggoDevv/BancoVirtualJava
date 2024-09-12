package BancoVirtual;

public abstract class Conta implements iConta{
    private static final int AGENCIA_PADRAO = 0;

    private static int SEQUENCIAL = 1;
    //gerar agencia e numero de forma automatica

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    //protected para a classe filha conseguir acessar

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.SEQUENCIAL++;
        this.cliente = cliente;
    }
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s ", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d, ", this.agencia));
        System.out.println(String.format("Numero: %d, ", this.numero));
        System.out.println(String.format("Saldo: %.2f, ", this.saldo));
    }

    @Override
        public void sacar ( double valor) {
        try {
            if (saldo >= valor) {
                saldo -= valor;
            } else {
                throw new IllegalArgumentException("Saldo insuficiente");
            }
        } catch (IllegalArgumentException e){
            System.out.println("Erro ao tentar sacar: " + e.getMessage());
        }
    }

    @Override
    public void depositar(double valor) {
        try {
            if (valor > 0) {
                saldo += valor;
            } else {
                throw new IllegalArgumentException("O valor do depósito precisa ser maior que 0");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Erro ao tentar depositar: " + e.getMessage());
        }
    }
    @Override
    public void transferir(double valor, Conta contaDestino) {
        double saldoOriginal = this.saldo;
        if (saldoOriginal < valor){
            System.out.println("saldo insuficiente para fazer a tranferencia");
        } else {
            this.sacar(valor);
            this.depositar(valor);
        }
    }
}
