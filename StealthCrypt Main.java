import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // Morse code translation dictionary
    private static final Map<Character, String> morseDictionary = new HashMap<>();
    static {
        morseDictionary.put('A', ".-");
        morseDictionary.put('B', "-...");
        morseDictionary.put('C', "-.-.");
        morseDictionary.put('D', "-..");
        morseDictionary.put('E', ".");
        morseDictionary.put('F', "..-.");
        morseDictionary.put('G', "--.");
        morseDictionary.put('H', "....");
        morseDictionary.put('I', "..");
        morseDictionary.put('J', ".---");
        morseDictionary.put('K', "-.-");
        morseDictionary.put('L', ".-..");
        morseDictionary.put('M', "--");
        morseDictionary.put('N', "-.");
        morseDictionary.put('O', "---");
        morseDictionary.put('P', ".--.");
        morseDictionary.put('Q', "--.-");
        morseDictionary.put('R', ".-.");
        morseDictionary.put('S', "...");
        morseDictionary.put('T', "-");
        morseDictionary.put('U', "..-");
        morseDictionary.put('V', "...-");
        morseDictionary.put('W', ".--");
        morseDictionary.put('X', "-..-");
        morseDictionary.put('Y', "-.--");
        morseDictionary.put('Z', "--..");
        morseDictionary.put('0', "-----");
        morseDictionary.put('1', ".----");
        morseDictionary.put('2', "..---");
        morseDictionary.put('3', "...--");
        morseDictionary.put('4', "....-");
        morseDictionary.put('5', ".....");
        morseDictionary.put('6', "-....");
        morseDictionary.put('7', "--...");
        morseDictionary.put('8', "---..");
        morseDictionary.put('9', "----.");
        morseDictionary.put(' ', "/");
        morseDictionary.put('.', ".-.-.-");
        morseDictionary.put(',', "--..--");
        morseDictionary.put('?', "..--..");
        morseDictionary.put('\'', ".----.");
        morseDictionary.put('!', "-.-.--");
        morseDictionary.put('/', "-..-.");
        morseDictionary.put('(', "-.--.");
        morseDictionary.put(')', "-.--.-");
        morseDictionary.put(':', "---...");
        morseDictionary.put(';', "-.-.-.");
        morseDictionary.put('=', "-...-");
        morseDictionary.put('+', ".-.-.");
        morseDictionary.put('-', "-....-");
        morseDictionary.put('_', "..--.-");
        morseDictionary.put('$', "...-..-");
        morseDictionary.put('@', ".--.-.");
    }

    // Chappe code translation dictionary
    private static final Map<Character, String> chappeDictionary = new HashMap<>();
    static {
        chappeDictionary.put('A', "1-");
        chappeDictionary.put('B', "-111");
        chappeDictionary.put('C', "-1-1");
        chappeDictionary.put('D', "-11");
        chappeDictionary.put('E', "1");
        chappeDictionary.put('F', "11-1");
        chappeDictionary.put('G', "--1");
        chappeDictionary.put('H', "1111");
        chappeDictionary.put('I', "11");
        chappeDictionary.put('J', "1---");
        chappeDictionary.put('K', "-1-");
        chappeDictionary.put('L', "1-11");
        chappeDictionary.put('M', "--");
        chappeDictionary.put('N', "-1");
        chappeDictionary.put('O', "---");
        chappeDictionary.put('P', "1--1");
        chappeDictionary.put('Q', "--1-");
        chappeDictionary.put('R', "1-1");
        chappeDictionary.put('S', "111");
        chappeDictionary.put('T', "-");
        chappeDictionary.put('U', "11-");
        chappeDictionary.put('V', "111-");
        chappeDictionary.put('W', "1--");
        chappeDictionary.put('X', "-11-");
        chappeDictionary.put('Y', "-1--");
        chappeDictionary.put('Z', "--11");
        chappeDictionary.put('0', "-----");
        chappeDictionary.put('1', "1----");
        chappeDictionary.put('2', "11---");
        chappeDictionary.put('3', "111--");
        chappeDictionary.put('4', "1111-");
        chappeDictionary.put('5', "11111");
        chappeDictionary.put('6', "-1111");
        chappeDictionary.put('7', "--111");
        chappeDictionary.put('8', "---11");
        chappeDictionary.put('9', "----1");
    }

    // Caesar Cipher
    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) (((ch - base + shift) % 26) + base);
            }
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Morse Code");
        System.out.println("2. Chappe Code");
        System.out.println("3. Caesar Cipher");
        System.out.print("Enter your choice (1, 2, or 3): ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Choose your operation:");
                System.out.println("a. Convert Text to Morse Code");
                System.out.println("b. Convert Morse Code to Text");
                System.out.print("Enter your operation (a or b): ");
                String morseOperation = scanner.nextLine();
                if (morseOperation.equals("a")) {
                    System.out.print("Enter text: ");
                    String text = scanner.nextLine();
                    System.out.println("Morse Code: " + convertToMorse(text));
                } else if (morseOperation.equals("b")) {
                    System.out.print("Enter Morse code: ");
                    String morseCode = scanner.nextLine();
                    System.out.println("Text: " + convertToText(morseCode));
                } else {
                    System.out.println("Invalid choice. Please enter 'a' or 'b'.");
                }
                break;

            case "2":
                System.out.println("Choose your operation:");
                System.out.println("c. Encode Text to Chappe Code");
                System.out.println("d. Decode Chappe Code to Text");
                System.out.print("Enter your operation (c or d): ");
                String chappeOperation = scanner.nextLine();
                if (chappeOperation.equals

("c")) {
                    System.out.print("Enter text: ");
                    String text = scanner.nextLine();
                    System.out.println("Chappe Code: " + encodeToChappe(text));
                } else if (chappeOperation.equals("d")) {
                    System.out.print("Enter Chappe code: ");
                    String chappeCode = scanner.nextLine();
                    System.out.println("Text: " + decodeFromChappe(chappeCode));
                } else {
                    System.out.println("Invalid choice. Please enter 'c' or 'd'.");
                }
                break;

            case "3":
                System.out.println("Choose your operation:");
                System.out.println("e. Encrypt a message using Caesar cipher");
                System.out.println("f. Decrypt a message using Caesar cipher");
                System.out.print("Enter your operation (e or f): ");
                String caesarOperation = scanner.nextLine();
                if (caesarOperation.equals("e")) {
                    System.out.print("Enter message to encrypt: ");
                    String text = scanner.nextLine();
                    System.out.print("Enter the shift value: ");
                    int shift = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Encrypted message: " + caesarCipher(text, shift));
                } else if (caesarOperation.equals("f")) {
                    System.out.print("Enter message to decrypt: ");
                    String text = scanner.nextLine();
                    System.out.print("Enter the shift value: ");
                    int shift = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Decrypted message: " + caesarCipher(text, -shift));
                } else {
                    System.out.println("Invalid choice. Please enter 'e' or 'f'.");
                }
                break;

            default:
                System.out.println("Invalid Choice");
        }

        scanner.close();
    }

    // Convert Text to Morse Code
    private static String convertToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (morseDictionary.containsKey(c)) {
                morseCode.append(morseDictionary.get(c)).append(" ");
            } else {
                morseCode.append(" ");
            }
        }
        return morseCode.toString().trim();
    }

    // Convert Morse Code to Text
    private static String convertToText(String morseCode) {
        StringBuilder text = new StringBuilder();
        String[] morseWords = morseCode.split("\\s+");
        for (String word : morseWords) {
            if (word.equals("/")) {
                text.append(" ");
            } else {
                for (Map.Entry<Character, String> entry : morseDictionary.entrySet()) {
                    if (entry.getValue().equals(word)) {
                        text.append(entry.getKey());
                        break;
                    }
                }
            }
        }
        return text.toString();
    }

    // Encode Text to Chappe Code
    private static String encodeToChappe(String text) {
        StringBuilder chappeCode = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (chappeDictionary.containsKey(c)) {
                chappeCode.append(chappeDictionary.get(c)).append(" ");
            } else {
                chappeCode.append(" ");
            }
        }
        return chappeCode.toString().trim();
    }

    // Decode Chappe Code to Text
    private static String decodeFromChappe(String chappeCode) {
        StringBuilder text = new StringBuilder();
        String[] chappeWords = chappeCode.split("\\s+");
        for (String word : chappeWords) {
            for (Map.Entry<Character, String> entry : chappeDictionary.entrySet()) {
                if (entry.getValue().equals(word)) {
                    text.append(entry.getKey());
                    break;
                }
            }
        }
        return text.toString();
    }
}

