package study.internet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

public class DialogAuthentication extends Authenticator{
    private JDialog passwordDialog;
    private JTextField usernameField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JButton okButton = new JButton("OK");
    private JButton cancelButton = new JButton("Cancel");
    private JLabel mainLabel = new JLabel("Please enter your username and password");

    public DialogAuthentication(String username, JFrame parent) {
        this.passwordDialog = new JDialog(parent, true);
        Container pane = passwordDialog.getContentPane();
        pane.setLayout(new GridLayout(4, 1));

        JLabel userLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        pane.add(mainLabel);

        JPanel panel_1 = new JPanel();
        panel_1.add(userLabel);
        panel_1.add(usernameField);
        usernameField.setText(username);
        pane.add(panel_1);

        JPanel panel_2 = new JPanel();
        panel_2.add(passwordLabel);
        panel_2.add(passwordField);
        pane.add(panel_2);

        JPanel panel_3 = new JPanel();
        panel_3.add(okButton);
        panel_3.add(cancelButton);
        pane.add(panel_3);

        passwordDialog.pack();

        ActionListener okListener = new OKResponse();
        ActionListener cancelListener = new CancelResponse();
        okButton.addActionListener(okListener);
        usernameField.addActionListener(okListener);
        passwordField.addActionListener(okListener);
        cancelButton.addActionListener(cancelListener);
    }

    public DialogAuthentication(JFrame parent) {
        this("", parent);
    }

    public DialogAuthentication(String username) {
        this(username, new JFrame());
    }

    public DialogAuthentication() {
        this("", new JFrame());
    }

    private void show() {
        String prompt = this.getRequestingPrompt();
        if (prompt == null) {
            String site = this.getRequestingSite().getHostName();
            String protocol = this.getRequestingProtocol();
            int port = this.getRequestingPort();

            if (site != null & protocol != null) {
                prompt = protocol + "://" + site;
                if (port > 0) prompt += ":" + port;
            } else {
                prompt = "";
            }
        }

        mainLabel.setText("Please enter username and password for " + prompt + ": ");
        passwordDialog.pack();
        passwordDialog.setVisible(true);
    }
    PasswordAuthentication respone = null;

    private class OKResponse implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            passwordDialog.setVisible(false);

            char[] password = passwordField.getPassword();
            String username = usernameField.getText();

            passwordField.setText("");
            respone = new PasswordAuthentication(username, password);
        }
    }

    private class CancelResponse implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            passwordDialog.setVisible(false);
            passwordField.setText("");
            respone = null;
        }
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        this.show();
        return this.respone;
    }


    @Override
    protected URL getRequestingURL() {
        return super.getRequestingURL();
    }

    @Override
    protected RequestorType getRequestorType() {
        return super.getRequestorType();
    }

    public static void main(String[] args) {
        Authenticator.setDefault(new DialogAuthentication());

        try {
            URL url = new URL("http://www.baidu.com");
            try(InputStream in = new BufferedInputStream(url.openStream())) {
                Reader reader = new InputStreamReader(in);
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        System.exit(0);
    }
}
