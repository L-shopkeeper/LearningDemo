package com.example.jingyidemo.datastructure;

import android.util.Log;

public class TreeNode {

    int data;

    TreeNode leftNode;

    TreeNode rightNode;

    public TreeNode(int data) {
        this.data = data;
    }

    public void setLeftNode(TreeNode node) {
        leftNode = node;
    }

    public void setRightNode(TreeNode node) {
        rightNode = node;
    }

    public void frontShow() {
        System.out.println(data);
        if (leftNode != null) {
            leftNode.frontShow();
        }
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    public void midShow() {
        if (leftNode != null) {
            leftNode.midShow();
        }
        System.out.println(data);
        if (rightNode != null) {
            rightNode.midShow();
        }
    }

    public void backShow() {
        if (leftNode != null) {
            leftNode.backShow();
        }
        if (rightNode != null) {
            rightNode.backShow();
        }
        System.out.println(data);
    }
}
