public class MediaPlayerAdapter implements MediaPlayer{
    private AdvancedMediaPlayer advanceMediaPlayer;

    public MediaPlayerAdapter(TipoMedia tipoMedia) {
        if (!(tipoMedia == TipoMedia.MP3)) {
            advanceMediaPlayer = new VideoMediaPlayer();
        }
    }

    @Override
    public void reproduzir(TipoMedia tipo, String nome) {
         if(tipo == TipoMedia.VLC){
            advanceMediaPlayer.reproduzirVlc(nome);
        }
    }
    
}
