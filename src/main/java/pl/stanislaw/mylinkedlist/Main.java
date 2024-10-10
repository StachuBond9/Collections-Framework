package pl.stanislaw.mylinkedlist;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = linkedListWIthElements();;
        list.add(2, "Perez");
        for(String node : list){
            System.out.println(node);
        }
    }
    private static MyLinkedList<String> linkedListWIthElements() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("MAX");
        list.add("Norris");
        list.add("Leclerc");
        list.add("Piastrii");
        list.add("Lewis");
        return list;
    }
}
