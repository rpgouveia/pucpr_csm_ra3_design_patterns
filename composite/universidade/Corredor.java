package composite.universidade;

import composite.modelo.Folha;

public class Corredor extends Folha {
    public Corredor(String nm) {
        super(nm);
    }

    public void listar(int nivel){
        super.listar(nivel);
        System.out.println("Corredor: " + this.nome);
    }
}
