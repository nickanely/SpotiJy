public class Song {
    private String title;
    private int releaseYear;
    private int duration;
    private int likes;


    public Song(String title, int releaseYear, int duration, int likes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;
    }
    public Song(String title, int releaseYear, int duration ) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = 0;
    }
    public Song(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = 60;
        this.likes = 0;
    }

    public boolean changeDuration(int duration) {
        if (duration < 0 || duration > 720 || duration == this.duration) {
            return false;
        }
        else {
            this.duration = duration;
            return true;
        }
    }
    public String toString(){
        double x = (double) duration/60;
        return "Title:" + title + ",Duration:" + x + " minutes,Release year:" + releaseYear + ",Likes:" + likes;
    }

    //likes'n'unlikes
    public void like() {
        likes++;
    }
    public void unlike() {
        if(likes == 0) return;
        likes--;
    }

    public boolean isEqual(Song other){
        if(this.title.equals(other.title) && this.releaseYear == other.releaseYear && this.duration == other.duration){
            return false;
        }else{
            return true;
        }
    }

    //getters
    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public int getDuration() {
        return duration;
    }
    public int getLikes() {
        return likes;
    }
}
