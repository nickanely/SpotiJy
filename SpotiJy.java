public class SpotiJy {
    private Artist[] artists;

    public SpotiJy(Artist[] artists) {
        this.artists = null;
    }

    public Artist[] getArtists() {
        return artists;
    }

    public void addArtists(Artist[] artists) {
        int count = 0;
        Artist[] newArtist = null;
        if (this.artists == null && artists != null) {
            this.artists = artists;
        } else if ((this.artists == null && artists == null) || (this.artists != null && artists == null)) {
            return;
        }
        Artist[] x = artists;
        for (int i = 0; i < x.length; i++) {
            if (x[i].isEqual(this.artists[i])) {
                newArtist = new Artist[artists.length - 1];
                for (int l = 0, m = 0; l < artists.length; l++) {
                    if (l == i) {
                        l++;
                    }
                    newArtist[m] = artists[l];
                    m++;
                }
                artists = newArtist;
            }
        }
        Artist[] res = new Artist[this.artists.length + count];
        for (int i = 0; i < res.length; i++) {
            res[i] = this.artists[i];
            res[this.artists.length] = x[i];
        }
    }

    public String[] getTopTrendingArtist() {
        Artist mostLikedArtist = null;
        for (int i = 0; i < artists.length; i++) {
            Artist x = artists[i];
            if (x.totalLikes() > mostLikedArtist.totalLikes()) {
                mostLikedArtist = x;
            }
        }
        if (mostLikedArtist == null)
            return null;
        String[] returnArr = new String[]{mostLikedArtist.getFirstName(), mostLikedArtist.getLastName()};
        return returnArr;
    }

    public String getTopTrendingAlbum() {
        String name = "";
        int comp = 0;
        int compAlbums = 0;
        int aLindex = 0;
        int aRindex = 0;
        int likes = 0;
        int album = 0;
        //Artist mostLikedAlbum = null;
        for (int i = 0; i < artists.length; i++) {
            for (int j = 0; j < artists[i].getAlbums().length; j++) {
                for (int k = 0; k < artists[i].getAlbums()[j].getSongs().length; k++) {
                    likes += artists[i].getAlbums()[j].getSongs()[k].getLikes();
                }
                if (j == 0)
                    comp = likes;
                else if (likes > comp) {
                    aLindex = j;
                    comp = likes;
                }
            }
            if (i == 0) {
                compAlbums = likes;
                album = aLindex;
            } else if (likes > compAlbums) {
                likes = compAlbums;
                aRindex = i;
                album = aRindex;
            }
        }
        return artists[aRindex].getAlbums()[album].getTitle() + compAlbums;
    }

    public String getTopTrendingSong() {
        String name = " ";
        int likes = 0;
        for (int i = 0; i < artists.length; i++) {
            if (this.artists[i] != null) {
                for (int j = 0; j < artists[i].getAlbums().length; j++) {
                    if (this.artists[i].getAlbums()[j] != null) {
                        for (int k = 0; k < artists[i].getAlbums()[j].getSongs().length; k++) {
                            if (this.artists[i].getAlbums()[j].getSongs()[k] != null) {
                                int p = artists[i].getAlbums()[j].getSongs()[k].getLikes();
                                if (p >= likes) {
                                    likes = p;
                                    name = artists[i].getAlbums()[j].getSongs()[k].getTitle();
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < artists.length; i++) {
            if (this.artists[i] != null) {
                for (int j = 0; j < artists[i].getSingles().length; j++) {
                    if (this.artists[i].getSingles()[j] != null) {
                        int p = artists[i].getSingles()[j].getLikes();
                        if (p >= likes) {
                            likes = p;
                            name = artists[i].getSingles()[j].getTitle();
                        }
                    }
                }
            }
        }
        return name;
    }
}
