import java.util.UUID;

public class CalculadorSalarioService {

    private CalculadorSalarioService() {
    }
    
    private static CalculadorSalarioService instancia;

    public static CalculadorSalarioService getCalculadorSalarioService(){

        if( instancia == null ){

            instancia = new CalculadorSalarioService();
        }

        return instancia;
    }

    public double calcularSalarioLiquido(double salarioBruto, double valorDescontos, double valorVendas, double percentualComissao){
        return salarioBruto - valorDescontos + (valorVendas * (percentualComissao/100));
    }

    public UUID uuid = UUID.randomUUID();

    public static void setinstancia(CalculadorSalarioService instancia) {
        CalculadorSalarioService.instancia = instancia;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    

    
}
