package composite.universidade;

import composite.modelo.Folha;

public class Sala extends Folha {
    public Sala(String nm){
        super(nm);
    }

    public void listar(int nivel){
        super.listar(nivel);
        System.out.println("Sala: " + this.nome);
    }
}
