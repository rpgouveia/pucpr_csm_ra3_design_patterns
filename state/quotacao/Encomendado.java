package state.quotacao;

public class Encomendado extends Estado {
    @Override
    public Estado entrega() {
        // Transição: Encomendado -> Faturado
        return new Faturado();
    }

    @Override
    public Estado cancela() {
        // Transição: Encomendado -> Cancelado
        return new Cancelado();
    }

    @Override
    public String getStatus() {
        return "Encomendado";
    }
}