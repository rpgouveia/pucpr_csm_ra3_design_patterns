package composite.portfolio;

import composite.modelo.Elemento;
import composite.modelo.MyException;

public class Teste {
    private static Elemento criarInstancias() {
        // portfolio
        Elemento raiz = new Portfolio("praiz");

        // projetos
        Elemento projeto1 = new Projeto("projeto1");
        Elemento projeto2 = new ProjetoSimples("projeto2");

        // subprojetos
        Elemento subprojeto1_1 = new Projeto("subprojeto1.1");
        Elemento subprojeto1_2 = new Projeto("subprojeto1.2");

        // atividades
        Elemento atividade1 = new Atividade("atividade1");
        Elemento atividade2 = new Atividade("atividade2");
        Elemento atividade8 = new Atividade("atividade8");
        Elemento atividade9 = new Atividade("atividade9");

        // tarefas
        Elemento t1 = new Tarefa("T1");
        Elemento t2 = new Tarefa("T2");
        Elemento t3 = new Tarefa("T3");

        Elemento t4 = new Tarefa("T4");
        Elemento t5 = new Tarefa("T5");
        Elemento t6 = new Tarefa("T6");

        Elemento t7 = new Tarefa("T7");
        Elemento t8 = new Tarefa("T8");
        Elemento t9 = new Tarefa("T9");

        Elemento t10 = new Tarefa("T10");
        Elemento t11 = new Tarefa("T11");
        Elemento t12 = new Tarefa("T12");

        Elemento ts1 = new Tarefa("TS1");
        Elemento ts2 = new Tarefa("TS2");
        Elemento ts3 = new Tarefa("TS3");

        try {
            atividade1.adicionar(t1);
            atividade1.adicionar(t2);
            atividade1.adicionar(t3);

            atividade2.adicionar(t4);
            atividade2.adicionar(t5);
            atividade2.adicionar(t6);

            atividade8.adicionar(t7);
            atividade8.adicionar(t8);
            atividade8.adicionar(t9);

            atividade9.adicionar(t10);
            atividade9.adicionar(t11);
            atividade9.adicionar(t12);

            subprojeto1_1.adicionar(atividade1);
            subprojeto1_1.adicionar(atividade2);

            subprojeto1_2.adicionar(atividade8);
            subprojeto1_2.adicionar(atividade9);

            projeto1.adicionar(subprojeto1_1);
            projeto1.adicionar(subprojeto1_2);

            projeto2.adicionar(ts1);
            projeto2.adicionar(ts2);
            projeto2.adicionar(ts3);

            raiz.adicionar(projeto1);
            raiz.adicionar(projeto2);

        } catch(MyException e){
            System.out.println( e.getMessage() );
        }

        return raiz;
    }

    public static void main(String[] args) {
        try{
            Elemento raiz = criarInstancias();
            raiz.listar(0);

            System.out.println("\n");

            Elemento ts4 = new Tarefa("TS4");
            Elemento filho = raiz.consultar("projeto2");

            filho.adicionar(ts4);
            filho.listar(0);

            raiz.excluir("projeto2");

            filho = raiz.consultar("praiz");
            filho.listar(0);
            filho = raiz.excluir("projeto2");
            filho = raiz.consultar("projeto2");

        } catch(MyException e){
            System.out.println( e.getMessage() );
        }

    }
}
