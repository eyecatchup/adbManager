/*
 *  Author: Davide TheZero Silvetti [thezerotux@gmail.com]
 *  
 *  
 *  Rilasciato sotto Licenza:
 *  *****************************************************************
 *              DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                     Version 2, December 2004
 * 
 *  Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 * 
 *  Everyone is permitted to copy and distribute verbatim or modified
 *  copies of this license document, and changing it is allowed as long
 *  as the name is changed.
 * 
 *             DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *    TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 * 
 *   0. You just DO WHAT THE FUCK YOU WANT TO.
 * 
 *  *****************************************************************
 * 
 */

/*
 * Something useful https://developer.android.com/tools/help/adb.html 
 */

import javax.swing.*;          

import java.awt.event.*;
import java.io.File;
import java.util.List;
import java.util.Vector;

@SuppressWarnings("serial")
public class adbManager extends JFrame implements ActionListener {

    // Variables declaration - do not modify                     
    private JButton scegli;
    private JButton installa;
    private JButton pull;
    private JButton push;
    private JCheckBox prefersd;
    private JComboBox<String> deviceList;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTextField filepath;
    private JTextField topc;
    private JTextField todevice;
    private JTextField fromdevice;
    private JTextField frompc;
    private JLabel modelmo;
    private JFileChooser fc;
    // End of variables declaration     
    
    // AUTO-GENERATED BLOCK
    public void createComponents() {
    	
        deviceList = new JComboBox<String>();
        jPanel1 = new JPanel();
        prefersd = new JCheckBox();
        filepath = new JTextField();
        scegli = new JButton();
        installa = new JButton();
        pull = new JButton();
        push = new JButton();
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        topc = new JTextField();
        todevice = new JTextField();
        jPanel3 = new JPanel();
        fromdevice = new JTextField();
        frompc = new JTextField();
        modelmo = new JLabel();
        
        fc = new JFileChooser();
        
	    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    
	    fc.setFileFilter(new APKFilter());

	    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("apk Installer"));

        prefersd.setText("Installa su SD");

        scegli.setText("...");

