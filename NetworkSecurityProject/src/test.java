
import DigitalCertificate.Message;
import DigitalCertificate.VerifyMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.KeyFactory;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javafx.stage.PopupWindow;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import networksecurityproject.FileDialog;

public abstract class test extends Thread {

    public static void main(String[] args) throws IOException, Exception {
        String data = "leducthang";
        byte[] b = data.getBytes();
        Message msg = new Message(data, "privateKey.txt");
        byte[] datasigned = msg.sign(data, "privateKey.txt");
        for (int i = 0; i < datasigned.length; i++) {
            System.out.print(datasigned[i] + " ");
        }
    }
}
