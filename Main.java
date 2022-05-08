package com.company;

public class Main {

    public static void main(String[] args) {
//        MyHashTable<Integer, Integer> hashTable = new MyHashTable<>(15);
//        hashTable.put(1, 7);
//        hashTable.put(2, 67);
//        hashTable.put(1, 93);
//        hashTable.put(2, 44);
//        hashTable.put(3, 28);
//        hashTable.put(1, 39);
//        hashTable.put(5, 48);
//        hashTable.put(9, 10);
//        hashTable.put(9, 102);
//        hashTable.put(5, 17);
//        hashTable.put(9, 21);
//        hashTable.put(15, 21);
//        hashTable.put(15, 22);
//        hashTable.put(99, 22);
//        hashTable.put(3, 91);
//        hashTable.put(3, 92);
//        hashTable.put(3, 93);
//
//        hashTable.printHashTable();
//
//        System.out.println("Getting element: " + hashTable.get(2));
//
//        System.out.println(hashTable.contains(28));
//        System.out.println(hashTable.getKey(91));
//
//        hashTable.remove(1);
//
//        hashTable.printHashTable();

        BST<Integer, Integer> tree = new BST<>();
        tree.put(1, 23);
        tree.put(2, 68);
        tree.put(2, 72);
        tree.put(3, 43);
        tree.put(1, 30);
        tree.put(2, 15);

        tree.print();

        System.out.println(tree.get(2));
    }
}
