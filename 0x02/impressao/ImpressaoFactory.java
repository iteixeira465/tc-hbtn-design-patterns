public class ImpressaoFactory {

    public static Impressao createImpressao(TamanhoImpressao tamanhoImpressao, int totalPaginas, int qtdColoridas, boolean ehFrenteVerso) {
        return new Impressao(tamanhoImpressao, totalPaginas, qtdColoridas, ehFrenteVerso);
    }

}