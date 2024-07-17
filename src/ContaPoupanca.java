public class ContaPoupanca extends Conta {

    private static final double TAXA_RENDIMENTO = 0.01;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void renderJuros() {
        double rendimento = saldo * TAXA_RENDIMENTO;
        saldo += rendimento;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupanca ===");
        super.imprimirInfosComuns();
    }
}
