package interpretador.prefixada;

import java.util.ArrayList;

public class TesteFatorial {
    public static void execute() {
        ArrayList<Expressao> programa = new ArrayList<Expressao>();

        // operandos
        Expressao n = new Constante(10.0);
        programa.add(n);

        Expressao c1 = new Constante(20.0);
        programa.add(c1);

        Expressao c2 = new Constante(40.0);
        programa.add(c2);

        Expressao v1 = new Variavel("v1", 10.0);
        programa.add(v1);

        Expressao v2 = new Variavel("v2", 100.0);
        programa.add(v2);

        // operações compostas

        // fat = (! n)
        // fatorial de n (10)
        ArrayList<Expressao> lfat = new ArrayList<Expressao>();
        lfat.add(n);
        Expressao fat = new Fatorial(lfat);
        programa.add(fat);

        // a = (+ c1 v1 fat)
        // adição de c1, v1 e fat
        ArrayList<Expressao> la = new ArrayList<Expressao>();
        la.add(c1);
        la.add(v1);
        la.add(fat);
        Expressao a = new Adicao(la);
        programa.add(a);

        // s = (- (+ c1 v1) v1)
        // calcula (+ c1 v1), depois subtrai v1
        ArrayList<Expressao> la_interno = new ArrayList<Expressao>();
        la_interno.add(c1);
        la_interno.add(v1);
        Expressao a_interno = new Adicao(la_interno);

        ArrayList<Expressao> ls = new ArrayList<Expressao>();
        ls.add(a_interno);
        ls.add(v1);
        Expressao s = new Subtracao(ls);
        programa.add(s);

        // d = (/ (- (+ c1 v1) v1) (+ c1 v1))
        // divisão de s por a
        ArrayList<Expressao> ld = new ArrayList<Expressao>();
        ld.add(s);
        ld.add(a_interno); // reutiliza (+ c1 v1)
        Expressao d = new Divisao(ld);
        programa.add(d);

        // m = (* (+ c1 v1) (- (+ c1 v1) v1))
        // multiplicação de a por s
        ArrayList<Expressao> lm = new ArrayList<Expressao>();
        lm.add(a_interno); // reutiliza (+ c1 v1)
        lm.add(s);
        Expressao m = new Multiplicacao(lm);
        programa.add(m);

        System.out.println("Resultados das Expressões\n");

        for (Expressao p : programa) {
            System.out.println(p.toString() + " = " + p.resolva());
        }
    }

    public static void main(String[] args) {
        execute();
    }
}