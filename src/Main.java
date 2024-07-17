import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cliente mariaHelena = new Cliente();
        mariaHelena.setNome("Maria Helena");
        mariaHelena.setCpf("123.456.789-00");
        mariaHelena.setEndereco("Rua Exemplo, 123");

        Banco banco = new Banco();
        banco.setNome("Banco Digital");

        Conta cc = new ContaCorrente(mariaHelena);
        Conta poupanca = new ContaPoupanca(mariaHelena);

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.depositar(200);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        // Simulando rendimento da poupança
        ((ContaPoupanca) poupanca).renderJuros();
        poupanca.imprimirExtrato();

        // Adicionando outro cliente
        Cliente maria = new Cliente();
        maria.setNome("Maria");
        maria.setCpf("987.654.321-00");
        maria.setEndereco("Avenida Teste, 456");

        Conta ccMaria = new ContaCorrente(maria);
        banco.adicionarConta(ccMaria);

        ccMaria.depositar(300);
        ccMaria.imprimirExtrato();

        // Buscando contas por cliente
        List<Conta> contasMariaHelena = banco.buscarContasPorCliente(mariaHelena);
        System.out.println("Contas de Maria Helena:");
        for (Conta conta : contasMariaHelena) {
            conta.imprimirExtrato();
        }

        // Buscando conta por número
        Conta contaBuscada = banco.buscarContaPorNumero(2);
        if (contaBuscada != null) {
            System.out.println("Conta encontrada:");
            contaBuscada.imprimirExtrato();
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}
