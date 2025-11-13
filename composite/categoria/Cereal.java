package composite.categoria;

import composite.modelo.Folha;

public class Cereal extends Folha {
    public Cereal(String nm){
        super(nm);
    }

    public void listar(int nivel){
        super.listar(nivel);
        System.out.println("Cereal: " + this.nome);
    }
}
