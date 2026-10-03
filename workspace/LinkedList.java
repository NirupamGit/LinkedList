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
  
  //pre condition: the list has been initialized
  //post condition: reverses the entire linked list such that the tail node is the head node and head node is the tail node
  public void reverse() {
    if (head == null){
      return ;
    }
    ListNode prev=null;
    ListNode curr=head;
    if(curr.getNext() == null){
      return ;
    }
    ListNode next=curr.getNext();

    while (curr!=null) {
      //link the current node to previous
      System.out.println("reversing "+curr.getValue());
      System.out.println("going to link it to"+(prev==null ? null : prev.getValue()));
      curr.setNext(prev);
      prev = curr;
      curr = next;
      if (next!= null) {
      next = next.getNext();
      }
      head=prev;
    }
    return;
    
  }

  //pre condition: the linked list has been initialized
  //post condition: take n chunk of nodes and reverse them. if there aren't enough nodes at the end, those nodes aren't reversed
  public void nReverse(ListNode list, int n) {
    if (head == null){
      return ;
    }
    ListNode prev=null;
    ListNode curr=head;
    ListNode next=curr.getNext();
    if(curr.getNext() == null){
      return ;
    }
    while (curr!=null) {
      ListNode checkNext=curr;
      int count = 0;  
      while (checkNext!=null) {
        checkNext=checkNext.getNext();
        count++;
      }
      if(count<n) {
        return;
      }
    }
    for (int i =0; i<n; i++) {
      next=curr.getNext();
      prev=curr;
    }
    return;

  }

}
