package br.inatel.cdg.algebra.reta;

public class Reta {

    private Ponto p1;
    private Ponto p2;

    public Reta(Ponto p1,Ponto p2){
        this.p1=p1;
        this.p2=p2;
    }
    public double calculaCoeficienteAngular(){
        double cAngular = 0.0;
        cAngular=(p2.getY()-p1.getY())/(p2.getX()-p1.getX());

        return cAngular;

    }
    public double calculaCoeficienteLinear(){

        double cLinear = 0.0;

        cLinear = p1.getY()-(calculaCoeficienteAngular()*p1.getX());

        return cLinear;

    }

}
