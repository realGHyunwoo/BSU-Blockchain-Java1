package lotto;

import java.util.*;
//hashset = 복권번호 1줄, arraylist = 복권발행저장
class lottoImplement {
    public int quantity; //복권 발행 수량 (issue)

    public lottoImplement(int quantityInput) { //생성자
        this.quantity = quantityInput;
    }

    //Lotto 1000개(quantity) 발행
    public ArrayList<HashSet<Integer>> issueLotto() {
        //HashSet <Integer> hashSet = new HashSet<Integer>();
        Random random = new Random();
        ArrayList<HashSet<Integer>> arrayList = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < quantity; i++) {
            HashSet<Integer> hashSet = new HashSet<Integer>();
            while (hashSet.size() != 6) {
                hashSet.add(random.nextInt(45) + 1);
            }
            hashSet.add(-random.nextInt(10));
            arrayList.add(hashSet);
        } //end for
//        System.out.println("=====================복권발행=====================");
//        Iterator<HashSet<Integer>> i = arrayList.iterator();
//        while (i.hasNext()) {
//            System.out.println(i.next());
//        }
        return arrayList;
    } //end function

    public HashMap<StringBuilder, HashSet<Integer>> purchaseLotto(ArrayList<HashSet<Integer>> arrayList) {
        Random random = new Random(); //휴대폰 번호 랜덤생성
        HashMap<StringBuilder, HashSet<Integer>> hashMap = new HashMap<StringBuilder, HashSet<Integer>>();
        HashSet<StringBuilder> hashSet = new HashSet<StringBuilder>();
        int cntPhone = 0; //4번 반복 시킴 번호 생성위해
        int cntPhone2 = 0; //4번씩 2번 생성하면 while 종료
        int cntArrayList = 0; // arraylist의 밸류 0번쨰부터 hashmap에 넣기위함
        int cntSet = 0;

        while (hashSet.size() != quantity) { //HashMap 생성 휴대폰 번호 + Hashset의 중 하나
            StringBuilder stringBuilder1 = new StringBuilder(); //휴대폰 번호 저장하기 위함 010- 고정
            stringBuilder1.append("010-");
            while (cntPhone2 != 2) { //번호 랜덤 생성 while
                cntPhone++;
                if (cntPhone <= 8) stringBuilder1.append(random.nextInt(10)); //번호생성
                if (cntPhone == 4) { //4번쨰 번호뒤에 "-"
                    cntPhone2++;
                    stringBuilder1.append("-");
                }
                if (cntPhone == 8) { //하나의 번호 생성시
                    cntPhone2++;
                    cntPhone = 0;
                }

            } //end while 2
            cntPhone2 = 0;

            if (cntSet == hashSet.size()) {
                if ((hashSet.add(stringBuilder1) == true)) {
                    cntSet++;
                    hashMap.put(stringBuilder1, arrayList.get(cntArrayList));
                    cntArrayList++;
                } else continue;
            }
        }//end while 1
        System.out.println("");
        System.out.println("=====================복권구매=====================");

        // Hash Map을 iterator 돌리기
        //1. Hash map을 set으로 바꿔서 iterator와 호환되게한다
        Set<Map.Entry<StringBuilder, HashSet<Integer>>> entries = hashMap.entrySet();
        //2. Set을 Iterator생성함
//        Iterator<Map.Entry<StringBuilder, HashSet<Integer>>> i = entries.iterator();
//        while (i.hasNext()) {
//            Map.Entry<StringBuilder, HashSet<Integer>> entry = i.next();
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        return hashMap;
    }//end function

    public int[] drawLotto(ArrayList<HashSet<Integer>> rand) {
        Random random = new Random();
        int first = random.nextInt(quantity); //복권 개수중 무작위 추첨
        HashSet<Integer> a = new HashSet<Integer>();
        int[] ret = new int[2];
        ret[0] = first;
        ret[1] = random.nextInt(10);
        a = rand.get(first);
        HashSet<Integer> cc = new HashSet<Integer>(); //1등 번호

        Iterator<Integer> aa = a.iterator();
        Integer bb = 0;
        while (aa.hasNext()) {
            bb = aa.next();
            if (bb <= 0) {
                continue;
            }
            cc.add(bb);
        }
        System.out.println("");
        System.out.println("=====================1등 추첨=====================");
        System.out.println("1등 번호: " + cc + " 보너스 볼: " + ret[1]);
        return ret; //추첨된 번호와 보너스볼 리턴
    } //end function

    public void rankLotto(int[] lottoNum, ArrayList<HashSet<Integer>> list, HashMap<StringBuilder, HashSet<Integer>> draw) {
        //==============================================================================================================
        // 배열 0은 배열리스트 번호
        // 배열 1은 보너스볼
        //(int[] lottoNum,ArrayList<HashSet<Integer>> list,HashMap <StringBuilder, HashSet<Integer>> draw)

        //1. Hash map을 set으로 바꿔서 iterator와 호환되게한다
        Set<Map.Entry<StringBuilder, HashSet<Integer>>> hashmap = draw.entrySet();
        //2. Set을 Iterator생성함
        Iterator<Map.Entry<StringBuilder, HashSet<Integer>>> i = hashmap.iterator(); //hashmap중 하나의 hashmap
        HashSet<Integer> hashSet = list.get(lottoNum[0]); //당첨번호
        Iterator <Integer> hh= hashSet.iterator();
        HashSet<Integer> hashSet2= new HashSet<Integer>(); //당첨번호
        Integer bonus=0;

        while(hh.hasNext()) {
            Integer tempHh =hh.next();
            if(tempHh>0) hashSet2.add(tempHh);
        }

        int cntBonus=0;
        int cntLotto=0;

        System.out.println("");
        System.out.println("=====================당첨=====================");
        while (i.hasNext()) {
            Map.Entry<StringBuilder, HashSet<Integer>> entry = i.next();
            Iterator<Integer> entryHashset = entry.getValue().iterator();
            Iterator<Integer> num = hashSet2.iterator(); //당첨번호중 하나의 num
            for(int ia=0; ia<7;ia++) {
                Integer tempEntryHashset=entryHashset.next();
                if(tempEntryHashset<=0) {
                    if(-tempEntryHashset==lottoNum[1]) {
                        cntBonus++;
                        bonus = tempEntryHashset;
                    }
                }
            }
            while (num.hasNext()) {
                Integer tempNum = num.next();

                if (entry.getValue().contains(tempNum)) {
                    cntLotto++;
                }

            } //end loop2 while
//            System.out.println(cntLotto);
            if(cntLotto>=6) { //1등
            System.out.println("1등에 당첨되었습니다. 휴대폰 번호는: "+ entry.getKey() + "당첨 번호는: "+entry.getValue()+" 입니다.");
            }
            else if(cntLotto==5 && cntBonus==1 ) { //2등
                System.out.println("2등에 당첨되었습니다. 휴대폰 번호는: "+ entry.getKey() + "당첨 번호는: "+entry.getValue()+"입니다.");
            }
            else if (cntLotto==5) { //3등
                System.out.println("3등에 당첨되었습니다. 휴대폰 번호는: "+ entry.getKey() + "당첨 번호는: "+entry.getValue()+"입니다.");
            }
//            else { //
//                continue;
//            }

            cntBonus=0;
            cntLotto=0;
            }//end loop1 while


        }//end function

    } //end class


    public class lotto {
        public static void main(String[] args) {
            lottoImplement a = new lottoImplement(1000000);
            ArrayList<HashSet<Integer>> rand = a.issueLotto();
            HashMap<StringBuilder, HashSet<Integer>> draw = a.purchaseLotto(rand);
            int[] lottoNum = new int[2];
            lottoNum = a.drawLotto(rand);
            a.rankLotto(lottoNum, rand, draw);


        }


    }

