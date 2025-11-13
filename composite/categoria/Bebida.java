package composite.categoria;

import composite.modelo.Folha;

public class Bebida extends Folha {
    public Bebida(String nm){
        super(nm);
    }

    public void listar(int nivel){
        super.listar(nivel);
        System.out.println("Bebida: " + this.nome);
    }
}
