public class Artist {
    private String firstName;
    private String lastName;
    private int birthYear;
    private Album[] albums;
    private Song[] singles;

    public Artist(String firstName, String lastName, int birthYear, Album[] albums, Song[] singles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.albums = albums;
        this.singles = singles;
    }

    public Song mostLikedSong() {
        Song max = this.albums[0].getSongs()[0];
        for (int i = 0; i < this.albums.length; i++) {
            for (int j = 0; j < this.albums[i].getSongs().length; j++) {
                if (max.getLikes() > this.albums[i].getSongs()[j].getLikes()) {
                    max = this.albums[i].getSongs()[j];
                }
            }
        }
        for (int i = 0; i < singles.length; i++) {
            if (max.getLikes() > singles[i].getLikes()) {
                max = singles[i];
            }
        }
        return max;
    }

    public Song leastLikedSong() {
        Song min = this.albums[0].getSongs()[0];
        for (int i = 0; i < this.albums.length; i++) {
            for (int j = 0; j < this.albums[i].getSongs().length; j++) {
                if (min.getLikes() < this.albums[i].getSongs()[j].getLikes()) {
                    min = this.albums[i].getSongs()[j];
                }
            }
        }
        for (int i = 0; i < singles.length; i++) {
            if (min.getLikes() < singles[i].getLikes()) {
                min = singles[i];
            }
        }
        return min;
    }

    public int totalLikes() {
        int numLikes = 0;
        for (int i = 0; i < this.albums.length; i++) {
            for (int j = 0; j < this.albums[i].getSongs().length; j++) {
                numLikes += this.albums[i].getSongs()[j].getLikes();
            }
        }
        for (int i = 0; i < singles.length; i++) {
            numLikes += singles[i].getLikes();
        }
        return numLikes;
    }
    public boolean isEqual(Artist other){
        if(this.getFirstName().equals(other.getFirstName()) && this.getLastName().equals(other.getLastName()) && this.getBirthYear() == other.birthYear){
            return true;
        }else{
            return false;
        }
    }
    public String toString(){
        return "Name: " + firstName +" "+ lastName + ",Birth year:" + birthYear + ",Total likes:" + totalLikes();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public Song[] getSingles() {
        return singles;
    }
}
