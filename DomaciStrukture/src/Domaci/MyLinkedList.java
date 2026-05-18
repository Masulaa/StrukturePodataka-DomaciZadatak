package Domaci;

public class MyLinkedList {

    private NodeMove head;

    public void insert(Move move) {
        NodeMove newNode = new NodeMove(move);

        if (head == null) {
            head = newNode;
        } else {
            NodeMove temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public NodeMove getHead() {
        return head;
    }
}