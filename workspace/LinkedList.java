/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
//Nirupam S. Vadigi
//This class contains the code used to add, remove, and show values of a llinked list
import java.util.List;

public class LinkedList {

  // instance varialbes go here (think about what you need to keep track of!)
  ListNode head;

  public LinkedList() {
    head = null;
  }

  // constructors go here

  // precondition: the list has been initialized
  // postcondition: the ListNode containing the appropriate value has been added
  // and returned
  public ListNode addAValue(String line) {
    ListNode prevNode = head;
    ListNode newNode = new ListNode(line, null);
    // what if we need to insert in the front?
    if (head == null) {
      head = newNode;
      return head;
    }

    // everywhere else

    // keep searching through the linked list by doing temp = temp.getNext() until
    // you either find the end of the list or you find the "right " spot
    ListNode currentNode = head;
    while (currentNode != null && line.compareTo(currentNode.getValue()) > 0) {
      prevNode = currentNode;
      currentNode = currentNode.getNext();
    }
    prevNode.setNext(newNode);
    newNode.setNext(currentNode);
    return newNode;
  }

  // precondition: the list has been initialized
  // postcondition: the ListNode containing the appropriate value has been deleted
  // and returned.
  // if the value is not in the list returns null
  public ListNode deleteAValue(String line) {
    if (head == null) {
      return new ListNode(line+" not found in LinkedList", null);
    }
    ListNode prevNode = null;
    ListNode nextNode = head;
    while (nextNode != null && nextNode.getValue().compareTo(line) != 0) {
      prevNode = nextNode;
      nextNode = nextNode.getNext();
    }

    if (nextNode != null && nextNode.getValue().compareTo(line) == 0) {
      
      if (prevNode == null) { 
        head = nextNode.getNext();
      } else {
        prevNode.setNext(nextNode.getNext());
      }
      return nextNode;
    }
    // No match found
    return new ListNode(line+" not found in LinkedList", null);
  }

  // precondition: the list has been initialized
  // postconditions: returns a string containing all values appended together with
  // spaces between.
  public String showValues() {
    String str = "";
    for (ListNode l = head; l != null; l = l.getNext()) {
      str = str + " " + l.getValue();
    }
    return str;
  }

  // precondition: the list has been initialized
  // postconditions: clears the list.
  public void clear() {
    head = null;
  }
  
  // public String reverse() {
  //   if (head == null){
  //     return "null";
  //   }
  //   ListNode prev=head;
  //   ListNode curr=prev.getNext();
  //   if(curr == null){
  //     return head.getValue();
  //   }
  //   ListNode next=curr.getNext();

  //   while (curr!=null) {
  //     //link the current node to previous
  //     curr.setNext(prev);
  //     prev=prev.getNext();
      
  //   }
  //   return null;
    
  // }
}
