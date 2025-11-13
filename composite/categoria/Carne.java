package composite.categoria;

import composite.modelo.Folha;

public class Carne extends Folha {
    public Carne(String nm){
        super(nm);
    }

    public void listar(int nivel){
        super.listar(nivel);
        System.out.println("Carne: " + this.nome);
    }
}
