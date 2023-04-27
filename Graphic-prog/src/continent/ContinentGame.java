    package continent;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.KeyEvent;


    public class ContinentGame extends JFrame implements ActionListener {
        private final JButton[] buttons;
        private int remainingContinents;

        public ContinentGame() {
            super("Континенти");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 500);

            String[] continents = {"Африка", "Європа", "Азія", "Північна Америка", "Південна Америка", "Антарктида", "Австралія"};
            remainingContinents = continents.length;
            buttons = new JButton[continents.length];

            JPanel panel = new JPanel(new GridLayout(3, 3));
            for (int i = 0; i < buttons.length; i++) {
                buttons[i] = new JButton(continents[i]);
                buttons[i].addActionListener(this);
                panel.add(buttons[i]);
            }

            getContentPane().add(panel, BorderLayout.CENTER);
            setVisible(true);
        }

        private String promptForContinent() {
            String continent = JOptionPane.showInputDialog(this, "Введіть назву континенту:");
            return continent;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source instanceof JButton) {
                JButton button = (JButton) source;
                String buttonText = button.getText();
                if (buttonText != null && !buttonText.isEmpty()) {
                    String continent = promptForContinent();
                    if (buttonText.equalsIgnoreCase(continent)) {
                        button.setVisible(false);
                        remainingContinents--;
                        if (remainingContinents == 0) {
                            JOptionPane.showMessageDialog(this, "Відвідав всі континенти");
                            dispose();
                        }
                    }
                }
            }
        }


    }
