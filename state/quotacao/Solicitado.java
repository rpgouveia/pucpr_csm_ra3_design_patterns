package state.quotacao;

public class Solicitado extends Estado {
    @Override
    public Estado cotacao() {
        // Transição: Solicitado -> Cotado
        return new Cotado();
    }

    @Override
    public String getStatus() {
        return "Solicitado";
    }
}