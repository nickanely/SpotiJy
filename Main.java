public class Main {
    public static void main(String[] args) {
        Song rattlestarSong = new Song("Snake Jazz", 1989);

        Album greenSide = new Song[]{(
                new Song("Luka", 2200, 120, 400),
                new Song("Nika", 2014, 140, 450),
                new Song("Zuka", 2020, 300, 1000),
                new Song("Bruh", 1998, 160, 650),
                new Song("Luka", 2200, 120, 1000),
                new Song("Bruh", 1998, 160, 5000),
                new Song("Ana noob", 2400, 500, 1800);)};
        greenSide.addSongs(new Song[] {rattlestarSong, new Song("Luka", 2200, 120, 400), new Song("Zuka", 2020, 300, 500)});
        int x = greenSide.addSongs(new Song[]{
                new Song("Luka", 2200, 120, 400),
                new Song("Nika", 2014, 140, 450),
                new Song("Zuka", 2020, 300, 1000),
                new Song("Bruh", 1998, 160, 650),
                new Song("Luka", 2200, 120, 1000),
                new Song("Bruh", 1998, 160, 5000),
                new Song("Ana noob", 2400, 500, 1800)
        });
        String forDebugging = "bruh";
        for (int i = 0; i < greenSide.shuffle().length; i++) {
            System.out.println(greenSide.shuffle()[i].toString());
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Song rattlestarSong = new Song("Snake Jazz", 1989);
        Album greenSide = new Album("Green side",1976, new Song[] {rattlestarSong, new Song("Luka", 2200, 120, 400), new Song("Zuka", 2020, 300, 500)});
        int x = greenSide.addSongs(new Song[]{
                new Song("Luka", 2200, 120, 400),
                new Song("Nika", 2014, 140, 450),
                new Song("Zuka", 2020, 300, 1000),
                new Song("Bruh", 1998, 160, 650),
                new Song("Luka", 2200, 120, 1000),
                new Song("Bruh", 1998, 160, 5000),
                new Song("Ana noob", 2400, 500, 1800)
        });
        String forDebugging = "bruh";
        for (int i = 0; i < greenSide.getSongs().length; i++) {
            System.out.println(greenSide.getSongs()[i].toString());
        }
        System.out.println(x);
    }
}