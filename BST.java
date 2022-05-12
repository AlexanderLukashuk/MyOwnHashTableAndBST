package com.company;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
            return;
        }

        Node prevElem = null;
        Node temp = root;
        while (temp != null) {
            if (((Comparable<V>)temp.value).compareTo(value) < 0) {
                prevElem = temp;
                temp = temp.left;
            } else if (((Comparable<V>)temp.value).compareTo(value) > 0) {
                prevElem = temp;
                temp = temp.right;
            }
        }

        if (((Comparable<V>)prevElem.value).compareTo(value) < 0) {
            prevElem.left = newNode;
        } else {
            prevElem.right = newNode;
        }
    }

    public V get(K key) {
        Node temp = root;

        if (temp.key == key) {
            return temp.value;
        }

        V gettingValue = null;
        Node prevElem = null;
        while (temp != null) {
            if (((Comparable<K>)temp.key).compareTo(key) < 0) {
                prevElem = temp;
                temp = temp.left;
            } else if (((Comparable<K>)temp.key).compareTo(key) > 0) {
                prevElem = temp;
                temp = temp.right;
            }

            if (((Comparable<K>)temp.key).compareTo(key) == 0) {
                gettingValue = temp.value;
                break;
            }
        }

        return gettingValue;
    }

    public void delete(K key) {
        Node temp = root;
        Node prevElem = null;

        while (temp != null) {
            if (((Comparable<K>)temp.key).compareTo(key) > 0) {
                prevElem = temp;
                temp = temp.left;
            } else if (((Comparable<K>)temp.key).compareTo(key) < 0) {
                prevElem = temp;
                temp = temp.right;
            }

            if (((Comparable<K>)temp.key).compareTo(key) == 0) {
                if (temp.right != null) {

                }
            }
        }
    }

    private void printTree(Node node) {
        if (node != null) {
            printTree(node.right);
            System.out.print(node.value + " ");
            printTree(node.left);
        }
    }

    public void print() {
        printTree(root);
        System.out.println();
    }
}
