package decorator.funcionario;

public class Programador extends DecoradorDeAtividade
{
    public Programador(double nh, double vh) {
        super("Programador", nh, vh);
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
