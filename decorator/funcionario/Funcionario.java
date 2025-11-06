
package decorator.funcionario;

public class Funcionario extends Componente{
    
    private String sobrenome;
    
    public Funcionario(String nome, String sobrenome){
        super(nome);
        this.sobrenome = sobrenome;
    }
    
    @Override
    public boolean aponta(Componente d) throws Exception {
          throw (new Exception("Operacao não valida em Folha"));
    }
            
    @Override
    public String toString() {
        return "Funcionario: " + super.toString() + " " + this.sobrenome;
    }
    
    @Override
    public double calculaSalario(){
         return 0;
    }
}
