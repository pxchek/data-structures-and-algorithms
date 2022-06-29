import java.util.Set;
import java.util.HashSet;

final class Node {
	private int data;
	private Node next;
	private Node front;
	private Node rear;
	
	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}
	
	public boolean insert(final Node node) {
		if(node == null) {
			return false;
		}

		if(front == null) {
			front = node;
			rear = node;
		} else {
			rear.next = node;
			rear = node;
		}

		return true;
	}
	

	//Time complexity - O(n)
	//Space complexity - O(n)
	public void removeDuplicates(final Node node) {
		final Set<Integer> data = new HashSet<>();
		
		Node currentNode = front;
		Node previousNode = null;
		
		while(currentNode != null) {
			if(!data.contains(currentNode.getData())) {
				data.add(currentNode.getData());
				previousNode = currentNode;		
			} else {
				previousNode.next = currentNode.getNext();
			}
			currentNode = currentNode.getNext();   		
		}	
	}
}	



