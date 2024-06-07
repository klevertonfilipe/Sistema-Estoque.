package com.example.inventory.entities;

import com.example.inventory.models.ProductModel;
import java.util.Iterator;

public class LinkedList implements Iterable<ProductModel> {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(ProductModel data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Método público para ordenar a lista
    public void sort() {
        head = mergeSort(head);
    }

    // Função recursiva que implementa o Merge Sort
    private Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    // Função para encontrar o ponto médio da lista
    private Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Função para mesclar duas listas ordenadas
    private Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node result;
        if (left.data.getName().compareTo(right.data.getName()) <= 0) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    @Override
    public Iterator<ProductModel> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<ProductModel> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public ProductModel next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            ProductModel data = current.data;
            current = current.next;
            return data;
        }
    }

    static class Node {
        ProductModel data;
        Node next;

        Node(ProductModel data) {
            this.data = data;
            this.next = null;
        }
    }
}
