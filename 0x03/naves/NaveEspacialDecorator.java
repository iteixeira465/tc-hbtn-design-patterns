public class NaveEspacialDecorator extends NaveEspacial{
    private NaveEspacial naveDecorada;

    public NaveEspacialDecorator(NaveEspacial naveDecorada) {
        super(naveDecorada.getSaude(), naveDecorada.getAtaque());
        this.naveDecorada = naveDecorada;
    }

    @Override
    public int getSaude() {
        return super.getSaude();
    }

    @Override
    public int getAtaque() {
        return super.getAtaque();
    }
    
}
