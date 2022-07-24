
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l = new LinkedList<>();
//		System.out.println(l);
		l.add(8);
		l.add(10);
		l.add(15);
		l.add(20);
		l.add(0, 3);
		l.add(3, 99);
//		l.add(50);
		System.out.println(l);
		
		Node<Integer> tail = l.getTail();
		Node<Integer> mid = l.getMid();
		System.out.println(mid.data + ", "+tail.data);
		
		tail.next=mid;
		Node<Integer> cycle = l.detectCycle();
		System.out.println(cycle.data);
		l.removeCycle(cycle);
		System.out.println(l);
		
	}
}
