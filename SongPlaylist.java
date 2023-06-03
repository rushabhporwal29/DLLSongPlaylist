import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SongPlaylist {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("######WELCOME TO OUR SONG PLAYLIST APPLICATION #######");
    System.out.println("*****Create a New Playlist*****");
    System.out.print("Enter the Playlist Name: ");
    String playlistName = sc.nextLine();
    LinkedList playlist = new LinkedList(playlistName);
    while (true) {
      try{
      // System.out.println("Clear Console");
      clearConsole();
      System.out.println(playlistName + " - Playlist Operations :   ");
      System.out.println("1. Add a song to the playlist");
      System.out.println("2. Delete a song from the playlist");
      System.out.println("3. Find a song by name");
      // System.out.println("4. Next track / Previous track ");
      System.out.println("4. Get Song by Position");
      System.out.println("5. Sort playlist by song title");
      System.out.println("6. Display playlist");
      System.out.println("0. Exit");
      System.out.println("Enter Menu Option : ");
      int choice ;
      choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          System.out.println("*****Add New Song*****");
          System.out.println("Enter Song Title : ");
          String newSongTitle = sc.nextLine();
          System.out.println("Enter Song Duration (mm:ss): ");
          String newSongDuration = sc.next();
          // System.out.println("Enter Song URL: ");
          // String newSongURL = sc.next();
          playlist.addSong(newSongTitle, newSongDuration);
          break;
        case 2:
          System.out.println("*****Delete A Song Based on Position*****");
          System.out.println("Enter Postion of Song to be Deleted : ");
          int songPos = sc.nextInt();
          int resDel = playlist.deleteAtPos(songPos);
          if (resDel == 1) {
            System.out.println("Song Deleted from the playlist successfully :)");
          } else if (resDel == 0) {
            System.out.println("Your Playlist is empty. Please try again later !!!");
          } else {
            System.out.println("Invalid Song Position. Please try again later !!!");
          }
          break;
        case 3:
          System.out.println("*****Find A Song from Playlist*****");
          System.out.println("Enter Name of Song to be Searched : ");
          String songName = sc.nextLine();
          int resSearch = playlist.findSong(songName);
          if (resSearch == -1) {
            System.out.println("Couldn't find the song " + songName + " in the Playlist. Please try again !!!");
          } else if (resSearch == -2) {
            System.out.println("Your Playlist is empty. Please try again later !!!");
          } else {
            System.out.println("Position of Your Song is: " + resSearch);
            playlist.getSongAtPos(resSearch);
          }
          break;
        case 4:
          // System.out.println("*****Track Current Song in Playlist*****");
          System.out.println("*****Get Song By Playlist*****");
          System.out.println("Enter Song Postion : ");
          int pos = sc.nextInt();
          sc.nextLine();
          playlist.getSongAtPos(pos);
          break;
        case 5:
          System.out.println("*****Sorting The Playlist Based on Song Name*****");
          playlist.sortList();
          System.out.println("Playlist Sorted Successfully :) \n Check Display Playlist Option to check the Sorted Playlist Order.");

          break;
        case 6:
          System.out.println("*****Displaying The Complete Playlist*****");
          playlist.display();
          break;
        case 0:
          System.out.println("Thank You for using this Application :)");
          sc.close();
          return;

        default:
          System.out.println("Incorrect Choice. Please try again !!!");
          break;
      }

      System.out.println("Go Back to Menu (1) or Exit (0) : ");
      choice = sc.nextInt();
      sc.nextLine();
      if (choice == 0) {
        System.out.println("Thank You for using this Application :)");
        sc.close();
        return;
      }
    }

    catch(Exception e){
      System.out.println("Something went wrong[invalid input exception],Thank You for using this Application :)");
      sc.close();
      return;
    }
    }

  }

  public final static void clearConsole() {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {
    }
  }
}
