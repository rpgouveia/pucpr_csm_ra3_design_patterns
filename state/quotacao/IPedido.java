package state.quotacao;

/**
 * Interface para o Pedido, definindo as ações que podem alterar seu estado
 */
public interface IPedido {
    String solicita();
    String cotacao();
    String encomenda();
    String entrega();
    String paga();
    String cancela();
    String rejeita();
    String arquiva();
}