and

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class InventoryManagerGUI extends JFrame implements ActionListener {
    private JTextField inputTextField;
    private JTextArea outputTextArea;

    public InventoryManagerGUI() {
        setTitle("Inventory Manager");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        inputTextField = new JTextField();
        panel.add(inputTextField, BorderLayout.NORTH);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        panel.add(convertButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputText = inputTextField.getText();
        String outputText = "";

        Scanner scanner = new Scanner(System.in);

        switch (inputText) {
            case "1":
                System.out.println("Choose your operation:");
                System.out.println("a. Convert Text to Morse Code");
                System.out.println("b. Convert Morse Code to Text");
                System.out.print("Enter your operation (a or b): ");
                String morseOperation = scanner.nextLine();
                if (morseOperation.equals("a")) {
                    System.out.print("Enter text: ");
                    String text = scanner.nextLine();
                    outputText = convertToMorse(text);
                } else if (morseOperation.equals("b")) {
                    System.out.print("Enter Morse code: ");
                    String morseCode = scanner.nextLine();
                    outputText = convertToText(morseCode);
                } else {
                    outputText = "Invalid choice. Please enter 'a' or 'b'.";
                }
                break;

            case "2":
                System.out.println("Choose your operation:");
                System.out.println("c. Encode Text to Chappe Code");
                System.out.println("d. Decode Chappe Code to Text");
                System.out.print("Enter your operation (c or d): ");
                String chappeOperation = scanner.nextLine();
                if (chappeOperation.equals("c")) {
                    System.out.print("Enter text: ");
                    String text = scanner.nextLine();
                    outputText = encodeToChappe(text);
                } else if (chappeOperation.equals("d")) {
                    System.out.print("Enter Chappe code: ");
                    String chappeCode = scanner.nextLine();
                    outputText = decodeFromChappe(chappeCode);
                } else {
                    outputText = "Invalid choice. Please enter 'c' or 'd'.";
                }
                break;

            case "3":
                System.out.println("Choose your operation:");
                System.out.println("e. Encrypt a message using Caesar cipher");
                System.out.println("f. Decrypt a message using Caesar cipher");
                System.out.print("Enter your operation (e or f): ");
                String caesarOperation = scanner.nextLine();
                if (caesarOperation.equals("e")) {
                    System.out.print("Enter message to encrypt: ");
                    String text = scanner.nextLine();
                    System.out.print("Enter the shift value: ");
                    int shift = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    outputText = caesarCipher(text, shift);
                } else if (caesarOperation.equals("f")) {
                    System.out.print("Enter message to decrypt: ");
                    String text = scanner.nextLine();
                    System.out.print("Enter the shift value: ");
                    int shift = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    outputText = caesarCipher(text, -shift);
                } else {
                    outputText = "Invalid choice. Please enter 'e' or 'f'.";
                }
                break;

            default:
                outputText = "Invalid Choice";
        }

        scanner.close();
        outputTextArea.setText(outputText);
    }

    // Morse code translation dictionary
    private static final Map<Character, String> morseDictionary = new HashMap<>();
    static {
        morseDictionary.put('A', ".-");
        morseDictionary.put('B', "-...");
        morseDictionary.put('C', "-.-.");
        // Add other Morse code mappings
    }

    // Chappe code translation dictionary
    private static final Map<Character, String> chappeDictionary = new HashMap<>();
    static {
        chappeDictionary.put('A', "1-");
        chappeDictionary.put('B', "-111");
        chappeDictionary.put('C', "-1-1");
        // Add other Chappe code mappings
    }

    // Caesar Cipher
    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) (((ch - base + shift) % 26) + base);
            }
            result.append(ch);
        }

        return result.toString();
    }

    // Convert Text to Morse Code
    private static String convertToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (morseDictionary.containsKey(c)) {
                morseCode.append(morseDictionary.get(c)).append(" ");
            } else {
                morseCode.append(" ");
            }
        }
        return morseCode.toString().trim();
    }

    // Convert Morse Code to Text
    private static String convertToText(String morseCode) {
        StringBuilder text = new StringBuilder();
        String[] morseWords = morseCode.split("\\s+");
        for (String word : morseWords) {
            if (word.equals("/")) {
                text.append(" ");
            } else {
                for (Map.Entry<Character, String> entry : morseDictionary.entrySet()) {
                    if (entry.getValue().equals(word)) {
                        text.append(entry.getKey());
                        break;
                    }
                }
            }
        }
        return text.toString();
    }

    // Encode Text to Chappe Code
    private static String encodeToChappe(String text) {
        StringBuilder chappeCode = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (chappeDictionary.containsKey(c)) {
                chappeCode.append(chappeDictionary.get(c)).append(" ");
            } else {
                chappeCode.append(" ");
            }
        }
        return chappeCode.toString().trim();
    }

    // Decode Chappe Code to Text
    private static String decodeFromChappe(String chappeCode) {
        StringBuilder text = new StringBuilder();
        String[] chappeWords = chappeCode.split("\\s+");
        for (String word : chappeWords) {
            for (Map.Entry<Character, String> entry : chappeDictionary.entrySet()) {
                if (entry.getValue().equals(word)) {
                    text.append(entry.getKey());
                    break;
                }
            }
        }
        return text.toString();
    }
}


combine these two codes