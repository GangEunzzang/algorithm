import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Tree tree = new Tree('A');
    static StringBuilder tmpSb;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.insert(tree, root, left, right);
        }

        tmpSb = new StringBuilder();
        preOrder(tree);
        sb.append(tmpSb).append("\n");

        tmpSb = new StringBuilder();
        inOrder(tree);
        sb.append(tmpSb).append("\n");

        tmpSb = new StringBuilder();
        postOrder(tree);
        sb.append(tmpSb).append("\n");

        System.out.println(sb);
    }



    // 전위
    private static void preOrder(Tree tree) {
        tmpSb.append(tree.num);
        if (tree.left != null) preOrder(tree.left);
        if (tree.right != null) preOrder(tree.right);
    }

    // 중위
    private static void inOrder(Tree tree) {
        if (tree.left != null) inOrder(tree.left);
        tmpSb.append(tree.num);
        if (tree.right != null) inOrder(tree.right);
    }


    // 후위
    private static void postOrder(Tree tree) {
        if (tree.left != null) postOrder(tree.left);
        if (tree.right != null) postOrder(tree.right);
        tmpSb.append(tree.num);
    }


    private static class Tree {
        char num;
        Tree left;
        Tree right;

        Tree(char num) {
            this.num = num;
        }

        void insert(Tree tmp, char root, char left, char right) {
            if (tmp.num == root) {
                if (left != '.') tmp.left = new Tree(left);
                if (right != '.') tmp.right = new Tree(right);
            } else {
                if (tmp.left != null) insert(tmp.left, root, left, right);
                if (tmp.right != null) insert(tmp.right, root, left, right);
            }
        }
    }




}