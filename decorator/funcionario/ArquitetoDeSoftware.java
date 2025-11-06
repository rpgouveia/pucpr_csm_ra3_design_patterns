/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator.funcionario;


public class ArquitetoDeSoftware extends DecoradorDeAtividade
{ 
    
    public ArquitetoDeSoftware(double nh, double vh) {
        super("Arquiteto de software", nh, vh);
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