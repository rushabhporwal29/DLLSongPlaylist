import java.util.Scanner;

public class SongPlaylist {
  public static void main( String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("*****Create a New Playlist*****");
    System.out.print("Enter the Playlist Name: ");
    String playlistName = sc.nextLine();
    LinkedList playlist = new LinkedList(playlistName);
    while (true) {
      System.out.println("Playlist Operations :   ");
      System.out.println("1. Add a song to the playlist");
      System.out.println("2. Delete a song from the playlist");
      System.out.println("3. Find a song by name");
      System.out.println("4. Next track / Previous track ");
      System.out.println("5. Sort playlist by song title");
      System.out.println("6. Display playlist");
      System.out.println("0. Exit");
      System.out.println("Enter Menu Option : ");
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          System.out.println("*****Add New Song*****");
          System.out.println("Enter Song Title : ");
          String newSongTitle = sc.next();
          System.out.println("Enter Song Duration : ");
          String newSongDuration = sc.next();
          System.out.println("Enter Song URL: ");
          String newSongURL = sc.next();
          playlist.addSong(newSongTitle, newSongDuration);
          System.out.println("Added the song '"+newSongTitle+"' to the playlist");
          break;
        case 2:
          System.out.println("*****Delete A Song Based on Position*****");
          System.out.println("Enter Postion of Song to be Deleted : ");
          int songPos = sc.nextInt();
          playlist.deleteAtPos(songPos);
          System.out.println("Song Deleted from the playlist successfully !!!");
          break;
        case 3:
          System.out.println("*****Find A Song from Playlist*****");
          System.out.println("Enter Name of Song to be Searched : ");
          String songName = sc.next();
          int res = playlist.findSong(songName);
          if (res == -1){
            System.out.println("Couldn't find the song " + songName + " in the Playlist. Please try again !!!");
          } else if (res == -2){
            System.out.println("Your Playlist is empty. Please try again later !!!");
          } else {
            System.out.println("Position of Your Song is: " + res);
            playlist.getSongAtPos(res);
          }
          break;
        case 4:
          System.out.println("*****Track Current Song in Playlist*****");
          System.out.println("Enter Name of Song to be Searched : ");
          int pos = sc.nextInt();
          playlist.getSongAtPos(pos);
          break;
        case 5:
          System.out.println("*****Sorting The Playlist Based on Song Name*****");
          playlist.sortList();
          System.out.println("Playlist Sorted Successfully :) \n Check Display Playlist Option to check the order.");

          break;
        case 6:
          System.out.println("*****Displaying The Complete Playlist*****");
          playlist.display();
          break;
        case 0:
          System.out.println("Thank You for using this Application :)");
          return;
        
        default:
          System.out.println("Incorrect Choice. Please try again !!!");
          break;
      }

    }

  }
}
