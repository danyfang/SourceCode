package com.fishercoder;

import com.fishercoder.common.classes.TreeNode;
import com.fishercoder.common.utils.CommonUtils;
import com.fishercoder.common.utils.TreeUtils;
import com.fishercoder.solutions._94;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class _94Test {
    private static _94.Solution1 solution1;
    private static TreeNode root;
    private static List<Integer> inorder;

    @BeforeClass
    public static void setup() {
        solution1 = new _94.Solution1();
    }

    @Test
    public void test1() {
        root = TreeUtils.constructBinaryTree(Arrays.asList(3, 1, null, null, 5, 2, null, null, 4));
        inorder = solution1.inorderTraversal(root);
        CommonUtils.printList(inorder);
    }

}
