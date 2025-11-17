package state.quotacao;

/**
 * Estado terminal. Nenhuma transição sai daqui.
 */
public class Fim extends Estado {
    @Override
    public String getStatus() {
        return "FIM";
    }
}