package com.mprodev.algodsready;

class Trie {
    private final Node root;

    public Trie() {
        root = new Node('\0');
    }

    public void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.notExist(ch))
                curr.put(ch, new Node(ch));
            curr = curr.get(ch);
        }
        curr.setWord();
        ;
    }

    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord();
    }

    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private Node getNode(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.notExist(ch)) return null;
            curr = curr.get(ch);
        }
        return curr;
    }
}

class Node {
    private char c;
    private boolean isWord;
    private final Node[] children;

    public Node(char c) {
        this.c = c;
        isWord = false;
        children = new Node[26];
    }

    public boolean notExist(char ch) {
        return children[ch - 'a'] == null;
    }

    public void put(char ch, Node node) {
        children[ch - 'a'] = node;
    }

    public Node get(char ch) {
        return children[ch - 'a'];
    }

    public void setWord() {
        isWord = true;
    }

    public boolean isWord() {
        return isWord;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }
}
