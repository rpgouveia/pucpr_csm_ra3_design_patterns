package state.quotacao;

/**
 * Classe de Pedido
 * Mantém o estado atual e delega as chamadas para o objeto de estado
 */
public class Pedido implements IPedido {

    private Estado estado;

    public Pedido() {
        // O estado inicial é definido no construtor
        this.estado = new Solicitado();
    }

    @Override
    public String solicita() {
        this.estado = this.estado.solicita();
        return this.estado.getStatus();
    }

    @Override
    public String cotacao() {
        this.estado = this.estado.cotacao();
        return this.estado.getStatus();
    }

    @Override
    public String encomenda() {
        this.estado = this.estado.encomenda();
        return this.estado.getStatus();
    }

    @Override
    public String entrega() {
        this.estado = this.estado.entrega();
        return this.estado.getStatus();
    }

    @Override
    public String paga() {
        this.estado = this.estado.paga();
        return this.estado.getStatus();
    }

    @Override
    public String cancela() {
        this.estado = this.estado.cancela();
        return this.estado.getStatus();
    }

    @Override
    public String rejeita() {
        this.estado = this.estado.rejeita();
        return this.estado.getStatus();
    }

    @Override
    public String arquiva() {
        this.estado = this.estado.arquiva();
        return this.estado.getStatus();
    }
}