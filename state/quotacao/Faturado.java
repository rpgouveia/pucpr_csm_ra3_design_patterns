package state.quotacao;

public class Faturado extends Estado {
    @Override
    public Estado paga() {
        // Transição: Faturado -> Pago
        return new Pago();
    }

    @Override
    public Estado arquiva() {
        // Transição: Faturado -> FIM
        return new Fim();
    }

    @Override
    public String getStatus() {
        return "Faturado";
    }
}