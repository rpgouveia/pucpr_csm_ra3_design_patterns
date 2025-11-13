package composite.portfolio;

import composite.modelo.Folha;

public class Tarefa extends Folha {
    public Tarefa(String nm){
        super(nm);
    }

    public void listar(int nivel){
        super.listar(nivel);
        System.out.println("Tarefa: " + this.nome);
    }
}
