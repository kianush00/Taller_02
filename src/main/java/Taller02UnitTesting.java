public class Taller02UnitTesting {
    //   N = intro.nextInt(); (validar)
    // double[][] sensor = new double[Ndias][24];
    //  reciclar metodo random para los 24 dias (0.0 a 9.5) (10 a 95 luego / por 10)

    public void imprimirDatosSismoMasIntenso(double[][] sensor){
        System.out.println("Datos del sismo más intenso: ");
        System.out.println("Intensidad: " + registrarIntensidadMayorSismo(sensor));
        System.out.println("Día en que ocurrió: " + registrarDiaMayorSismo(sensor));
        System.out.println("Hora en que ocurrió: " + registrarHoraMayorSismo(sensor));
    }

    public double registrarIntensidadMayorSismo(double[][] sensor){
        propagarExcepcion(sensor);

        double mayor = sensor[0][0];
        double subMayor;

        for (int i = 0; i < sensor.length; i++){
            subMayor = sensor[i][0];
            for (int j = 1; j < 24; j++){
                if(sensor[i][j] > subMayor){
                    subMayor = sensor[i][j];
                }
            }
            if (subMayor > mayor){
                mayor = subMayor;
            }
        }

        return mayor;
    }

    public double registrarDiaMayorSismo(double[][] sensor) throws IllegalArgumentException{
        propagarExcepcion(sensor);

        double mayorSismo = registrarIntensidadMayorSismo(sensor);

        for (int i = 0; i < sensor.length; i++){
            for (int j = 0; j < 24; j++){
                if(sensor[i][j] == mayorSismo){
                    return i;
                }
            }
        }

        return 0;
    }

    public double registrarHoraMayorSismo(double[][] sensor) throws IllegalArgumentException{
        propagarExcepcion(sensor);

        double mayorSismo = registrarIntensidadMayorSismo(sensor);

        for (int i = 0; i < sensor.length; i++){
            for (int j = 0; j < 24; j++){
                if(sensor[i][j] == mayorSismo){
                    return j;
                }
            }
        }

        return 0;
    }

    private void propagarExcepcion(double[][] sensor) throws IllegalArgumentException{
        if(sensor == null){
            throw new IllegalArgumentException("el sensor es vacío");
        }
        if(sensor.length == 0 || sensor[0].length == 0){
            throw new IllegalArgumentException("el sensor contiene un tamaño vacío");
        }
    }
}
