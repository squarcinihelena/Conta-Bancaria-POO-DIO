public class ContaCorrente extends Conta {

    private static final double TAXA_OPERACAO = 0.10;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        double valorSaque = valor + TAXA_OPERACAO;
        if (valorSaque <= saldo) {
            saldo -= valorSaque;
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        double valorTransferencia = valor + TAXA_OPERACAO;
        if (valorTransferencia <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }
}
