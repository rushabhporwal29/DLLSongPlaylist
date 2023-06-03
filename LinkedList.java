import java.util.Scanner;

public class LinkedList {
  String name;
  Node head; // First Song of the Playlist
  Node tail; // Last Song of the Playlist
  Node currNode; // Current Song of the Playlist

  LinkedList(String playlistName) {
    this.name = playlistName;
    this.head = null;
    this.tail = null;
    this.currNode = null;
  }

  // ***** Prerna *****

  // Add a song to the playlist
  // Suggestion: You can also add Song Spotify URL if you want to the node if u
  // want. Jus let me know if u do that.
  public void addSong(String t, String dur) {
    // Adding Song from end of the DLL

    // =================================================================

    // Precond: t and dur are the title and duration as input in the command prompt
    // Effect : a new node is created and added to the beginning of the doubly
    // linked list. The title t and
    // duration d is applied to the new node. If the list is empty, a new node is
    // created as the starting node of
    // the list.

    // =================================================================

    // Code Here :
    // Note: Handle head and tail nodes here

    if (findDuplicate(t) != -1) {
      System.out.println("The song '" + t + "' already exists in the playlist.");
      return;
    }

    String[] durationParts = dur.split(":");
    if (durationParts.length != 2) {
      System.out.println("Invalid duration format. Please try again.");
      return;
    }

    int minutes, seconds;
    try {
      minutes = Integer.parseInt(durationParts[0]);
      seconds = Integer.parseInt(durationParts[1]);

      if (seconds >= 60) {
        throw new IllegalArgumentException("Invalid duration format. Seconds must be less than 60, Please try again");
      }
    } catch (NumberFormatException e) {
      System.out.println("Invalid duration format. Please try again.");
      return;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return;
    }

    Node newSong = new Node();
    newSong.setSong(t);
    newSong.setDuration(dur);

    if (head == null) {
      head = tail = newSong;
      head.prev = null;
      tail.next = null;
    } else {
      tail.next = newSong;
      newSong.prev = tail;
      tail = newSong;
      tail.next = null;
    }

    currNode = tail;
    System.out.println("Added the song '" + t + "' to the playlist successfully :)");
  }

  public int findDuplicate(String t) {
    Node current = head;
    int position = 1;

    while (current != null) {
      if (current.getSong().equalsIgnoreCase(t)) {
        return position;
      }
      current = current.next;
      position++;
    }
    return -1;
}

  // Delete a song from the playlist
  public int deleteAtPos(int pos) {
    // - Delete a song based on a position in the linked list which is input through
    // a prompt
    // - Ensure the input position is a valid one

    // =================================================================

    // Precond: Playlist is already populated with multiple nodes using addSong()
    // Effect: Deletes the song at position pos input in the command prompt. Ensure
    // the position is a valid one.

    // =================================================================

    // Code Here :
    // Note: Handle head, tail and current nodes here

    if (head == null) {
      return 0;
    }

    if ( pos <= 0){
      return -1;
    }

    if (pos == 1) {
      head = head.next;
      if (head != null) {
        head.prev = null;
      } else {
        tail = null;
      }
      return 1;
    }

    Node curr = head;
    int currentPosition = 1;
    while (curr != null && currentPosition < pos) {
      curr = curr.next;
      currentPosition++;
    }

    if (curr == null) {
      return -1; // position is greater than the number of nodes in the list
    }

    if (curr == tail) {
      tail = tail.prev;
      tail.next = null;
    } else {
      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;
    }

    return 1; 

  }

  // ***********************************************************************************************************************

  // ***** Afsar *****
  // Find a song by name
  public int findSong(String t) {
    // - Prompt for the song name. Exact name matching is fine. Partial match is not
    // required.

    // =================================================================

    // Precond : Playlist is already populated with multiple nodes using addSong()
    // Effect : the program finds the exact match of the song t and returns the
    // track number / position of the
    // song in the playlist.

    // =================================================================

    // Code Here :

    Node curr = head;
    if (head == null) {
      return -2;
    }
    int index = 0;

    while (curr != null) {
      String song = curr.getSong();
      if (song.equalsIgnoreCase(t)) {
        currNode = curr;
        return index + 1;
      }
      curr = curr.next;
      index++;
    }
    // Note: Update Current Node as Searched Song
    return -1;
  }

