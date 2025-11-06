
package decorator.funcionario;

public class TestadorDeSoftware extends DecoradorDeAtividade
{
    public TestadorDeSoftware(double nh, double vh) {
        super("Testador de Software", nh, vh);
    }
    
    private double facaAlgo(){
        return this.numeroDeHoras * this.valorHora;        
    }
    
    @Override
    public double calculaSalario() {
        return ((this.numeroDeHoras * this.valorHora) 
               + this.componente.calculaSalario());
    }
}