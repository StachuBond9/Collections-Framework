package pl.stanislaw.myarraylist;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        MyArrayList<String> list = new MyArrayList<>();
        list.add("abc12");
        list.add("bjsj1");
        list.add("kskksks");
        list.add("kss");
        list.add("kskskks,w22");
        for(String item : list){
            System.out.println(item);
        }

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}