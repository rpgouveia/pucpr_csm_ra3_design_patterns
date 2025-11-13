package composite.categoria;

import composite.modelo.Elemento;
import composite.modelo.MyException;

public class Teste {
    private static Elemento criarInstancias() {
        // categoria raiz
        Elemento raiz = new CategoriaRaiz("CRaiz");

        // categorias
        Elemento cat_comestivel = new Categoria("comestivel");
        Elemento cat_diversos = new Categoria("diversos");
        Elemento cat_proteina_animal = new Categoria("proteinaAnimal");

        // categorias folha
        Elemento cat_cereal = new CategoriaFolha("cereal");
        Elemento cat_bebida = new CategoriaFolha("bebida");
        Elemento cat_defumado = new CategoriaFolha("defumado");
        Elemento cat_carne = new CategoriaFolha("carne");
        Elemento cat_limpeza = new CategoriaFolha("limpeza");

        // produtos
        Elemento p1 = new Cereal("P1");
        Elemento p2 = new Cereal("P2");
        Elemento p3 = new Cereal("P3");

        Elemento p4 = new Bebida("P4");
        Elemento p5 = new Bebida("P5");
        Elemento p6 = new Bebida("P6");

        Elemento p7 = new Defumado("P7");
        Elemento p8 = new Defumado("P8");
        Elemento p9 = new Defumado("P9");

        Elemento p10 = new Carne("P10");
        Elemento p11 = new Carne("P11");
        Elemento p12 = new Carne("P12");

        Elemento l1 = new Limpeza("L1");
        Elemento l2 = new Limpeza("L2");
        Elemento l3 = new Limpeza("L3");

        try {
            cat_cereal.adicionar(p1);
            cat_cereal.adicionar(p2);
            cat_cereal.adicionar(p3);

            cat_bebida.adicionar(p4);
            cat_bebida.adicionar(p5);
            cat_bebida.adicionar(p6);

            cat_defumado.adicionar(p7);
            cat_defumado.adicionar(p8);
            cat_defumado.adicionar(p9);

            cat_carne.adicionar(p10);
            cat_carne.adicionar(p11);
            cat_carne.adicionar(p12);

            cat_limpeza.adicionar(l1);
            cat_limpeza.adicionar(l2);
            cat_limpeza.adicionar(l3);

            cat_diversos.adicionar(cat_cereal);
            cat_diversos.adicionar(cat_bebida);

            cat_proteina_animal.adicionar(cat_defumado);
            cat_proteina_animal.adicionar(cat_carne);

            cat_comestivel.adicionar(cat_diversos);
            cat_comestivel.adicionar(cat_proteina_animal);

            raiz.adicionar(cat_comestivel);
            raiz.adicionar(cat_limpeza);

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

            Elemento limpeza = new Limpeza("L4");
            Elemento filho = raiz.consultar("limpeza");

            filho.adicionar(limpeza);
            filho.listar(0);

            raiz.excluir("limpeza");

            filho = raiz.consultar("CRaiz");
            filho.listar(0);
            filho = raiz.excluir("limpeza");
            filho = raiz.consultar("limpeza");

        } catch(MyException e){
            System.out.println( e.getMessage() );
        }

    }
}
