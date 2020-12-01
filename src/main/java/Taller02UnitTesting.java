public class Taller02UnitTesting {
    //   N = intro.nextInt(); (validar)
    // double[][] sensor = new double[Ndias][24];
    //  reciclar metodo random para los 24 dias (0.0 a 9.5) (10 a 95 luego / por 10)

    public void imprimirDatosSismoMasIntenso(double[][] sensor){
        System.out.println("Datos del sismo más intenso: ");
        System.out.println("Intensidad: ");
        System.out.println("Día en que ocurrió: ");
        System.out.println("Hora en que ocurrió: ");
    }

    public double registrarIntensidadMayorSismo(double[][] sensor){
        double mayor = sensor[0][0];

        for (int i = 0; i < sensor.length; i++){
            mayor = sensor[i][0];
            for (int j = 1; j < 24; j++){
                if(sensor[i][j] > mayor){

                }
            }
        }

        return mayor;
    }

}
