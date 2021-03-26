//package mergeSort_linkedList;
//
//import java.util.Arrays;
//import java.util.Random;
//import java.util.Scanner;
//
//class Node {
//    private int data;
//    private Node next;
//    public Node () {
//        next=null;
//        data=0;
//    }
//    public Node(int data) {
//        this.data=data;
//        this.next=null;
//    }
//
//    @Override
//    public String toString() {
//        return "Node{" +
//                "data=" + data +
//                ", next=" + next +
//                '}';
//    }
//
//    public int getData() { return data; }
//    public void setData(int data) { this.data = data; }
//    public Node getNext() { return next; }
//    public void setNext(Node next) { this.next = next; }
//
//}
//
//class linkedList {
//    private Node head = new Node();
//    public Node getHead() { return head; }
//    public void setHead(Node head) { this.head = head; }
//
//    public linkedList(){}
//    public linkedList(Node node){
//        head.setNext(node);
//    }
//
//    public void insertNode(int num) { //전역함수
//        Node check = new Node();
//        int size=1;
//        check = head;
//        while(check.getNext()!=null) {
//            check = check.getNext();
//            size++;
//        }
//        Node next = new Node();
//        check.setNext(next);
//        next.setData(num);
//        head.setData(size);
//        //System.out.println(head);
//    }
//
//    @Override
//    public String toString() {
//        return "linkedList{" +
//                "head=" + head +
//                '}';
//    }
//    public void show() {
//        Node nx = head;
//        while (nx != null) {
//            System.out.print(nx.getData()+" ");
//            nx = nx.getNext();
//        }
//        System.out.println(" ");
//    }
//}
//
//class linkedmerge_prof{
//
//    static void splitNode(linkedList[] split,int n) {     //링크드 리스트를 n빵해서 n==1될때까지
//        int length = split[n].getHead().getData();
//        int div1 = length / 2;
//        int div2 = 0;
//        if (length % 2 != 0) div2 = (length / 2) + 1;
//        else div2 = length / 2;
//        //완전 이진트리 만들기
//        int left=2; //왼쪽 자식 길이
//        int right=1; //오른쪽 자식 길이
//        int sum = left +right;
//
//        while(length > left*2){
//            left*=2;
//            right*=2;
//            sum=left+right;
//        }
//
//        if(length>sum){
//            sum=length-sum;
//            right+=sum;
//        }
//        else{
//            sum=sum-length;
//            left-=sum;
//        }
//
//
//        Node temp = split[n].getHead().getNext();
//        split[n*2]=new linkedList();
//        for(int i=0; i<left;i++) {
//            split[n * 2].insertNode(temp.getData());
//            temp = temp.getNext();
//        }
//        split[n*2+1]=new linkedList();
//        for(int i=0; i<right;i++) {
//            split[n * 2+1].insertNode(temp.getData());
//            temp = temp.getNext();
//        }
//    }
//
//
//
//    static void mergeSort(linkedList[] arr) {
//        for(int i=arr[1].getHead().getData()-1;i>0;i--) {
//            arr[i]=new linkedList();
//            Node left = arr[i*2].getHead().getNext();
//            Node right = arr[i*2+1].getHead().getNext();
//
//            int legnth= arr[i*2+1].getHead().getData()+arr[i*2].getHead().getData();
//            for(int j=0;j< legnth;j++)
//            {
//                if (left==null) {
//                    arr[i].insertNode(right.getData());
//                    right=right.getNext();
//                    continue;
//                    //break;
//                }
//                if (right==null){
//                    arr[i].insertNode(left.getData());
//                    left=left.getNext();
//                    continue;
//                    //break;
//                };
//
//                if (left.getData() < right.getData()) {
//                    arr[i].insertNode(left.getData());
//                    left=left.getNext();
//                }
//                else {
//                    arr[i].insertNode(right.getData());
//                    right=right.getNext();
//                }
//
//            }
//
//        }
//        System.out.println("================================================================MERGE================================================================");
//
//    }
//    static void getData(linkedList[]l){
//        System.out.println("몇개의 노드를 삽입하시겠습니까?");
//        Scanner scanf = new Scanner(System.in);
//        Random rand = new Random();
//        int length = scanf.nextInt();
//        l[1]=new linkedList();
//        for (int i=0;i<length;i++) {
//            l[1].insertNode(rand.nextInt(50));
//        }
//    }
//    static void show(linkedList[]l){
//        for (int i = 1; i < l.length; i++) {
//            if(l[i]==null) continue;
//            System.out.print("l[" + i + "] = ");
//            l[i].show();
//        }
//    }
//    static void splitData(linkedList[] arr) {
//        int n=0;
//        for(int i=0;i<arr[1].getHead().getData()-1;i++) {
//            n += 1;
//            splitNode(arr, n);
//        }
//    }
//
//
//    public static void main(String[] args) {
//        linkedList arr[] = new linkedList[10000];
//        getData(arr);
//        show(arr);
//        splitData(arr);
//        show(arr);
//        mergeSort(arr);
//        show(arr);
//
//    }
//
//}