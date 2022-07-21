public class Director {

    public void buildGuerreiro(Builder builder){
        builder.setNome("Guerreiro");
        builder.setInteligencia(1);
        builder.setForca(8);
        builder.setVigor(5);
        builder.setResistencia(10);
        builder.setDestreza(6);
    }

    public void buildLadrao(Builder builder){
        builder.setNome("Ladrao");
        builder.setInteligencia(2);
        builder.setForca(6);
        builder.setVigor(8);
        builder.setResistencia(5);
        builder.setDestreza(10);
    }

    public void buildMago(Builder builder){
        builder.setNome("Mago");
        builder.setInteligencia(10);
        builder.setForca(2);
        builder.setVigor(5);
        builder.setResistencia(3);
        builder.setDestreza(4);
    }
}