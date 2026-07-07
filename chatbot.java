import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class chatbot extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    HashMap<String, String> responses;

    public chatbot() {
        setTitle("AI Chatbot");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(chatArea);

        JPanel panel = new JPanel(new BorderLayout());

        inputField = new JTextField();
        sendButton = new JButton("Send");

        sendButton.addActionListener(this);
        inputField.addActionListener(this);

        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        initializeResponses();

        chatArea.append("Bot: Hello! I am your AI Chatbot.\n");
        chatArea.append("Bot: Ask me anything.\n\n");

        setVisible(true);
    }

    private void initializeResponses() {
        responses = new HashMap<>();

        responses.put("hello", "Hello! How can I help you?");
        responses.put("hi", "Hi! Nice to meet you.");
        responses.put("how are you", "I'm doing great! Thanks for asking.");
        responses.put("your name", "I'm a Java AI Chatbot.");
        responses.put("bye", "Goodbye! Have a great day.");
        responses.put("java", "Java is a powerful object-oriented programming language.");
        responses.put("oop", "OOP stands for Object-Oriented Programming.");
        responses.put("ai", "Artificial Intelligence enables machines to mimic human intelligence.");
        responses.put("nlp", "Natural Language Processing helps computers understand human language.");
        responses.put("thank you", "You're welcome!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String userInput = inputField.getText().trim();

        if (userInput.isEmpty())
            return;

        chatArea.append("You: " + userInput + "\n");

        String response = getResponse(userInput.toLowerCase());

        chatArea.append("Bot: " + response + "\n\n");

        inputField.setText("");
    }

    private String getResponse(String input) {

        for (String key : responses.keySet()) {
            if (input.contains(key)) {
                return responses.get(key);
            }
        }

        return "Sorry, I don't understand. Please ask another question.";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new chatbot());
    }
}
