import java.util.ArrayList;
import java.util.List;

public class mymain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] list = {1,2,3,4,5,6};
		rotate(list, 6, "right");
	}
	
	public static void rotate (int[] list, int num, String dir) {
		int len = list.length;
		int [] res = new int[len];
		if(dir.equals("right")) {
			int j=0;
			for(int i=len-num; i<len;i++, j++) {
				res[j] = list[i] ;
			}
//			j--;
			for(int i=0; i<len-num; i++,j++) {
				res[j]=list[i];
			}
		}
		for(int x:res) {
			System.out.print(x);
		}
		
	}

}
