import java.util.Scanner;

public class Taller02UnitTesting {
    //   N = intro.nextInt(); (validar)
    // double[][] sensor = new double[Ndias][24];
    //  reciclar metodo random para los 24 dias (0.0 a 9.5) (10 a 95 luego / por 10)

    public void imprimirDatosSismoMasIntenso(double[][] sensor){
        System.out.println("Datos del sismo más intenso: ");
        System.out.println("Intensidad: " + registrarIntensidadMayorSismo(sensor));
        System.out.println("Día en que ocurrió: " + registrarDiaMayorSismo(sensor));
        System.out.println("Hora en que ocurrió: " + registrarHoraMayorSismo(sensor));
        System.out.println("\nCantidad de sismos mayores a 5.5 grados: " + getCantidadDiasSismosSobre5(sensor));
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

    public int registrarDiaMayorSismo(double[][] sensor) throws IllegalArgumentException{
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

    public int registrarHoraMayorSismo(double[][] sensor) throws IllegalArgumentException{
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

    public int getCantidadDiasSismosSobre5(double[][] sensor){
        propagarExcepcion(sensor);

        int cantidadDias = 0;

        for (int i = 0; i < sensor.length; i++){
            for (int j = 0; j < 24; j++){
                if(sensor[i][j] >= 5.5){
                    cantidadDias++;
                }
            }
        }

        return cantidadDias;
    }

    private void propagarExcepcion(double[][] sensor) throws IllegalArgumentException, ArrayIndexOutOfBoundsException{
        if(sensor == null){
            throw new IllegalArgumentException("el sensor es vacío");
        }
        if(sensor.length == 0 || sensor[0].length == 0){
            throw new IllegalArgumentException("el sensor contiene un tamaño vacío");
        }
        if(sensor[0].length > 24){
            throw new ArrayIndexOutOfBoundsException("el sensor contiene un tamaño fuera de lo necesario.");
        }
    }

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
