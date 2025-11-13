package composite.universidade;

import composite.modelo.Folha;

public class Auditorio extends Folha {
    public Auditorio(String nm){
        super(nm);
    }

    public void listar(int nivel){
        super.listar(nivel);
        System.out.println("Sala: " + this.nome);
    }
}