        installa.setText("Installa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filepath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scegli))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(prefersd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(installa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filepath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scegli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prefersd)
                    .addComponent(installa))
                .addGap(4, 4, 4))
        );

        jLabel1.setText("Seleziona Device:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("File Transfer to device"));

        todevice.setText("/sdcard/");

        push.setText("Invia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(todevice, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addComponent(topc)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(push, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(topc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(todevice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(push)
                .addGap(5, 5, 5))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("File Transfer from device"));

        fromdevice.setText("/sdcard/");

        pull.setText("Ricevi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frompc)
                    .addComponent(fromdevice, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pull, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fromdevice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frompc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pull)
                .addGap(5, 5, 5))
        );

        modelmo.setText("Model Device");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deviceList, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modelmo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deviceList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(modelmo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scegli.addActionListener(this);
        installa.addActionListener(this);
        push.addActionListener(this);
        pull.addActionListener(this);
        
        pack();
    }
    // END AUTO-GENERATED BLOCK

    // Set the Swing's Look
    private static void initLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
                System.err.println("Can't use the specified look and feel on this platform.");
                System.err.println("Using the default look and feel.");
        } catch (Exception e) {
                System.err.println("Couldn't get specified look and feel, for some reason.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
        }
    }

    // List the connected devices
    private void initDevices() {
    	Vector<String> devices = new Vector<String>();
		List<String> result = null;
		
		result = Utils.Execute(Utils.adb_location+" devices");
		
		String[] lines = new String[2];
		Integer i = 0;
		
		if (result != null) {
			for (String line : result) {
				System.out.println(line);
				if(i>0 && !line.isEmpty()){
					lines=line.split("\t");
					devices.add(lines[0]);
				}
				i++;
			}
		}
		
		deviceList.setModel(new DefaultComboBoxModel<String>(devices));
		deviceList.setSelectedIndex(-1);
		deviceList.addActionListener(this);
		
    }
    
    // Get selected device's name
    private void initConnectedDevice(){
    	if(!Utils.device_uuid.isEmpty()){
        	List<String> result = null;
    		
    		result = Utils.Execute(Utils.adb_location+" -s "+Utils.device_uuid+" shell cat /system/build.prop");
    		
    		if (result != null) {
    			for (String line : result) {
    				if(!line.isEmpty()){
    					if(line.indexOf("ro.product.model") == 0){
    						modelmo.setText(line.replace("ro.product.model=", ""));
    						System.out.println(line.replace("ro.product.model=", ""));
    					}
    				}
    			}
    		}
        } else {
        	modelmo.setText("No Device");
        }
    }
    
    // Install APK on device
    private void installApk(Boolean sd){
    	if(!filepath.getText().isEmpty()){
	    	if(sd){
	        	List<String> result = null;
	    		
	    		push(filepath.getText(),"/sdcard/");
	    		
	    		String[] fname;
	    		fname = filepath.getText().split("\\"+Utils.ds);
	    		
	    		result = Utils.Execute(Utils.adb_location+" -s "+Utils.device_uuid+" shell pm install -s \"/sdcard/"+fname[fname.length-1]+"\"");
	    		
	    		if (result != null) {
	    			for (String line : result) {
	    				if(!line.isEmpty()){
	    					System.out.println(line);
	    				}
	    			}
	    		}

	        } else {
	        	List<String> result = null;
	    		
	    		result = Utils.Execute(Utils.adb_location+" -s "+Utils.device_uuid+" install \""+filepath.getText()+"\"");
	    		
	    		int i=0;
	    		if (result != null) {
	    			for (String line : result) {
	    				if(!line.isEmpty()){
	    					System.out.println(line);
	    					if(i==1){
	    						JOptionPane.showMessageDialog(null, line,Utils.APPNAME, 1);
	    					}
	    					i++;
	    				}
	    			}
	    		}
	        }
    	}
    }   
    
    // Install APK on device
    private void push(String fpath, String tpath){
    	if(!fpath.isEmpty() && !tpath.isEmpty()){
	        List<String> result = null;
	    		
	    	result = Utils.Execute(Utils.adb_location+" -s "+Utils.device_uuid+" push \""+fpath+"\" \""+tpath+"\"");
	    		
    		if (result != null) {
    			for (String line : result) {
    				if(!line.isEmpty()){
    					System.out.println(line);
    				}
    			}
    		}
    	}else{
    		System.out.print("null");
    	}
    }  
    
    // Install APK on device
    private void pull(String fpath, String tpath){
    	if(!fpath.isEmpty() && !tpath.isEmpty()){
	        List<String> result = null;
	    		
	    	result = Utils.Execute(Utils.adb_location+" -s "+Utils.device_uuid+" pull \""+fpath+"\" \""+tpath+"\"");
	    		
    		if (result != null) {
    			for (String line : result) {
    				if(!line.isEmpty()){
    					System.out.println(line);
    				}
    			}
    		}
    	}else{
    		System.out.print("null");
    	}
    }
    
    
    /*
     * 
     * **************************************************************************************************************
     * **************************************************************************************************************
     * **************************************************************************************************************
     * **************************************************************************************************************
     * 
     */
    
    public adbManager() {
        this.setTitle("adb Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createComponents();
        initDevices();
        initConnectedDevice();
        
        setVisible(true);
        
    }

    public static void main(String[] args) {

    	initLookAndFeel();

        setDefaultLookAndFeelDecorated(true);
        
        if(Utils.os.indexOf("Mac") >= 0){
    		JOptionPane.showMessageDialog(null, Utils.APPNAME+" non è ancora compatibile con questa piattaforma","", 1);
    		System.exit(0);
    	}
        
    	new Preference();
    	
    	if(Utils.whereIsAdb().isEmpty()){
        	new GetAdb();
        } else {
        	new adbManager();
        }
    }
    
    // Puff, Action listener
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == deviceList) {
			String device = ((String)deviceList.getSelectedItem());
			Utils.device_uuid = device;
			initConnectedDevice();
		}
    	if (e.getSource() == scegli){
    		int returnVal = fc.showOpenDialog(adbManager.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                filepath.setText(file.getAbsolutePath());
            } else {
            	System.out.print("Open command cancelled by user.");
            }
    	}
    	if (e.getSource() == installa){
            if(prefersd.isSelected()){ 
    			installApk(true);
    		}
    		else{
    			installApk(false);
    		}
    	}
    	if (e.getSource() == push){
    		if(!topc.getText().isEmpty() && !todevice.getText().isEmpty()){
	    		push(topc.getText(),todevice.getText());
	    		//JOptionPane.showMessageDialog(null, topc.getText()+" Inviato","", 1);
    		}
    	}
    	if (e.getSource() == pull){
    		if(!frompc.getText().isEmpty() && !fromdevice.getText().isEmpty()){
	    		pull(fromdevice.getText(),frompc.getText());
	    		//JOptionPane.showMessageDialog(null, fromdevice.getText()+" Ricevuto","", 1);
    		}
    	}
    }
}