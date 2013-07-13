import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GetAdb extends JFrame implements ActionListener {
	JFileChooser fc;
	JButton button;
	JButton ok;
	JTextField text;
	
	public GetAdb(){
		
		this.setTitle("adb Location Select");
		setLocationRelativeTo(null);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
		JLabel type = new JLabel("<html><b>Ooops. Non riesco a trovare adb.<br/>Seleziona il file di adb</b></html>:", 0);
		
	    button = new JButton("...");
	    button.addActionListener(this);
	    
	    text = new JTextField();
	    
	    fc = new JFileChooser();
	    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    
	    ok = new JButton("OK");
	    ok.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(type)
                            .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button))
                    .addComponent(ok))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(type)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ok)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        
		setResizable(false);
		setVisible(true);
		pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            int returnVal = fc.showOpenDialog(GetAdb.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                text.setText(file.getAbsolutePath());
                System.out.print("Opening: " + file.getAbsolutePath() + ".");
            } else {
            	System.out.print("Open command cancelled by user.");
            }
        } else if (e.getSource() == ok){
        	Preference.setAdbLocation(text.getText());
        	Utils.adb_location = text.getText();
        	Utils.PleaseCloseMe(this);
        	new adbManager();
        }
	}
}
