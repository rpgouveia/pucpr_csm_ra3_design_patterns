package state.quotacao;

/**
 * Define a interface para todos os estados e fornece uma implementação padrão (não transacionar)
 */
public abstract class Estado {

    // Métodos de transição
    public Estado solicita() { return this; }
    public Estado cotacao() { return this; }
    public Estado encomenda() { return this; }
    public Estado entrega() { return this; }
    public Estado paga() { return this; }
    public Estado cancela() { return this; }
    public Estado rejeita() { return this; }
    public Estado arquiva() { return this; }

    /**
     * Retorna o nome do estado atual para os testes
     */
    public abstract String getStatus();
}