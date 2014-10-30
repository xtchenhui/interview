package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.collection.list.Node;

/**
 * Created_By: stefanie
 * Date: 14-7-10
 * Time: 下午9:30
 */
public class C3_10_ListPartition {

    public static void partition(LinkedList<Integer> list, int K){
        if(list == null || list.getHead() == null) return;
        Node<Integer> smaller = list.getHead();
        Node<Integer> larger = smaller.next;
        while(larger != null){
            if(larger.item < K){
                smaller = smaller.next;
                if(smaller != larger) swap(smaller, larger);
            }
            larger = larger.next;
        }
        Node<Integer> head = list.getHead();
        if(head.item > K){
            smaller = smaller.next;
            swap(smaller, head);
        }
    }

    private static void swap(Node<Integer> n1, Node<Integer> n2){
        int temp = n1.item;
        n1.item = n2.item;
        n2.item = temp;
    }

    public static void partitionTwoLink(LinkedList<Integer> list, int key){
        Node<Integer> p = list.getHead();
        Node<Integer> small = null;
        Node<Integer> large = null;
        Node<Integer> largeHead = null;
        while(p != null){
            if(p.item < key) {
                if(small == null) small = p;
                else {
                    small.next = p;
                    small = p;
                }
            } else {
                if(large == null) largeHead = large = p;
                else {
                    large.next = p;
                    large = p;
                }
            }
            p = p.next;
        }
        small.next = largeHead;
    }

    public static void partitionRecursive(LinkedList<Integer> list, int key){
        Node<Integer> node = list.getHead();
        Node<Integer> small = null;
        Node<Integer> large = null;

        while(node != null){
            Node<Integer> next = node.next;
            if(node.item < key){
                node.next = small;
                small = node;
            } else {
                node.next = large;
                large = node;
            }
            node = next;
        }
        if(small == null) {
            list.setHead(large);
            return;
        } else {
            list.setHead(small);
            while(small.next != null)   small = small.next;
            small.next = large;
        }

    }

}
