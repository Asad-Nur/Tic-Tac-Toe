import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener {


    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton reset_button = new JButton();
    boolean player1_turn;

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(null);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(Color.GRAY);
        textField.setForeground(Color.blue);
        textField.setFont(new Font("Dialog",Font.ITALIC,25));

        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Welcome to Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new GridLayout());
        title_panel.setBounds(0,0,800,100);

        title_panel.add(reset_button);
        reset_button.setText("Reset");
        reset_button.setFont(new Font("Dialog", Font.BOLD, 30));
        reset_button.addActionListener(this);

        button_panel.setLayout(new GridLayout(3,3));

        for(int i = 0; i < 9; i++) {

            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setOpaque(true);
            buttons[i].setFont(new Font("Dialog",Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reset_button) {
            resetGame();
        }

        for(int i = 0; i < 9; i++) {
            if(e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if(buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("it is O's turn!");
                        check();
                    }
                } else{
                    if(buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("it is X's turn!");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2)==0) {
            player1_turn = true;
            textField.setText("X gets first turn!");
        }else {
            player1_turn = false;
            textField.setText("O gets first turn!");

        }
    }

    public void check() {
        //check if X wins
        if (
                        (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")
        ) {
            xWins(0, 1, 2);
        }
        if (
                        (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
        }
        if (
                        (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
        }
        if (
                        (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);
        }
        if (
                        (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);
        }
        if (
                        (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);
        }

        if (
                        (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);
        }
        if (
                        (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(2, 4, 6);
        }
        //check if O wins
        if (
                        (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);
        }
        if (
                        (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
        }
        if (
                        (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
        }
        if (
                        (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
        }
        if (
                        (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
        }

        if (
                        (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
        }
        if (
                        (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
        }
        if (
                        (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
        }
    }



    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);

        }
        textField.setText("X Wins!");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);

        }
        textField.setText("O Wins!");
    }

    public void resetGame() {
        for(int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackground(null);
        }
        player1_turn = true;
        textField.setText("Welcome to Tic-Tac-Toe");
        firstTurn();
    }

}
