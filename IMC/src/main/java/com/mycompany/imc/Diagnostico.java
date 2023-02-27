package com.mycompany.imc;

import java.util.Scanner;

public class Diagnostico {
    private Paciente pc;
    Scanner sc=new Scanner(System.in);
    
    public void retrievDat(){
        float alt, pes;
        int ed;
        char s;
        String nom;
        
        System.out.println("Escriba su nombre: ");
        nom=sc.nextLine();
        pc.setNom(nom);
        System.out.println("Escriba su genero (f para mujer, m para hombre): ");
        s=sc.nextLine().charAt(0);
        pc.setGen(s);
        System.out.println("Ingrese su altura en metros: ");
        alt=sc.nextFloat();
        pc.setAlt(alt);
        System.out.println("Ingrese su peso en kilos: ");
        pes=sc.nextFloat();
        pc.setPeso(pes);
        System.out.println("Ingrese su edad: ");
        ed=sc.nextInt();
        pc.setEdad(ed);
    }
    
    public float imc(float p, float a){
        return p/(a*a);
    }
    
    public int diag(){
        int niv=0;
        System.out.println("Clasificación IMC:");
        if(imc(pc.getPeso(),pc.getAlt())<18.5){
            System.out.println("Desnutricion.");
            niv=1;
        }else if(imc(pc.getPeso(),pc.getAlt())>=18.5&&imc(pc.getPeso(),pc.getAlt())<25){
            System.out.println("Normal.");
            niv=2;
        }else if(imc(pc.getPeso(),pc.getAlt())>=25&&imc(pc.getPeso(),pc.getAlt())<30){
            System.out.println("Sobrepeso.");
            niv=3;
        }else if(imc(pc.getPeso(),pc.getAlt())>=30&&imc(pc.getPeso(),pc.getAlt())<35){
            System.out.println("Obesidad grado I.");
            niv=4;
        }else if(imc(pc.getPeso(),pc.getAlt())>=35&&imc(pc.getPeso(),pc.getAlt())<40){
            System.out.println("Obesidad grado II.");
            niv=5;
        }else{
            System.out.println("Obesidad grado III.");
            niv=6;
        }
        return niv;
    }
    
    public void dx(){
        System.out.println("""
                           Segun sus datos, este es su diagnostico:
                           Su IMC es """+imc(pc.getPeso(),pc.getAlt())+".");
        switch(diag()){
            case 2 -> System.out.println("No hay recomenndaciones necesarias.");
            case 1 -> System.out.println("Incrementar consumo de alimentos y disminuir ejercicio.");
            case 3, 4, 5, 6 -> {
                if (pc.getEdad()>=15&&pc.getEdad()<=50){
                    System.out.println("Incrementar ejercicio y mejorar dieta.");
                }else if (pc.getEdad()>50){
                    System.out.println("Mejorar dieta.");
                }
            }
        }
    }
}
