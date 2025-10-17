package IoC;

public class MusicPlayer {
    private ClassicalMusic classicalMusic;

    public MusicPlayer(ClassicalMusic classicalMusic) {
        this.classicalMusic = classicalMusic;
    }

    public void playMusic() {

        classicalMusic = new ClassicalMusic();
    }
}
