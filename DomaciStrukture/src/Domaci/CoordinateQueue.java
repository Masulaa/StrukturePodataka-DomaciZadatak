package Domaci;

public class CoordinateQueue {

    private static class CoordinateNode {
        int row;
        int col;
        CoordinateNode next;

        CoordinateNode(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private CoordinateNode head;
    private CoordinateNode tail;

    public void enqueue(int row, int col) {
        CoordinateNode newNode = new CoordinateNode(row, col);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Coordinate dequeue() {
        if (head == null) return null;

        Coordinate coord = new Coordinate(head.row, head.col);

        head = head.next;

        if (head == null) {
            tail = null;
        }

        return coord;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
}