
package decorator.funcionario;

public class AnalistaDeSistema extends DecoradorDeAtividade
{
    
    public AnalistaDeSistema(double nh, double vh) {
        super("Analista de sistema", nh, vh);
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