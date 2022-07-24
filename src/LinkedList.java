
public class LinkedList<T> {

	public Node<T> head;
	private int length=0;
	
	public LinkedList() {
		this.head = null;
	}
	
	public int size() {
		return length;
	}
	
	public void add(T data) {
		Node<T> node = new Node<>(data);
		
		if(isEmpty()) {
			head = node;
		} else {
			Node<T> tmp = head;
			while(tmp.next!=null) {
				tmp = tmp.next;
			}
			tmp.next = node;
		}
		length++;
	}
	
	public void add(int index, T data) {
		if(index > length) {
			throw new IndexOutOfBoundsException();
		} 
		
		if(index == 0) {
			Node<T> nd = new Node<T>(data, head);
			head = nd;
			length++;
			return;
		}
		
		int count=0;
		Node<T> tmp = head;
		while(count<index-1) {
			tmp = tmp.next;
			count ++;
		}
		Node<T> n = tmp.next;
		tmp.next = new Node<T>(data, n);
		length++;
	}
	
	public Boolean isEmpty() {
		if(head==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void remove(int index) {
		if(index>=length) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			Node<T> n = head;
			head = head.next;
			n.next = null;
			length--;
			return;
		}
		
		int count=0;
		Node<T> tmp = head;
		while(count<index-1) {
			tmp = tmp.next;
			count ++;
		}
		Node<T> n = tmp.next;
		tmp.next = tmp.next.next;
		n.next = null;
		length--;
	}
	
	public void reverse() {
		Node<T> prev = null;
		Node<T> curr = head;
		while(curr!=null) {
			Node<T> n = curr.next;
			curr.next=prev;
			prev=curr;
			curr=n;
		}
		head = prev;
	}
	
	public Node<T> reverse(Node<T> head) {
		if(head==null || head.next==null) {
			return head;
		}
		Node<T> newHead = reverse(head.next);
		Node<T> headNext = head.next;
		headNext.next = head;
		head.next = null;
		return newHead;
	}
	
	public Node<T> getTail(){
		Node<T> n = head;
		while(n!=null && n.next!=null) {
			n = n.next;
		}
		return n;
	}
	
	public Node<T> getMid(){
		Node<T> slow = head;
		Node<T> fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public Node<T> detectCycle(){
		Node<T> slow = head;
		Node<T> fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast==slow) {
				break;
			}
		}
		if(fast==null || fast.next==null) {
			return null;
		} else {
			return fast;
		}
	}

	
	public void removeCycle(Node<T> n) {
		Node<T> tmp = head;
		while(n.next!=tmp.next) {
			tmp = tmp.next;
			n=n.next;
		}
		n.next=null;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "";
		}
		Node<T> tmp = head;
		StringBuilder str = new StringBuilder("{");
		
		while(tmp.next!=null) {
			str.append(String.valueOf(tmp.data)+ " -> ");
			tmp = tmp.next;
		}
		str.append(String.valueOf(tmp.data));
		str.append("}");
		
		return str.toString();
	}
	
}
