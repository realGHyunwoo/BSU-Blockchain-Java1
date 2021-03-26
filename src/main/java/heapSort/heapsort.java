//package heapSort;
//import java.util.Scanner;
//
//public class heapSort {
//    static void swap(int heap[],int i,int j) {
//        int temp=0;
//        temp = heap[i];
//        heap[i] = heap[j];
//        heap[j] = temp;
//    }
//    static void deleteHeap(int []heap,int []heap2,int[] cnt,int[] cntHeap){
//
//        cntHeap[0]++;
//        heap2[0]=-(heap2.length - cntHeap[0]);
//        heap2[cntHeap[0]]=heap[1];
//        swap(heap,1,cnt[0]);
//        cnt[0]--;
//        if (heap2[0]==-1) print(heap2);
//        else Minheapify(heap, heap2, cnt, cntHeap);
//    }
//    static void Minheapify(int []heap,int []heap2,int[] cnt,int[] cntHeap){
//        for (int leaf=cnt[0]; leaf>=(cnt[0]/2)+1;leaf--) //loop 1번만 돌려서 수정 : 성능 향상
//        {
//            int current=leaf;
//            while(current!=1)
//            {
//                if (heap[current] < heap[current / 2])
//                {
//                    swap(heap, current, current / 2);
//                }
//                current=current/2;
//            }
//        }
//        print(heap);
//        deleteHeap(heap,heap2,cnt,cntHeap);
//    }
//    static void print(int []heap)
//    {
//        for (int i=0;i<=heap.length-1;i++)
//        {
//            System.out.print(heap[i]+" ");
//        }
//        System.out.println();
//    }
//    static void init(int []heap)
//    {
//        Scanner scanf = new Scanner(System.in);
//        int[] cnt=new int[1];
//        cnt[0]=0;
//        int data=0;
//        int[] cntHeap = new int[1];
//        cntHeap[0]=0;
//        while((data = scanf.nextInt()) > 0) {
//            heap[++cnt[0]] = data;
//        }
//        heap[0] = -(cnt[0]);
//        print(heap);
//        int heap2[]=new int[cnt[0]+1];
//        Minheapify(heap,heap2,cnt,cntHeap);
//    }
//
//    public static void main(String[] args) {
//        System.out.println("배열의 사이즈를 입력하시오");
//        Scanner scanf = new Scanner(System.in);
//        int heap[] = new int[scanf.nextInt()];
//        init(heap);
//    }
//}