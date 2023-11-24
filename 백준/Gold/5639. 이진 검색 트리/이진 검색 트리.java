import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Tree tree;

    public static void main(String[] args) throws IOException {
        tree = new Tree(Integer.parseInt(br.readLine()));

        while (true) {
            String s = br.readLine();
            if(s == null || s.equals("")) break;
            tree.insert(Integer.parseInt(s));
        }
        postOrder(tree);

        System.out.println(sb);
    }

    private static void postOrder(Tree tree) {
        if (tree.left != null) {
            postOrder(tree.left);
        }

        if (tree.right != null) {
            postOrder(tree.right);
        }
        sb.append(tree.num).append("\n");
    }
    private static class Tree {
        int num;
        Tree left;
        Tree right;

        Tree(int num) {
            this.num = num;
        }

        void insert(int num) {
            if (num < this.num) {
                if (left == null) {
                    left = new Tree(num);
                } else {
                    this.left.insert(num);
                }
            }

            if (num > this.num) {
                if (right == null) {
                    right = new Tree(num);
                } else {
                    this.right.insert(num);
                }
            }
        }
    }



}