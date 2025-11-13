package interpretador.prefixada;

import java.util.ArrayList;

public class Fatorial extends Operador {
    public Fatorial(ArrayList<Expressao> elemento) {
        super(elemento);
    }

    @Override
    public char simbolo() { return '!'; }

    @Override
    public double resolva() {
        // fatorial opera sobre apenas um elemento
        if (this.elemento.isEmpty()) {
            return 1.0;
        }

        // pegar o primeiro (e único) elemento
        double valor = this.elemento.get(0).resolva();

        return calcularFatorial((int) valor);
    }

    private double calcularFatorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fatorial não definido para números negativos");
        }

        if (n == 0 || n == 1) {
            return 1.0;
        }

        double resultado = 1.0;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }

        return resultado;
    }
}