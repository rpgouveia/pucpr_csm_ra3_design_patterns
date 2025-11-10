package decorator.funcionario;

public class Implantador extends DecoradorDeAtividade
{
    public Implantador(double nh, double vh) {
        super("Implantador", nh, vh);
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
