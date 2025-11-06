
package decorator.funcionario;

public abstract class Componente {
    
    private String nome;
    
    public abstract double calculaSalario();
    public abstract boolean aponta(Componente d) throws Exception;
    
    public Componente(String nm){
        this.nome = nm;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
}
