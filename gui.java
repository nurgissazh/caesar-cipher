import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;




public class gui extends JFrame implements ActionListener {
	
	int[][] puzzle = new int[9][9];
	FlowLayout experimentLayout = new FlowLayout();
	private JPanel controls = new JPanel();
	private JPanel write = new JPanel();
	JTextArea canvas = new JTextArea();
	JTextField CipherKeyIn = new JTextField(10);
	JFileChooser fc = new JFileChooser();
	private JButton decrypt = new JButton("Decrypt Text");
	private JButton encrypt = new JButton("Encrypt text");
	private JButton read = new JButton("Save");
	private JButton load = new JButton("Load");
	private JButton rules = new JButton("Rules");
	JScrollPane sp = new JScrollPane(write);
	JScrollBar bar = new JScrollBar();
	String Location = null;
	boolean justRead = false;
	boolean justSolved = false;
	boolean justGen = false;
	String Error = "NA";
         
    public gui() {
        getContentPane().setLayout(new BorderLayout());
        encrypt.addActionListener(this);
        decrypt.addActionListener(this);
        read.addActionListener(this);
        load.addActionListener(this);
        rules.addActionListener(this);
        controls.add(encrypt);
        controls.add(decrypt);
        controls.add(read);
        controls.add(load);
        
        JScrollPane scrollPane = new JScrollPane(canvas);
        
        setPreferredSize(new Dimension(6000, 6000));
        JButton button;
        JPanel pane = new JPanel();
        JPanel encryptionControls = new JPanel();
        encryptionControls.setLayout(new FlowLayout());
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (true) {
        //natural height, maximum width
        c.fill = GridBagConstraints.HORIZONTAL;
        }
     
        JLabel cipherKey = new JLabel("Cipher Key:");
       // c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,0,0,0);
        pane.add(cipherKey, c);
        CipherKeyIn = new JTextField(10);
        // c.fill = GridBagConstraints.HORIZONTAL;
         c.anchor = GridBagConstraints.BASELINE;
         c.weightx = 0.5;
         c.gridx = 1;
         c.gridy = 0;
         c.insets = new Insets(10,10,0,0);
         pane.add(CipherKeyIn, c);
         encryptionControls.add(pane);
        
        
     
       

        add(scrollPane, BorderLayout.CENTER);    
        canvas.setBorder(BorderFactory.createTitledBorder("Text Input"));
        canvas.setPreferredSize(new Dimension (250, 250));
        //this will enable the word wrapping feature
        canvas.setLineWrap(true);
        canvas.setWrapStyleWord(true);
       // write.add(canvas);
       // getContentPane().add("North", write);
        getContentPane().add("South", controls);
        getContentPane().add("East", encryptionControls);
        
        getContentPane().setSize(400, 700);
    } // init()
	
	
	public void actionPerformed(ActionEvent e) {
		encrypt encryption = new encrypt();
		String encryptedText;
		String plainText;
		String currentKey = CipherKeyIn.getText();
		if(e.getSource() == encrypt){
			plainText = canvas.getText();
			encryptedText = encryption.ceaserCipher(plainText, currentKey);
			plainText = "";
			canvas.setText(encryptedText);
			
		}if(e.getSource() == decrypt){
			encryptedText = canvas.getText();
			plainText = encryption.decryptCeaserCipher(encryptedText, currentKey);
			canvas.setText(plainText);
		}
		
	}
	public static void main(String[] args){
		gui maingui = new gui();
        Object[] options = { "OK"};
            
        maingui.setSize(750,500);
        maingui.setVisible(true);
        //JOptionPane.showOptionDialog(null, "Welcome to the Dr T-Rav's Encryptor","Quick Note!",
        //JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0]);
        maingui.addWindowListener(new WindowAdapter() {// Quit the application
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
