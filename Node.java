public class Node {
  private String song; // "name"
  private String duration; // "min:seconds"
  Node next;
  Node prev;

  void setSong(String t) {
    this.song = t;
  }

  void setDuration(String dur) {
    this.duration = dur;
  }

  String getSong() {
    return song;
  }

  String getDuration() {
    return duration;
  }


}
