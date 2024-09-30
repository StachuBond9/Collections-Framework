package pl.stanislaw.mylinkedlist;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = linkedListWIthElements();;
        list.add(4, "Perez");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
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
