import java.util.Random;

public class Album {
    private String title;
    private int releaseYear;
    private Song[] songs;

    Album(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }
    public int addSongs(Song[] songs) {
        int count = 0;
        Song[] newSongs = null;
        if (this.songs == null && songs != null) {
            this.songs = songs;
            return songs.length;
        } else if ((this.songs == null && songs == null) || (this.songs != null && songs == null)) {
            return 0;
        }
        Song[] x = songs;
        for (int i = 0; i < x.length; i++) {
            if (!x[i].isEqual(this.songs[i])) {
                count++;
            } else if (x[i].isEqual(this.songs[i])) {
                newSongs = new Song[songs.length - 1];
                for (int l = 0, m = 0; l < songs.length; l++) {
                    if (l == i) {
                        l++;
                    }
                    newSongs[m] = songs[l];
                    m++;
                }
                songs = newSongs;
            }
        }
        Song[] res = new Song[this.songs.length + count];
        for (int i = 0; i < res.length; i++) {
            res[i] = this.songs[i];
            res[this.songs.length] = x[i];
        }
        return count;
    }

    public Song[] shuffle() {
        Song[] shuffled = this.songs;
        Random gen = new Random();

        for (int i = 0; i < songs.length; i++) {
            int s = gen.nextInt(this.songs.length);
            Song temp = songs[s];
            songs[s] = songs[i];
            songs[i] = temp;
        }
        return shuffled;
    }

    public Song[] sortByTitle(boolean isAscending) {
        Song[] result = this.songs;
        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i].getTitle().compareToIgnoreCase(result[j].getTitle()) > 0) {
                    Song temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        if (isAscending) {
            return result;
        } else {
            return reverse(songs);
        }
    }

    public Song[] sortByDuration(boolean isAscending) {
        Song[] result = this.songs;
        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i].getDuration() > result[j].getDuration()) {
                    Song temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        if (isAscending) {
            return result;
        } else {
            return reverse(songs);
        }
    }

    public Song[] sortByReleaseYear(boolean isAscending) {
        Song[] result = this.songs;
        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i].getReleaseYear() > result[j].getReleaseYear()) {
                    Song temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        if (isAscending) {
            return result;
        } else {
            return reverse(songs);
        }
    }

    public Song[] sortByPopularity(boolean isAscending) {
        Song[] result = this.songs;
        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i].getLikes() > result[j].getLikes()) {
                    Song temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        if (isAscending) {
            return result;
        } else {
            return reverse(songs);
        }
    }

    public static Song[] reverse(Song[] songs) {
        int count = songs.length - 1;
        Song[] revArr = new Song[songs.length];
        for (int i = 0; i < songs.length; i++) {
            revArr[i] = songs[count];
            count--;
        }
        return revArr;
    }

    public String toString() {
        String result = "Title:" + title + ",Release year:" + releaseYear + "songs:{";
        for (int i = 0; i < songs.length; i++) {
            result += songs[i].toString();
            if (i != songs.length - 1) {
                result += "|";
            } else {
                result += "}";
            }
        }
        return result;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Song[] getSongs() {
        return songs;
    }
}
