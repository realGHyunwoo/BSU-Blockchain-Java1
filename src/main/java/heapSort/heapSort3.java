//package heapSort;
//import  java.util.Scanner;
//import  java.util.Random;
//
//public class heapSort3 {
//
//    static int[] heapInit(){
//        Scanner scanner = new Scanner(System.in);
//        int size=2;
//        int[] heap=new int[1];
//        int data;
//        int i=1;
//        System.out.println("배열 값을 입력하시오. : (0이하 입력시 종료)");
//        while((data=scanner.nextInt())>0){
//            int[] temp=new int[size++];
//            for(int j=1;j<heap.length;j++){
//                temp[j]=heap[j];
//            }
//            temp[temp.length-1]=data;
//            heap=temp;
//        }
//        heap[0]=-heap.length+1;
//        return heap;
//    }
//
//    static void show(int[] heap) {
//        for (int i = 0; i < heap.length; i++) {
//            System.out.print(heap[i] + " ");
//        }
//        System.out.println();
//    }
//    static void swap(int[] heap,int i1,int i2){
//        int temp=heap[i1];
//        heap[i1]=heap[i2];
//        heap[i2]=temp;
//    }
//    static void makeHeap(int[] heap) {
////        for (int i = (heap.length - 1) / 2 + 1; i < heap.length; i++) {
////            int current = i;
////
////            while (current > 1) {
////                int parent = current / 2;
////
////                if (heap[current] > heap[parent]) {
////                    swap(heap, current, parent);
////                }
////                current = parent;
////            }
//
//        for(int i=(heap.length-1)/2; i>0; i-- ){
//            makeHeap2(heap,i, heap.length);
//        }
//    }
////    static void makeHeap2(int[] heap,int i,int len) {
////        int max;
////        if (i * 2 + 1 < len) {
////            if (heap[i * 2] >= heap[i * 2 + 1])
////                max = i * 2;
////            else
////                max = i * 2 + 1;
////            if (heap[i] < heap[max]) {
////                swap(heap, i, max);
////
////            if (max * 2 < len)
////                makeHeap2(heap, max,len);
////            }
////        }else{
////                if (heap[i] < heap[i*2])
////                    swap(heap, i, i*2);
////            }
////    }
//
//    static void makeHeap2(int[] heap,int i,int len) {
//
//        if(i*2>len-1)
//            return;
//
//        if(i*2==len-1){
//            if(heap[i]<heap[i*2]) {
//                swap(heap, i, i * 2);
//                show(heap);
//            }
//        }
//        else {
//            if (heap[i] < heap[i * 2] && heap[i * 2] > heap[i * 2 + 1]) {
//                swap(heap, i, i * 2);
//                show(heap);
//                makeHeap2(heap, i * 2, len);
//
//            } else if (heap[i] < heap[i * 2 + 1] && heap[i * 2] < heap[i * 2 + 1]) {
//                swap(heap, i, i * 2 + 1);
//                show(heap);
//                makeHeap2(heap, i * 2 + 1, len);
//            }
//        }
//    }
//
//    static void sort(int[] heap){
//        makeHeap(heap);
//        for(int i=0; i<heap.length-2;i++){
//
//            swap(heap,1,heap.length-i-1);
//            //show(heap);
//            //if(i!=heap.length-3)
//            makeHeap2(heap,1,heap.length-i-1);
//
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//
//
//
//        int[] heap=heapInit();
//        show(heap);
//        makeHeap(heap);
//        show(heap);
//        sort(heap);
//        show(heap);
//
//
//
//    }
//}