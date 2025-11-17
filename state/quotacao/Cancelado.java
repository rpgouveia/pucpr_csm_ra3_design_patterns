package state.quotacao;

public class Cancelado extends Estado {
    @Override
    public Estado arquiva() {
        // Transição: Cancelado -> FIM
        return new Fim();
    }

    @Override
    public String getStatus() {
        return "Cancelado";
    }
}