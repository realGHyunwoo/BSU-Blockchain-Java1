package polynomialLinked;
import java.util.Random;
import java.util.Scanner;

class Node {
    //지수:승수(exponent), 계수:문자 앞(coefficient)
    private int coefficient; //계수
    private int exponent; //지수
    public Node next;

    public Node(int coefficient, int exponent) {
        this.exponent=exponent;
        this.coefficient=coefficient;
        next = null;
    }
    public Node() {
        exponent=coefficient=0;
        next=null;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}

class polyLink {
    private Node head;
//    private Node head2 = new Node();

    public polyLink() {
        this.head = null;
    }

    public polyLink(Node nextNode) {
        head.setNext(nextNode);
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public
    void insertPoly() { //계수와 지수 입력받는 함수
        Scanner scanf = new Scanner(System.in);
        int data1;
        int data2;
        System.out.println("계수와 지수 입력 :: -200입력시 종료 ");
        while ((data1 = scanf.nextInt()) != -200 && (data2 = scanf.nextInt()) != -200) {
            insert(data1, data2);
        }

    }

    public void insert(int data1, int data2) { //외부에서 입력받은 지수와 계수를 링크드리스드 만드는 함수
        if (head == null) {
            head = new Node(data1, data2);
        } else {
            //지수:승수(exponent), 계수:문자 앞(coefficient)
            Node check = head;

            while (check != null) {
                if (check.getExponent() < data2) { //입력받은 승수가 가장 클때
                    int coef = check.getCoefficient();
                    int expo = check.getExponent();
                    //check.next=new Node(check.getCoefficient(),check.getExponent());
                    check.setCoefficient(data1);
                    check.setExponent(data2);
                    insert(coef, expo);
                    return;
                }
                if (check.getExponent() == data2) { //지수가 같을때
                    check.setCoefficient(data1 + check.getCoefficient());
                    return;
                }
                if (check.getNext() == null) {
                    check.next = new Node(data1, data2);
                    return;
                }
                check = check.getNext();
            }
            //check.setNext(new Node(data1,data2));

        }
    }

    public void addPoly(polyLink b) {
        Node tempA = this.head;
        Node tempB = b.getHead();
        polyLink tempC= new polyLink();

        if (tempA.getExponent()>tempB.getExponent()) {
            tempC.head = tempA;
            tempA = tempA.next;

        }
        else if (tempA.getExponent()< tempB.getExponent()) {
            tempC.head = tempB;
            tempB = tempB.next;

        }
        else {
            tempA.setCoefficient(tempA.getCoefficient()+tempB.getCoefficient());
            tempC.head = tempA;
            tempA = tempA.getNext();
            tempB = tempB.next;
        }
        Node tempD= tempC.head;

        while (tempA !=null && tempB!=null) { //지수:승수(exponent), 계수:문자 앞(coefficient)
            if (tempA.getExponent()>tempB.getExponent()) {
                tempD.next = tempA;
                tempA = tempA.next;
                tempD= tempD.next;
            }
            else if (tempA.getExponent()< tempB.getExponent()) {
                tempD.next = tempB;
                tempB = tempB.next;
                tempD= tempD.next;
            }
            else {
                tempA.setCoefficient(tempA.getCoefficient()+tempB.getCoefficient());
                tempD.next = tempA;
                tempA = tempA.getNext();
                tempB = tempB.next;
                tempD= tempD.next;
            }
        }

        if (tempA == null) {
            tempD.setNext(tempB);
        }
        else if (tempB ==null) {
            tempD.setNext(tempA);
        }
        System.out.println("다항식 1과 다항식 2의 합");
        tempC.show();
    }

    public void mulPoly(polyLink b) {
        Node tempA = this.head;
        Node tempB = b.getHead();
        polyLink tempC = new polyLink();
        while(tempA != null) {
            while (tempB != null) { //지수:승수(exponent), 계수:문자 앞(coefficient)
                int coef =tempA.getCoefficient() * tempB.getCoefficient();
                int expo = tempA.getExponent() + tempB.getExponent();
                tempC.insert(coef,expo);
                tempB=tempB.next;
            }
            tempB=b.getHead();
            tempA=tempA.getNext();
        }
        System.out.println("다항식 1과 다항식 2의 곱");
        tempC.show();
    }

    public void show() {
        Node total = head;
        while (total != null) {
            System.out.print(total.getCoefficient()+ "^"+ total.getExponent()+" ");
            total = total.getNext();
        }
        System.out.println("");
    }
}

public class Polynomial {
    public static void main(String[] args) {
        polyLink a = new polyLink();
        a.insertPoly();
        a.show();
        polyLink b = new polyLink();
        b.insertPoly();
        b.show();
        a.mulPoly(b);
        a.addPoly(b);

    }

}
