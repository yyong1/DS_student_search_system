package org.example.studentSearchV2;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public static int numSteps = 0;

    public Value get(Key key) {
        Node<Key, Value> x = root;
        numSteps = 0;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            numSteps++;
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }

    private Node<Key, Value> rotateLeft(Node<Key, Value> h) {
        if (h.right == null) {
            return h;
        }

        Node<Key, Value> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;

        return x;
    }
    private Node<Key, Value> rotateRight(Node<Key, Value> h) {
        if (h.left == null) {
            return h;
        }

        Node<Key, Value> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;

        return x;
    }

    private void flipColors(Node<Key, Value> h) {
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    private boolean isRed(Node<Key, Value> x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    public int countRedLinks() {
        return countRedLinks(root);
    }
    private int countRedLinks(Node<Key, Value> node){
        if (node == null) {
            return 0;
        }
        int count = (isRed(node)) ? 1 : 0;
        count += countRedLinks(node.left);
        count += countRedLinks(node.right);
        return count;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node<Key, Value> put(Node<Key, Value> h, Key key, Value value) {
        if (h == null) {
            return new Node<Key, Value>(key, value, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.right) && isRed(h.left)) {
            flipColors(h);
        }
//        h.size
        return h;
    }
}