  // ***********************************************************************************************************************

  // ***** Chandan *****
  // Next track / Previous track
  public String getSongAtPos(int pos) {
    // - First prompt for a starting position and then traverse forward or backward
    // based on user
    // input. This should be done through a sub menu.
    // - Ensure relevant messages are displayed when the beginning and end of the
    // playlist is
    // reached.

    // ====================================================================================

    // Precond : Playlist is already populated with multiple nodes using addSong()
    // Effect: Returns the song title at the given position. This is used to
    // traverse the playlist (next track /
    // previous track)

    // ====================================================================================
    // Code Here :
    // Note: Display Current Node Song if 'pos' is empty and change it according to
    // P or N option.

    if (head == null) {
      System.out.println("The playlist is empty.");
      return "";
    }

    if (pos <= 0) {
      System.out.println("Invalid position. Position must be greater than 0.");
      return "";
    }

    Node current = head;
    int position = 1;

    while (current != null && position < pos) {
      current = current.next;
      position++;
    }

    if (current == null) {
      System.out.println("WARNING:End of playlist reached.");
      return "";
    }

    Scanner scanner = new Scanner(System.in);
    String userInput;

    while (true) {
      System.out.println("Current Song is  " + pos + ". " + current.getSong() + "  < " + current.getDuration() + " >  ");
      System.out.print("Enter 'N' for next track, 'P' for previous track, or 'E' to exit: ");
      userInput = scanner.nextLine().trim().toUpperCase();

      if (userInput.equals("N")) {
        if (current.next != null) {
          current = current.next;
          pos++;
        } else {
          System.out.println("WARNING:End of playlist reached.");
        }
      } else if (userInput.equals("P")) {
        if (current.prev != null) {
          current = current.prev;
          pos--;
        } else {
          System.out.println("WARNING:Beginning of playlist reached");
        }
      } else if (userInput.equals("E")) {
        break;
      } else {
        System.out.println("Invalid input. Please try again.");
      }
    }
    scanner.close();
    return current.getSong();
  }

  // Display playlist
  public void display() {
    // - Display all songs in the playlist

    // ====================================================================================

    // Precond: none
    // Effect : Displays the position, song title and duration of all the songs in
    // the playlist.

    // =================================================================================
    // Code Here :
    // Note: Keep option to display song url link also while displaying all the
    // song.

    if (head == null) {
      System.out.println("The playlist is empty. Please Add a song to the playlist First!");
      return;
    }

    Node current = head;
    System.out.println("Playlist Songs:");
    int position = 1;
    while (current != null) {
      System.out.println(
          position + ". " + current.getSong() + "  <" + current.getDuration() + ">  "); //+ current.getSongLink());
      current = current.next;
      position++;
    }

  }

  // ***********************************************************************************************************************

  // ***** Harshwardhan *****
  // Sort playlist by song title
  public void sortList() {
    // Use one of the standard sorting algorithms

    // ====================================================================================

    // Precond : Playlist is already populated with multiple nodes using addSong()
    // Effect : Sorts the songs in the playlist in alphabetical order based on the
    // song title

    // ====================================================================================

    // Code Here :
        
     // Call the recursive QuickSort
     _quickSort(this.head, this.tail);

  }


  // Considers last element as pivot, places the pivot element at its correct position in sorted array,
  // and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
  public Node partition(Node low, Node high){

    // set high as pivot element
    String x = high.getSong();
    Node i = low.prev;

    for(Node j = low; j != high; j = j.next){
      if( j.getSong().compareTo(x) <= 0){
        i = (i == null) ? low : i.next;
        String temp = i.getSong();
        String temp_dur = i.getDuration();
        i.setSong(j.getSong());
        i.setDuration(j.getDuration());
        j.setSong(temp);
        j.setDuration(temp_dur);
      }
    }

    i = (i == null) ? low : i.next;
    String temp = i.getSong();
    String temp_dur = i.getDuration();
    i.setSong(high.getSong());
    i.setDuration(high.getDuration());
    high.setSong(temp);
    high.setDuration(temp_dur);

    return i;
  }

  void _quickSort(Node l,Node h)
  {
      if(h!=null && l!=h && l!=h.next){
          Node temp = partition(l,h);
          _quickSort(l,temp.prev);
          _quickSort(temp.next,h);
      }
  }
     
}
