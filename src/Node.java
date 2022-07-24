import java.util.Objects;

public class Node<T> {

	public Node<T> next;
	public T data;
	
	public Node(T data) {
		this.next = null;
		this.data = data;
	}
	
	public Node(T data, Node<T> node) {
		this.next = node;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [next=" + next + ", data=" + data + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, next);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<T> other = (Node<T>) obj;
		return Objects.equals(data, other.data) && Objects.equals(next, other.next);
	}
	
}
