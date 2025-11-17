package state.quotacao;

public class Cotado extends Estado {
    @Override
    public Estado encomenda() {
        // Transição: Cotado -> Encomendado
        return new Encomendado();
    }

    @Override
    public Estado rejeita() {
        // Transição: Cotado -> Rejeitado
        return new Rejeitado();
    }

    @Override
    public String getStatus() {
        return "Cotado";
    }
}