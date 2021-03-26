package binary_tree_search;
import java.util.Scanner;

class Node {
    public Node left;
    public Node right;
    private int data;

    public Node(int data) {
        this.left=null;
        this.right=null;
        this.data =data;
    }
    public Node() {
        this.left=null;
        this.right=null;
        this.data =0;
    }

    public Node getLeft() {
        return left;
    }

    public void show() {
        System.out.print(this.data + " ");
    }
    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

class binary_tree {
    private Node root;

    public binary_tree() {
        this.root = null;
    }


    public void insert() {
        Scanner scanf = new Scanner(System.in);
        int data;
        System.out.println("노드의 data입력 :: -200입력시 종료");
        while ((data=(scanf.nextInt())) != -200) {
            insertNode(data);
        }

    }

    public void insertNode(int data) {
        if (root==null) root=new Node(data);
        else {
            System.out.println("***data = " + data);
            Node check = root;
            boolean condition=true;
                while (condition) {
                    if (data > check.getData()) {
                        if (check.right ==null) {
                            check.setRight(new Node(data));
                            condition=false;
                        }
                        check = check.right;

                    }
                    else if (data < check.getData()) {
                        if (check.left ==null) {
                            check.setLeft(new Node(data));
                            condition=false;
                        }
                        check = check.left;
                    }
                    else {
                        break;
                    }

                } //while_End
            }

        }
    public void inorderShow(Node temp) {
        if (temp==null) return; //재귀 함수종료를 위한 조건
        inorderShow(temp.left);
        temp.show();
        inorderShow(temp.right);
    }

    //        while (p != null) {
//            if (p.getData() == data) {
//                temp = p;
//                break;
//            } else {
//                if (p.getData() > data)
//                    p = p.getLeft();
//                else p = p.getRight();
//            }
//        }
//        if (p == null) {
//            System.out.println("p = " + p);
//            return;
//        }
//
//
//
//            }))
//        }
    public void deleteNode(int data) {
        Node temp=root;
        Node trace = root;

        while (!(temp == null)) { //delete할 data만 찾기
            if (temp.getData()==data) break;
            if (data > temp.getData()) { //오른쪽 이동계속 이동
                trace = temp; //temp 이전값을 담는중
                temp= temp.getRight();
            }
            else {
                trace = temp;
                temp = temp.getLeft();
            }
        } //end while

        //1. 자식노드가 없을 경우
        if (temp.getLeft() == null && temp.getRight() == null) {
            if (trace.right == temp) trace.setRight(null); //
            else trace.setLeft(null);

            if(this.getRoot().getData()==temp.getData()) root=null;
        }

        //2.자식이 1개일때 or 2개일경우
        if (temp.getRight()!=null ) {
            inOrder(temp);
        }
        else {
            //preOrder(temp);
        }

}

    public void inOrder(Node temp) {
        Node temp2= temp; //삭제할숫자
        Node trace=temp;
        temp=temp.getRight();
        while(!(temp.getLeft()==null)) {
            trace=temp;
            temp= temp.getLeft();
        }

        temp2.setData(temp.getData());
        if(temp.getRight()==null ){
            if (trace.getRight()==temp) trace.setRight(null);
            else trace.setLeft(null);
        }

        //if (temp.getRight()!=null) {
        else {
            inOrder(temp);
            return;
        }
    }

     public int depth(Node t) {
     if (t == null)
         return 0;

         return 1 + Math.max(depth(t.getLeft()), depth(t.getRight()));
     }

     public int calDepth(Node p) {
         int left_d, right_d = 0;
         left_d = depth(p.getLeft());
         right_d = depth(p.getRight());

         //diff>0 : 왼쪽이 긴 형태 | diff<0 : 오른쪽이 긴 형태
         int diff = left_d - right_d;
         return diff;
     }

     public Node split(int diff, binary_tree t) {

         Node temp = getRoot();
         Node f = null;
         Node ret = null;

         double cnt = Math.ceil(Math.abs(diff) / 2);

         if (diff < 0) {
             for (int i = 0; i < cnt; i++) {
                 f = temp;
                 temp = temp.getRight();
             }
             t.setRoot(temp.getRight());
             ret = temp;

             f.setRight(null);
             ret.setRight(null);
         } else {
             for (int i = 0; i < cnt; i++) {
                 f = temp;
                 temp = temp.getLeft();
             }
             t.setRoot(temp.getLeft());
             ret = temp;

             f.setLeft(null);
             ret.setLeft(null);
         }
         return ret;
     }

     public binary_tree join(Node x, binary_tree t) {
         binary_tree ret = new binary_tree();
         ret.setRoot(x);

         if (getRoot().getData() < t.getRoot().getData()) {
             ret.getRoot().setLeft(getRoot());
             ret.getRoot().setRight(t.getRoot());
         } else {
             ret.getRoot().setLeft(t.getRoot());
             ret.getRoot().setRight(getRoot());
         }
         return ret;
     }


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}

public class binary_tree_search_1 {
    public static void main(String[] args) {
        binary_tree a = new binary_tree();
        a.insert();
        a.inorderShow(a.getRoot());
        System.out.println(" ");
        a.deleteNode(2);
        a.inorderShow(a.getRoot());
        System.out.println(" ");
//        a.deleteNode(3);
//        a.inorderShow(a.getRoot());
//        System.out.println(" ");
        binary_tree s = new binary_tree();
        Node r;
        r = a.split(a.calDepth(a.getRoot()), s);
        a.inorderShow(a.getRoot());
        System.out.println();
        System.out.println(r.getData());
        s.inorderShow(s.getRoot());
        System.out.println();

        binary_tree ret;
        ret=a.join(r,s);
        ret.inorderShow(ret.getRoot());
        System.out.println();




        //a.deleteNode(9);


    }
}
