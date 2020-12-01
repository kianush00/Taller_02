import java.util.Scanner;

public class Taller02UnitTesting {

    public double[][] setUpsensor(){
        System.out.println("Ingrese cantidad de dias a estudiar");
        Scanner scanner = new Scanner(System.in);
        int entrada=0;
        boolean intento=true;
       while(intento==true) {
           try {
               entrada = scanner.nextInt();
               if (entrada < 0) {
                   throw new IllegalArgumentException();
               }
               else{
                   intento=false;
               }
           } catch (IllegalArgumentException iae) {
               System.err.println("Error detectado, argumento invalido, ingrese un numero.");

           }

       }
            double[][] sensor = new double[entrada][24];
            for(int i=0; i>sensor.length;++i){
                for(int j=0;j>24;++i){
                    sensor[i][j]=getValorSismicoAleatorioEntre(0.0,9.5);
                }
            }
            return sensor;
        }


    private double getValorSismicoAleatorioEntre(double min, double max){
        if(min > max){   //si los argumentos tienen valores contrarios, entonces se cambiarán de posición
            return (Math.random() * ((min + 1) - max)) + max;
        }
        return (Math.random() * ((max + 1) - min)) + min;
    }

    public int alertaSismica(double[][] sensor ) {
            int j;
        for(int i=0;i<sensor.length; ++i) {
            int alerta = 0;
            for ( j = 0; j < 24; ++j) {

                if (sensor[i][j] > 6.0) {
                    alerta++;
                }
            }
            if (alerta >= 4) {
                System.out.println("El dia "+i+ "a la hora " +j +":00");
            }
        }
        return 0;
    }
    boolean salir(){
        System.out.println("¿Desea salir del sistema? (0:NO 1:SI)");
        Scanner scanner = new Scanner(System.in);
        int entrada = scanner.nextInt();

        if(entrada==1){
         return false;
        }
        return true;
    }
    public int menu(){
        double sensor[][]=setUpsensor();
        boolean salir=true;
        while(salir) {
            alertaSismica(sensor);
            //imprimirDatoMayorSismo();

            //registrarIntensidadmayorSismo
            //registrarHoraMayorSismo
        salir=salir();
        }
        System.exit(1);
        return 0;
    }

}

