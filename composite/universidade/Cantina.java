package composite.universidade;

import composite.modelo.Folha;

public class Cantina extends Folha {
    public Cantina(String nm){
        super(nm);
    }

    public void listar(int nivel){
        super.listar(nivel);
        System.out.println("Cantina: " + this.nome);
    }
}
