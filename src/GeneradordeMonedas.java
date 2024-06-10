public class GeneradordeMonedas {

    private double TasadeCambio;

    public GeneradordeMonedas(double tasadeCambio) {
        TasadeCambio = tasadeCambio;
    }

    public double convertir(double cantidad){
        return cantidad * TasadeCambio;
    }
}
