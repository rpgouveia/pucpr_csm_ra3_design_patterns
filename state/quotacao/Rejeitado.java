package state.quotacao;

public class Rejeitado extends Estado {
    @Override
    public Estado arquiva() {
        // Transição: Rejeitado -> FIM
        return new Fim();
    }

    @Override
    public String getStatus() {
        return "Rejeitado";
    }
}