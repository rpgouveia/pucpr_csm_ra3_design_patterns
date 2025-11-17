package state.quotacao;

public class Pago extends Estado {
    @Override
    public Estado arquiva() {
        // Transição: Pago -> FIM
        return new Fim();
    }

    @Override
    public String getStatus() {
        return "Pago";
    }
}