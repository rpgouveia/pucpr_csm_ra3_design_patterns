package composite.categoria;

import composite.modelo.Folha;

public class Limpeza extends Folha {
    public Limpeza(String nm){
        super(nm);
    }

    public void listar(int nivel){
        super.listar(nivel);
        System.out.println("Limpeza: " + this.nome);
    }
}
