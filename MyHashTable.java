package com.company;

import java.util.Objects;

public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V get(int index) {
            int count = 0;
            for (HashNode i = next; i != null; i = i.next) {
                if (count == index) {
                    return (V) i.value;
                }
                count++;
            }

            return null;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public  MyHashTable() {
        size = 0;
        chainArray = new HashNode[M];

//        for (int i = 0; i < M; i++) {
//            chainArray[i] = null;
//        }
    }

    public  MyHashTable(int M) {
        this.M = M;

        size = 0;
        chainArray = new HashNode[M];

        for (int i = 0; i < M; i++) {
            chainArray[i] = null;
        }
    }

    private int hash(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % M;

        if (index < 0) {
            index *= -1;
        }

        return index;
    }

    private final int hashCode(K key) {
        return Objects.hashCode(key);
    }

    public void put(K key, V value) {
//        int bucket = hash(key);
//        int hashCode = hashCode(key);
////        HashNode<K, V> head = chainArray.;
////        HashNode<K, V> head = null;
////        for (int i = 0; i < size; i++) {
////            if (i == bucket) {
////                head = chainArray[i];
////            }
////        }
////        head = chainArray[bucket];
//        HashNode<K, V> head = chainArray[bucket];
//
//        while (head != null) {
//            if (head.key.equals(key)) {
//                head.value = value;
//                return;
//            }
//            head = head.next;
//        }
//
//        size++;
////        for (int i = 0; i < size; i++) {
////            if (i == bucket) {
////                head = chainArray[i];
////            }
////        }
//        head = chainArray[bucket];
//        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
//        newNode.next = head;
//        for (int i = 0; i < size; i++) {
//            if (i == bucket) {
//                chainArray[i] = newNode;
//            }
//        }
//
//        if ((1.0 * size) / M >= 0.7) {
////            HashNode<K, V>[] temp = chainArray;
//            HashNode<K, V>[] temp = new HashNode[M];
//            for (int i = 0; i < M; i++) {
//                temp[i] = chainArray[i];
//            }
//            M = M * 2;
//            chainArray = new HashNode[M];
//            size = 0;
//            for (int i = 0; i < M; i++) {
//                chainArray[i] = null;
//            }
//
//            for (HashNode<K, V> node : temp) {
//                while (node != null) {
//                    put(node.key, node.value);
//                    node = node.next;
//                }
//            }
//        }

        if (size == M) {
            return;
        } else {
            int hash = hash(key);
            HashNode hashEntry = new HashNode(key, value);
            if (chainArray[hash] == null) {
                chainArray[hash] = hashEntry;
            } else {
                HashNode temp = chainArray[hash];
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = hashEntry;
            }
            size++;
        }
    }

    public V get(K key) {
        int hasCode = hashCode(key);
        if(chainArray[hasCode] == null){
            return null;
        }
        if(chainArray[hasCode].next != null)
            return (V) chainArray[hasCode].value;

        HashNode<K, V> temp  = chainArray[hasCode];
        while(temp != null){
            if(temp.key.equals(key))
                return temp.value;
            temp = temp.next;
        }
        return null;
    }

    public V remove(K key) {
//        int bucketIndex = hash(key);
//        // Get head of chain
//        HashNode<K, V> head = chainArray[bucketIndex];
//
//        // Search for key in its chain
//        HashNode<K, V> prev = null;
//        while (head != null) {
//            // If Key found
//            if (head.key.equals(key))
//                break;
//
//            // Else keep moving in chain
//            prev = head;
//            head = head.next;
//        }
//
//        // If key was not there
//        if (head == null)
//            return null;
//
//        // Reduce size
//        size--;
//
//        // Remove key
//        if (prev != null)
//            prev.next = head.next;
//        else
//            chainArray[bucketIndex] = head.next;
//
//        return head.value;

//        int hash = hash(key);
//        HashNode temp = chainArray[hash];
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        V removedValue = (V) temp.value;
//        temp = null;
//        size--;
//
//        return removedValue;

        int hasCode = hashCode(key);
        V removedValue = null;
        if(chainArray[hasCode] == null){
            return null;
        }
        if(chainArray[hasCode] != null) {
            removedValue = (V) chainArray[hasCode];
            chainArray[hasCode] = chainArray[hasCode].next;
            size--;
            return removedValue;
        }

        HashNode<K, V> temp  = chainArray[hasCode];
        HashNode<K, V> prevTemp  = chainArray[hasCode];
        while(temp != null){
            if(temp.key.equals(key)) {
                removedValue = prevTemp.value;
                prevTemp.next = temp.next;
                size--;
                return removedValue;
            }
            prevTemp = temp;
            temp = temp.next;
        }
        size--;
        return removedValue;

    }

    public boolean contains(V value) {
        if (chainArray[0] == null) {
            return false;
        }

        HashNode<K, V> temp;
        for (int i = 0; i < size; i++) {
            temp = chainArray[i];

            while (temp != null) {
                if (temp.value == value) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        if (chainArray[0] == null) {
            return null;
        }

        HashNode<K, V> temp;
        for (int i = 0; i < size; i++) {
            temp = chainArray[i];

            while (temp != null) {
                if (temp.value == value) {
                    return temp.key;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public void printHashTable() {
        // цикл хуйня, выводит не все элементы
        for (int i = 0; i < size; i++) {
//            System.out.println(chainArray[i]);

            HashNode head = chainArray[i];

            while (head != null) {
                System.out.print(head);
                head = head.next;
            }
            System.out.println();
        }
    }
}
