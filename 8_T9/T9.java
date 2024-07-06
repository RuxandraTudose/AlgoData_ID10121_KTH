import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class T9 {
    private class Node {
        public Node[] next;
        public boolean valid;

        public Node() {
            this.valid = false;
            this.next = new Node[27];
        }
    }

    private Node root;

    public T9(String file) {
        root = new Node();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null)
                addWords(line);
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public void addWords(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid word!");
        }

        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = getCharCode(c);

            if (index == -1) {
                throw new IllegalArgumentException("Invalid char: " + c);
            }

            if (current.next[index] == null) {
                Node node = new Node();
                current.next[index] = node;
            }
            current = current.next[index];
        }
        current.valid = true;
    }

    public int getCharCode(char c) {
        if (c == 'å')
            return 24;
        else if (c == 'ä')
            return 25;
        else if (c == 'ö')
            return 26;
        else if (c >= 97 && c <= 122)
            return c - 'a';
        else
            return -1;
    }

    public char getChar(int c) {
        if (c == 24)
            return 'å';
        else if (c == 25)
            return 'ä';
        else if (c == 26)
            return 'ö';
        else if (c >= 0 && c <= 24)
            return (char) (c + 'a');
        else
            return ' ';
    }

    public boolean lookup(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid word!");
        }

        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = getCharCode(c);
            if (current.next[index] == null) {
                return false;
            }
            current = current.next[index];
        }
        return current.valid;
    }

    public int getKey(char c) {
        return (c - '0') - 1;
    }

    public ArrayList<String> decode(String key) {
        ArrayList<String> words = new ArrayList<String>();

        if (key == null || key.isEmpty())
            throw new IllegalArgumentException("Invalid key!");

        int[] code = new int[key.length()];

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            code[i] = getKey(c);
        }

        collect(root, code, 0, "", words);

        return words;
    }
    public void collect(Node node, int[] code, int index, String s, ArrayList<String> words) {
        if (index == code.length) {
            if (node.valid)
                words.add(s);
            return;
        }
    
        int res1 = code[index] * 3 + 0;
        int res2 = code[index] * 3 + 1;
        int res3 = code[index] * 3 + 2;
    
        if (node.next[res1] != null)
            collect(node.next[res1], code, index + 1, s + getChar(res1), words);
            
        if (node.next[res2] != null)
            collect(node.next[res2], code, index + 1, s + getChar(res2), words);
    
        if (node.next[res3] != null)
            collect(node.next[res3], code, index + 1, s + getChar(res3), words);
    }

    public static void main(String[] args) {
        T9 t9 = new T9("kelly.txt");
        System.out.println("Added words!");
        
        String word = "ruin", key = "47141";

        if (t9.lookup(word))
            System.out.println("\n" + word);
        else
            System.out.println("\n" + word + " doesn't exist!");

        List<String> words = t9.decode(key);
        System.out.print("\n");
        if (!words.isEmpty()) {
            for (String str : words)
                System.out.println(str);
        }
        else
            System.out.println("\n" + key + " doesn't exist!");
    }
}