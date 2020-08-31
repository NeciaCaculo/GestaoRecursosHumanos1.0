/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import rh.modelo.Funcionario;

/**
 *
 * @author Necia
 */
@Named(value = "funcionarioMBean")
@RequestScoped
public class FuncionarioMBean {
    
    Funcionario funcionario; 
    double imc=0;
    
    
    @PostConstruct
    public void init(){
    
        funcionario = new Funcionario();
        
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
//    public String guardar() {
//        return "resultado";
//    }
//    
   
    public String mostraimc(){
       imc = getFuncionario().getPeso()/(getFuncionario().getAltura()*getFuncionario().getAltura()); 
        
        if(imc<18.5)
            return "O seu Índice de Massa corporal é Abaixo peso. "+imc;
        else if(imc>=18.6 && imc<=24.9)
               return "O seu Índice de Massa corporal é Saudável. "+imc;
        else if(imc>=25 && imc<=29.9)
            return "O seu Índice de Massa corporal é peso em excesso. "+imc;
        else if(imc>=30 && imc<=34.9)
            return "O seu Índice de Massa corporal é Obesidade grau I. "+imc;
        else if(imc>=35 && imc<=39.9)
            return "O seu Índice de Massa corporal é Obesidade grau II. "+imc;
        return "O seu Índice de Massa corporal é Obesidade grau III."+imc;
    }
    

}
