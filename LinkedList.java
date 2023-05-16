public class LinkedList {
  String name;
  Node head; // First Song of the Playlist
  Node tail; // Last Song of the Playlist
  Node currNode; // Current Song of the Playlist

  LinkedList( String playlistName){
    this.name = playlistName;
    this.head = null;
    this.tail = null;
    this.currNode = null;
  }

  // ***** Prerna *****

  // Add a song to the playlist
  // Suggestion: You can also add Song Spotify URL if you want to the node if u want. Jus let me know if u do that.
  public void addSong(String t, String dur){
    // Adding Song from end of the DLL

    // =================================================================

    // Precond: t and dur are the title and duration as input in the command prompt
    // Effect : a new node is created and added to the beginning of the doubly linked list. The title t and
    // duration d is applied to the new node. If the list is empty, a new node is created as the starting node of
    // the list.

    // =================================================================

    // Code Here : 
    // Note: Handle head and tail nodes here

  }

//   Delete a song from the playlist
public void deleteAtPos(int pos){
    // - Delete a song based on a position in the linked list which is input through a prompt
    // - Ensure the input position is a valid one

    // =================================================================

    // Precond: Playlist is already populated with multiple nodes using addSong()
    // Effect: Deletes the song at position pos input in the command prompt. Ensure the position is a valid one.

    // =================================================================

    // Code Here :
    // Note: Handle head, tail and current nodes here

  }

// ***********************************************************************************************************************


  // ***** Afsar *****
  // Find a song by name
  public int findSong(String t){
    // - Prompt for the song name. Exact name matching is fine. Partial match is not required.

    // =================================================================

    // Precond : Playlist is already populated with multiple nodes using addSong()
    // Effect : the program finds the exact match of the song t and returns the track number / position of the
    // song in the playlist.

    // =================================================================

    // Code Here :
    // Note: Update Current Node as Searched Song


    return -1;
  }

// ***********************************************************************************************************************


  // ***** Chandan *****
  // Next track / Previous track
  public String getSongAtPos(int pos){
    // - First prompt for a starting position and then traverse forward or backward based on user
    // input. This should be done through a sub menu.
    // - Ensure relevant messages are displayed when the beginning and end of the playlist is
    // reached.

    // ====================================================================================

    // Precond : Playlist is already populated with multiple nodes using addSong()
    // Effect: Returns the song title at the given position. This is used to traverse the playlist (next track /
    // previous track)

    // ====================================================================================
    // Code Here :
    // Note: Display Current Node Song if 'pos' is empty and change it according to P or N option.

    return "";
  }  

  // Display playlist
  public void display(){
    // - Display all songs in the playlist

    // ====================================================================================

    //  Precond: none
    //  Effect : Displays the position, song title and duration of all the songs in the playlist.

    // =================================================================================
    // Code Here :
    // Note: Keep option to display song url link also while displaying all the song.
    
  }

// ***********************************************************************************************************************


  // ***** Harshwardhan *****
  // Sort playlist by song title
  public void sortList(){
    // Use one of the standard sorting algorithms

    // ====================================================================================

    // Precond : Playlist is already populated with multiple nodes using addSong()
    // Effect : Sorts the songs in the playlist in alphabetical order based on the song title
    
    // ====================================================================================

    // Code Here :
  }
}
