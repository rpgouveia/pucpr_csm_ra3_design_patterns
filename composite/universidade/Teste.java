package composite.universidade;

import composite.modelo.Elemento;
import composite.modelo.MyException;

public class Teste {
    private static Elemento criarInstancias() {

        // universidade
        Elemento curitiba = new Universidade("curitiba");

        // campus
        Elemento campus_curitiba = new Campus("curitiba");
        Elemento campus_londrina = new Campus("londrina");

        // blocos
        Elemento azul = new Bloco("azul");
        Elemento verde = new Bloco("verde");

        // andares
        Elemento primeiro = new Andar("primeiro");
        Elemento segundo = new Andar("segundo");
        Elemento terceiro = new Andar("terceiro");
        Elemento quarto = new Andar("quarto");

        // folhas
        Elemento p1 = new Corredor("P1");
        Elemento p2 = new Sala("P2");
        Elemento p3 = new Sala("P3");

        Elemento p4 = new Corredor("P4");
        Elemento p5 = new Sala("P5");
        Elemento p6 = new Laboratorio("P6");

        Elemento p7 = new Laboratorio("P7");
        Elemento p8 = new Auditorio("P8");
        Elemento p9 = new Cantina("P9");

        Elemento p10 = new Sala("P10");
        Elemento p11 = new Sala("P11");
        Elemento p12 = new Laboratorio("P12");

        Elemento l1 = new Auditorio("L1");
        Elemento l2 = new Sala("L2");
        Elemento l3 = new Laboratorio("L3");

        try {
            primeiro.adicionar(p1);
            primeiro.adicionar(p2);
            primeiro.adicionar(p3);

            segundo.adicionar(p4);
            segundo.adicionar(p5);
            segundo.adicionar(p6);

            terceiro.adicionar(p7);
            terceiro.adicionar(p8);
            terceiro.adicionar(p9);

            quarto.adicionar(p10);
            quarto.adicionar(p11);
            quarto.adicionar(p12);

            azul.adicionar(primeiro);
            azul.adicionar(segundo);

            verde.adicionar(terceiro);
            verde.adicionar(quarto);

            campus_curitiba.adicionar(azul);
            campus_curitiba.adicionar(verde);

            campus_londrina.adicionar(l1);
            campus_londrina.adicionar(l2);
            campus_londrina.adicionar(l3);

            curitiba.adicionar(campus_curitiba);
            curitiba.adicionar(campus_londrina);
        } catch(MyException e){
            System.out.println( e.getMessage() );
        }

        return curitiba;
    }

    public static void main(String[] args) {
        try{
            Elemento raiz = criarInstancias();
            raiz.listar(0);

            System.out.println("\n");

            Elemento sala = new Sala("L4");
            Elemento filho = raiz.consultar("londrina");

            filho.adicionar(sala);
            filho.listar(0);

            raiz.excluir("londrina");

            filho = raiz.consultar("curitiba");
            filho.listar(0);
            filho = raiz.excluir("londrina");
            filho = raiz.consultar("londrina");

        } catch(MyException e){
            System.out.println( e.getMessage() );
        }

    }
}
