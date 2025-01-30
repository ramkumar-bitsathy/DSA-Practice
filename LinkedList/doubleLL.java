class DLLNode{
    DLLNode prev = null;
    DLLNode next = null;
    int val = 0;
    DLLNode(int val){
        this.val = val; 
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\nnull <-- ");
        DLLNode current = this;
        while (current != null) {
            result.append(current.val).append(" <--> ");
            current = current.next;
        }
        result.append("null\n");
        return result.toString();
    }
}


class DoubleLinkedList{
    public DLLNode head;public DLLNode tail;

    public DLLNode getRootNode(){
        return head;
    }

    public void addToFront(int data){
        DLLNode node = new DLLNode(data);

        if(head==null){
            head = tail = node;
        }
        else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void addToEnd(int data){
        DLLNode node = new DLLNode(data);
        if (head == null){
            head = tail = node;
        }
        else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void printHeadToTail(){
        DLLNode h = head;
        System.out.print("Head to Tail: null <-- ");
        while(h!=null){
            if (h.next!=null)
            System.out.print(h.val + " <--> ");
            else{
                System.out.print(h.val+" --> null\n\n");
            }
            h = h.next;
        }
    }
    public void printTailToHead(){
        DLLNode t = tail;
        System.out.print("Tail to Head: null <-- ");
        while(t!=null){
            if (t.prev!=null)
            System.out.print(t.val + " <--> ");
            else{
                System.out.print(t.val+" --> null\n\n");
            }
            t = t.prev;
        }
    }
}

public class doubleLL {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addToFront(10);
        list.addToFront(20);
        list.addToEnd(40);
        System.out.println(list.head);

        DLLNode root = list.getRootNode();
        System.out.println(root.val+" "+root.next.val);

        list.printHeadToTail();
        list.printTailToHead();
    }
}
