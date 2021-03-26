package heapSort;
import java.util.Scanner;

public class heapSort4 {
    static void swap(int heap[],int i,int j) {
        int temp=0;
        temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    static int deleteHeap(int []heap){
        int min=heap[1];
        int l=1;
        int n= heap[heap[0]];
        heap[0]--;
        while (l<=heap[0]) {
            if (l*2>heap[0]) { //자식이 없을경우
                 heap[l]=n;
                 return min;
            }
            if (l*2==heap[0]) { //왼쪽 자식만 있을경
                if (n<heap[heap[0]]) { //왼쪽 자식이랑 n이랑 비교
                    heap[l]=n;
                    return min;
                }
                else {
                    heap[l] = heap[l * 2];
                    heap[l*2] = n;
                    return min;
                }
            }
            if (heap[l*2] > heap[(l*2)+1]) { //오른쪽이 가장 작을 경우
                 if (n>heap[(l*2)+1]) {
                     heap[l] = heap[(l * 2) + 1];
                     l = (l * 2) + 1;
                 }
            }
            else if (n<heap[(l*2)+1]) {  //n이 가장 작을 경우
                if (n<heap[(l*2)]) {
                    heap[l]=n;
                    return min;
                }
            }
            else {   //왼쪽이 가장 작을 경을 경
                heap[l]=heap[l*2];
                l*=2;
            }
        }
        return min;
    }

    static void print(int []heap)
    {
        for (int i=0;i<=heap.length-1;i++)
        {
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
    static void init(int []heap)
    {
        Scanner scanf = new Scanner(System.in);
        int[] cnt=new int[1];
        cnt[0]=0;
        int data=0;
        while((data = scanf.nextInt()) > 0) {
            heap[++cnt[0]] = data;
            int current = cnt[0];
            while(current!=1)
            {
                if (heap[current] < heap[current / 2])
                {
                    swap(heap, current, current / 2);
                }
                current=current/2;
            }
        }
        heap[0] = cnt[0];
        print(heap);

    }

    public static void main(String[] args) {
        System.out.println("배열의 사이즈를 입력하시오");
        Scanner scanf = new Scanner(System.in);
        int heap[] = new int[scanf.nextInt()];
        init(heap);
        int root=0;
        while (heap[0]>0) {
            root = deleteHeap(heap);
            System.out.println(root);
        }
    }
}