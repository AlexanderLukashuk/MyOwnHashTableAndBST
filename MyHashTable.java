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
        for (int i = 0; i < size; i++) {

            HashNode head = chainArray[i];

            while (head != null) {
                System.out.print(head);
                head = head.next;
            }
            System.out.println();
        }
    }
}
