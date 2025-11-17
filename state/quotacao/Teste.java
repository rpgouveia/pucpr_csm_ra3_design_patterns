package state.quotacao;

public class Teste {

    public static void main(String[] args) {
        // Cenário Principal
        System.out.println("Cenário Principal");

        Pedido p1 = new Pedido();

        // O estado inicial é Solicitado
        String str = p1.solicita();
        System.out.println("p1-Estado: " + str); // deve mostrar "p1-Estado: Solicitado"

        str = p1.cotacao(); // [cite: 59]
        System.out.println("p1-Estado: " + str); // deve mostrar "p1-Estado: Cotado"

        // Chamada repetida não deve mudar o estado
        str = p1.cotacao();
        System.out.println("p1-Estado: " + str); // deve mostrar "p1-Estado: Cotado"

        str = p1.encomenda();
        System.out.println("p1-Estado: " + str); // deve mostrar "p1-Estado: Encomendado"

        str = p1.entrega();
        System.out.println("p1-Estado: " + str); // deve mostrar "p1-Estado: Faturado"

        str = p1.paga();
        System.out.println("p1-Estado: " + str); // deve mostrar "p1-Estado: Pago"

        str = p1.arquiva();
        System.out.println("p1-Estado: " + str); // deve mostrar "p1-Estado: FIM"

        System.out.println();

        // Cenários Adicionais
        testeFluxoRejeicao();
        testeFluxoCancelamento();
        testeTransicoesIlegais();
    }

    public static void testeFluxoRejeicao() {
        System.out.println("Teste Fluxo de Rejeição");
        Pedido p = new Pedido(); // Inicia Solicitado

        System.out.println("1. Estado inicial: " + p.solicita()); // Solicitado
        System.out.println("2. Cotar: " + p.cotacao()); // Cotado

        // Rejeitar ao invés de Encomendar
        System.out.println("3. Rejeitar: " + p.rejeita()); // Rejeitado

        // Tentar encomendar agora, não deve funcionar, pois está Rejeitado
        System.out.println("4. Tentar Encomendar (inválido): " + p.encomenda()); // Rejeitado

        System.out.println("5. Arquivar: " + p.arquiva()); // FIM
        System.out.println();
    }

    public static void testeFluxoCancelamento() {
        System.out.println("Teste Fluxo de Cancelamento");
        Pedido p = new Pedido();

        p.solicita();
        p.cotacao();
        System.out.println("1. Estado atual: " + p.encomenda()); // Encomendado

        // Cancelar ao invés de Entregar
        System.out.println("2. Cancelar: " + p.cancela()); // Cancelado

        // Tentar entregar agora, não deve funcionar
        System.out.println("3. Tentar Entregar (inválido): " + p.entrega()); // Cancelado

        System.out.println("4. Arquivar: " + p.arquiva()); // FIM
        System.out.println();
    }

    public static void testeTransicoesIlegais() {
        System.out.println("Teste Transições Ilegais");
        Pedido p = new Pedido(); // Solicitado

        // Tentar pagar direto do início
        System.out.println("1. Tentar Pagar (estando Solicitado): " + p.paga());
        // Esperado: Solicitado, não muda

        p.solicita();
        p.cotacao(); // Agora está Cotado

        // Tentar entregar sem encomendar
        System.out.println("2. Tentar Entregar (estando Cotado): " + p.entrega());
        // Esperado: Cotado, não muda

        System.out.println();
    }
}