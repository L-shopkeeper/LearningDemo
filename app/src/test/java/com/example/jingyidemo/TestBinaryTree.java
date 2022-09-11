package com.example.jingyidemo;

import android.util.Log;

import com.example.jingyidemo.datastructure.BinaryTree;
import com.example.jingyidemo.datastructure.TreeNode;

import org.junit.Test;

public class TestBinaryTree {

    @Test
    public void main() {
        //创建一棵树
        BinaryTree tree = new BinaryTree();
        //创建根节点
        TreeNode root = new TreeNode(1);
        //把根节点赋给树
        tree.setRoot(root);
        //创建两个节点，作为根节点的左右子节点
        TreeNode rootLeftNode = new TreeNode(2);
        TreeNode rootRightNode = new TreeNode(3);
        //把新创建的节点设置为根节点的左右节点
        root.setLeftNode(rootLeftNode);
        root.setRightNode(rootRightNode);
        //2号节点，再创建子节点
        rootLeftNode.setLeftNode(new TreeNode(4));
        rootLeftNode.setRightNode(new TreeNode(5));
        //3号节点，再创建子节点
        rootRightNode.setLeftNode(new TreeNode(6));
        rootRightNode.setRightNode(new TreeNode(7));
        //前序遍历
        System.out.println("前序遍历=======");
        tree.frontShow();
        System.out.println("中序遍历=======");
        tree.midShow();
        System.out.println("后序遍历=======");
        tree.backShow();

    }
}
