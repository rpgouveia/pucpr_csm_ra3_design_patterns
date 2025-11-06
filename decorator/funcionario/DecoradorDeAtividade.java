
package decorator.funcionario;

abstract public class DecoradorDeAtividade extends Componente
{
    protected Componente componente;
    protected double numeroDeHoras;
    protected double valorHora;

    public DecoradorDeAtividade(String nome, double nh, double vh) {
        super( nome );
        this.numeroDeHoras = nh;
        this.valorHora = vh;
    }
    
    @Override
    public boolean aponta(Componente c) throws Exception {
        
         this.componente = c;
         
         return true;
    }    
 
    @Override
    public String toString() {
        return  this.componente.toString() + "\n" 
                + " :- Atividade executada: "+(super.toString() 
                + "\n    [Numero de horas = " + this.numeroDeHoras
                + ", Valor hora = " + this.valorHora+"] = "
                + (this.numeroDeHoras * this.valorHora));
    }
    
    @Override
    public double calculaSalario(){
        return ((this.numeroDeHoras * this.valorHora) 
               + this.componente.calculaSalario());
    }

}