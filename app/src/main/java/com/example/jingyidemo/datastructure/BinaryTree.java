package com.example.jingyidemo.datastructure;

public class BinaryTree {

    TreeNode root;

    public void setRoot(TreeNode node) {
        root = node;
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 前序遍历树
     */
    public void frontShow() {
        root.frontShow();
    }

    public void midShow() {
        root.midShow();
    }

    public void backShow() {
        root.backShow();
    }
}
