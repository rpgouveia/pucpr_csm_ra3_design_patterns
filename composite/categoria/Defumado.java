package composite.categoria;

import composite.modelo.Folha;

public class Defumado extends Folha {
    public Defumado(String nm){
        super(nm);
    }

    public void listar(int nivel){
        super.listar(nivel);
        System.out.println("Defumado: " + this.nome);
    }
}
