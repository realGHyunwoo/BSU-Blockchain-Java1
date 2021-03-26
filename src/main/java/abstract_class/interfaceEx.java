package abstract_class;
import java.util.*;

import static java.awt.SystemColor.info;



public class interfaceEx {
    public static void main(String[] args) {
        HashSet<Integer> A = new HashSet<>();
        A.add(1);
        A.add(2);
        A.add(3);

        HashSet<Integer> B = new HashSet<Integer>();
        B.add(4);
        B.add(5);
        B.add(6);

        HashSet<Integer> C = new HashSet<Integer>();
        C.add(3);

        HashMap<String,Integer> d = new HashMap<String, Integer>();
        d.put("one",1);
        d.put("two",2);
        d.put("three",3);

//        System.out.println(d.get("one"));
//        System.out.println(d.get("two"));
//        System.out.println(d.get("three"));
    // Hash Map을 iterator 돌리기
        //1. Hash map을 set으로 바꿔서 iterator와 호환되게한다
//        Set <Map.Entry<String,Integer>> entries = d.entrySet();
        //2. Set을 Iterator생성함
//        Iterator <Map.Entry<String,Integer>> i = entries.iterator();
//        while (i.hasNext()) {
//            Map.Entry<String,Integer> entry = i.next();
//            System.out.println(entry.getKey() + " : "+entry.getValue());
//        }

//        Iterator<String> iterator = d.keySet().iterator();
//        iterator.next();
//        d.get(iterator.next());
//        Iterator<Map.Entry<String,Integer>> iter = d.entrySet().iterator();
//        iter.next().getKey();
//        iter.next().getValue();

//        System.out.println(A.addAll(C)); //합집합
//        //A.retainAll(C); //교집합(interset)
//        A.removeAll(C);
//        Iterator hi = (Iterator) A.iterator();
//
//
//
//        while(hi.hasNext()) {
//            System.out.println(hi.next());
//        }
        Vector <Integer> vec = new Vector<Integer>();
        vec.add(Integer.valueOf(5));
        vec.add(Integer.valueOf(4));
        vec.add(Integer.valueOf(-1));
        vec.add(100);
        vec.add(0,200);
        System.out.println(vec);
        System.out.println("get 0:"+vec.get(0)); //get func
        System.out.println("size: "+vec.size()); //size func
        System.out.println("capacity: "+vec.capacity()); //size func
        System.out.println("remove 0::" + vec.remove(0));
        int sum=0;
        for(int i=0; i<vec.size();i++) {
            int n = vec.get(i);
            sum +=n;
        }
        System.out.println(sum);
        Vector v = new Vector();
        v.add("hi");
        v.add(2);
        System.out.println("vec"+v);
        ArrayList a = new ArrayList();
        a.add("hi");
        a.add(2);
        System.out.println(a);
    }


}