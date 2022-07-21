import java.util.HashMap;
import java.util.Objects;
import java.util.function.Supplier;

public class Impressao {

    private int paginasTotais;
    private int paginasColoridas;
    private int paginasPretoBranco;
    private boolean ehFrenteVerso;
    private double valorColoridasFrenteVerso;
    private double valorPretoBrancoFrenteVerso;
    private double valorColoridasFrenteApenas;
    private double valorPretoBrancoFrenteApenas;
    private TamanhoImpressao tamanhoImpressao;

    public Impressao(TamanhoImpressao tamanhoImpressao, int totalPaginas, int qtdColoridas, boolean ehFrenteVerso) {
        setTamanhoImpressao(tamanhoImpressao);
        setPaginasTotais(totalPaginas);
        setPaginasColoridas(qtdColoridas);
        setEhFrenteVerso(ehFrenteVerso);
        setPaginasPretoBranco(totalPaginas - qtdColoridas);
    }

    public int getPaginasTotais() {
        return paginasTotais;
    }

    public void setPaginasTotais(int paginasTotais) {
        this.paginasTotais = paginasTotais;
    }

    public int getPaginasColoridas() {
        return paginasColoridas;
    }

    public void setPaginasColoridas(int paginasColoridas) {
        this.paginasColoridas = paginasColoridas;
    }

    public int getPaginasPretoBranco() {
        return paginasPretoBranco;
    }

    public void setPaginasPretoBranco(int paginasPretoBranco) {
        this.paginasPretoBranco = paginasPretoBranco;
    }

    public boolean isEhFrenteVerso() {
        return ehFrenteVerso;
    }

    public void setEhFrenteVerso(boolean ehFrenteVerso) {
        this.ehFrenteVerso = ehFrenteVerso;
    }

    public double getValorColoridasFrenteVerso() {
        return valorColoridasFrenteVerso;
    }

    public void setValorColoridasFrenteVerso(double valorColoridasFrenteVerso) {
        this.valorColoridasFrenteVerso = valorColoridasFrenteVerso;
    }

    public double getValorPretoBrancoFrenteVerso() {
        return valorPretoBrancoFrenteVerso;
    }

    public void setValorPretoBrancoFrenteVerso(double valorPretoBrancoFrenteVerso) {
        this.valorPretoBrancoFrenteVerso = valorPretoBrancoFrenteVerso;
    }

    public double getValorColoridasFrenteApenas() {
        return valorColoridasFrenteApenas;
    }

    public void setValorColoridasFrenteApenas(double valorColoridasFrenteApenas) {
        this.valorColoridasFrenteApenas = valorColoridasFrenteApenas;
    }

    public double getValorPretoBrancoFrenteApenas() {
        return valorPretoBrancoFrenteApenas;
    }

    public void setValorPretoBrancoFrenteApenas(double valorPretoBrancoFrenteApenas) {
        this.valorPretoBrancoFrenteApenas = valorPretoBrancoFrenteApenas;
    }

    public TamanhoImpressao getTamanhoImpressao() {
        return tamanhoImpressao;
    }

