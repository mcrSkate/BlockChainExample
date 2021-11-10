import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class App {

    public static JLabel threadJLabel;
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        BlockChain system = new HashSystem();

        threadJLabel = new JLabel("");
        threadJLabel.setBounds(290, 40, 140, 20);

        JLabel guiJLabel = new JLabel("Insira uma informacao abaixo!");
        guiJLabel.setBounds(20, 10, 260, 20);

        JTextField guiTextField = new JTextField();
        guiTextField.setBounds(20, 40, 260, 20);

        JButton addButton = new JButton("Adicionar Informacao");
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                system.addBlock(guiTextField.getText());
                guiTextField.setText("");
                new Thread(displayMsg).start();
            }
        });
        addButton.setBounds(20,70,160,20);

        JTextPane guiJTextPane = new JTextPane();
        guiJTextPane.setEditable(false);

        JScrollPane guiJScrollPane = new JScrollPane();
        guiJScrollPane.setBounds(20, 120, 486, 366);
        guiJScrollPane.setViewportView(guiJTextPane);

        JButton historic = new JButton("Mostrar Historico");
        historic.setBounds(200,70,160,20);
        historic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                guiJTextPane.setText(system.getHistoric());
            }
        });

        JPanel guiJPanel = new JPanel();
        guiJPanel.setBackground(new Color(255,255,255));
        guiJPanel.setBorder(new EmptyBorder(5,5,5,5));
        guiJPanel.setLayout(null);
        guiJPanel.add(guiJLabel);
        guiJPanel.add(guiTextField);
        guiJPanel.add(addButton);
        guiJPanel.add(guiJScrollPane);
        guiJPanel.add(historic);
        guiJPanel.add(threadJLabel);

        JFrame guiFrame = new JFrame();
        guiFrame.setTitle("BlockChain Example");
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setBounds(100,100,536,536);
        guiFrame.setContentPane(guiJPanel);
        guiFrame.setVisible(true);

    }

    public static Runnable displayMsg = new Runnable() {
        public void run(){
            try{
                threadJLabel.setText("Informacao Adicionada");
                Thread.sleep(3000);
                threadJLabel.setText("");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return;
        }
    };
}
