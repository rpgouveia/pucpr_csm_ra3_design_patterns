package composite.universidade;

import composite.modelo.Folha;

public class Laboratorio extends Folha {
    public Laboratorio(String nm){
        super(nm);
    }

    public void listar(int nivel){
        super.listar(nivel);
        System.out.println("Laboratório: " + this.nome);
    }
}
