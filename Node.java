public class Node {
  private String song; // "name"
  private String duration; // "min:seconds"
  private String songLink; // "Spotify URL of the song"
  Node next;
  Node prev;

  void setSong(String t) {
    this.song = t;
  }

  void setDuration(String dur) {
    this.duration = dur;
  }

  void setSongLink(String t) {  
    this.songLink = t;
  }

  String getSong() {
    return song;
  }

  String getDuration() {
    return duration;
  }

  String getSongLink() {
    return songLink;
  }


}