    public void setTamanhoImpressao(TamanhoImpressao tamanhoImpressao) {
        this.tamanhoImpressao = tamanhoImpressao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Impressao impressao = (Impressao) o;
        return paginasTotais == impressao.paginasTotais && paginasColoridas == impressao.paginasColoridas && paginasPretoBranco == impressao.paginasPretoBranco && ehFrenteVerso == impressao.ehFrenteVerso && Double.compare(impressao.valorColoridasFrenteVerso, valorColoridasFrenteVerso) == 0 && Double.compare(impressao.valorPretoBrancoFrenteVerso, valorPretoBrancoFrenteVerso) == 0 && Double.compare(impressao.valorColoridasFrenteApenas, valorColoridasFrenteApenas) == 0 && Double.compare(impressao.valorPretoBrancoFrenteApenas, valorPretoBrancoFrenteApenas) == 0 && tamanhoImpressao == impressao.tamanhoImpressao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paginasTotais, paginasColoridas, paginasPretoBranco, ehFrenteVerso, valorColoridasFrenteVerso, valorPretoBrancoFrenteVerso, valorColoridasFrenteApenas, valorPretoBrancoFrenteApenas, tamanhoImpressao);
    }

    @Override
    public String toString() {
        return String.format("total de paginas: %d, total coloridas: %d, total preto e branco: %d, %s. total: R$ %.2f", getPaginasTotais(), getPaginasColoridas(), getPaginasPretoBranco(), ((isEhFrenteVerso()) ? "frente e verso" : "frente apenas"), calcularTotal());
    }

    public double calcularTotal() {
        HashMap<TamanhoImpressao, Rule<Double>> rulesOnlyFrontPrinting = createRulesOnlyFrontPrinting();
        HashMap<TamanhoImpressao, Rule<Double>> rulesDuplexPrinting = createRulesDuplexPrinting();
        double total;

        if (!isEhFrenteVerso()) {
            total = rulesOnlyFrontPrinting.get(getTamanhoImpressao()).getProcess().get();
        } else {
            total = rulesDuplexPrinting.get(getTamanhoImpressao()).getProcess().get();
        }

        return total;
    }

    HashMap<TamanhoImpressao, Rule<Double>> createRulesOnlyFrontPrinting() {
        HashMap<TamanhoImpressao, Rule<Double>> rules = new HashMap<>();
        rules.put(TamanhoImpressao.A2, createRuleForSizeA2AndOnlyFrontPrinting(0.22, 0.32));
        rules.put(TamanhoImpressao.A3, createRuleForSizeA3AndOnlyFrontPrinting(0.20, 0.30));
        rules.put(TamanhoImpressao.A4, createRuleForSizeA4AndOnlyFrontPrinting(0.15, 0.25));

        return rules;
    }

    HashMap<TamanhoImpressao, Rule<Double>> createRulesDuplexPrinting() {
        HashMap<TamanhoImpressao, Rule<Double>> rules = new HashMap<>();
        rules.put(TamanhoImpressao.A2, createRuleForSizeA2AndDuplexPrinting(0.18, 0.28));
        rules.put(TamanhoImpressao.A3, createRuleForSizeA3AndDuplexPrinting(0.15, 0.25));
        rules.put(TamanhoImpressao.A4, createRuleForSizeA4AndDuplexPrinting(0.10, 0.20));
        return rules;
    }

    Rule<Double> createRuleForSizeA2AndOnlyFrontPrinting(double valueBlackAndWhiteFrontOnly, double valueColorFrontOnly) {
        return createRule(() -> {
            setValorPretoBrancoFrenteApenas(valueBlackAndWhiteFrontOnly);
            setValorColoridasFrenteApenas(valueColorFrontOnly);
            return (getPaginasColoridas() * getValorColoridasFrenteApenas()) + (getPaginasPretoBranco() * getValorPretoBrancoFrenteApenas());
        });
    }

    Rule<Double> createRuleForSizeA2AndDuplexPrinting(double valueBlackAndWhiteDuplex, double valueColorFrontDuplex) {
        return createRule(() -> {
            setValorPretoBrancoFrenteVerso(valueBlackAndWhiteDuplex);
            setValorColoridasFrenteVerso(valueColorFrontDuplex);
            return (getPaginasColoridas() * getValorColoridasFrenteVerso()) + (getPaginasPretoBranco() * getValorPretoBrancoFrenteVerso());
        });
    }

    Rule<Double> createRuleForSizeA3AndOnlyFrontPrinting(double valueBlackAndWhiteFrontOnly, double valueColorFrontOnly) {
        return createRule(() -> {
            setValorPretoBrancoFrenteApenas(valueBlackAndWhiteFrontOnly);
            setValorColoridasFrenteApenas(valueColorFrontOnly);
            return (getPaginasColoridas() * getValorColoridasFrenteApenas()) + (getPaginasPretoBranco() * getValorPretoBrancoFrenteApenas());
        });
    }

    Rule<Double> createRuleForSizeA3AndDuplexPrinting(double valueBlackAndWhiteDuplex, double valueColorFrontDuplex) {
        return createRule(() -> {
            setValorPretoBrancoFrenteVerso(valueBlackAndWhiteDuplex);
            setValorColoridasFrenteVerso(valueColorFrontDuplex);
            return (getPaginasColoridas() * getValorColoridasFrenteVerso()) + (getPaginasPretoBranco() * getValorPretoBrancoFrenteVerso());
        });
    }

    Rule<Double> createRuleForSizeA4AndOnlyFrontPrinting(double valueBlackAndWhiteFrontOnly, double valueColorFrontOnly) {
        return createRule(() -> {
            setValorPretoBrancoFrenteApenas(valueBlackAndWhiteFrontOnly);
            setValorColoridasFrenteApenas(valueColorFrontOnly);
            return (getPaginasColoridas() * getValorColoridasFrenteApenas()) + (getPaginasPretoBranco() * getValorPretoBrancoFrenteApenas());
        });
    }

    Rule<Double> createRuleForSizeA4AndDuplexPrinting(double valueBlackAndWhiteDuplex, double valueColorFrontDuplex) {
        return createRule(() -> {
            setValorPretoBrancoFrenteVerso(valueBlackAndWhiteDuplex);
            setValorColoridasFrenteVerso(valueColorFrontDuplex);
            return (getPaginasColoridas() * getValorColoridasFrenteVerso()) + (getPaginasPretoBranco() * getValorPretoBrancoFrenteVerso());
        });
    }

    Rule<Double> createRule(Supplier<Double> process) {
        return new Rule<Double>(process);
    }
}