/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksecurityproject;

import DigitalCertificate.GenerateKeys;
import DigitalCertificate.Message;
import DigitalCertificate.VerifyMessage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

class ServerClientThread extends Thread {

    Socket serverClient;
    int clientNo;
    int squre;
    static String user;
    static String pass;
    static String adminOf = "";
    static String memberOf = "";
    static String noti = "";

    ServerClientThread(Socket inSocket, int counter) {
        serverClient = inSocket;
        clientNo = counter;
    }

    public static String readData(String fileName) throws FileNotFoundException, IOException {
        String result = "";
        String typeOfFile = fileName.substring(fileName.length() - 4);
        if (typeOfFile.equals(".doc")) {
            POIFSFileSystem fs = null;
            try {
                fs = new POIFSFileSystem(new FileInputStream(fileName));
                HWPFDocument doc = new HWPFDocument(fs);
                WordExtractor we = new WordExtractor(doc);
                String[] paragraphs = we.getParagraphText();
                for (int i = 0; i < paragraphs.length; i++) {

                    result += paragraphs[i].toString();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (typeOfFile.equals(".txt")) {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            result += line + "\r\n";
            while (line != null) {
                line = reader.readLine();
                result += line + "\r\n";
            }

            reader.close();
        }

        return result;
    }

    public static void replaceLine(int line, String replace, File f) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(f));
        ArrayList<String> data = new ArrayList<>();
        String l = reader.readLine();
        data.add(l);
        while (l != null) {
            l = reader.readLine();
            data.add(l);
        }
        reader.close();
        data.set(line, replace);
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
        String result = "";
        for (int i = 0; i < data.size(); i++) {
            if (i == data.size() - 1) {
                continue;
            }
            result += data.get(i) + "\n";

        }
        FileWriter fr = new FileWriter(f, false);
        fr.write(result);
        fr.flush();
        fr.close();

    } // members in groups

    public static void getNotification() {
        noti = "";
        for (String adminOfGroups : adminOf.split(", ")) {
            File directToNotification = new File(".\\data\\userdata\\Groups\\" + adminOfGroups + "\\" + "notification.txt");
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(directToNotification));
                String line = reader.readLine();
                while (line != null) {
                    noti += line + "\n";
                    line = reader.readLine();
                }

                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    } //get noti

    public static void removeLine(String lineContent, File f) throws IOException {
        File file = f;
        List<String> out = Files.lines(file.toPath())
                .filter(line -> !line.contains(lineContent))
                .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    } // delete noti

    public void run() {
        try {
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            ArrayList<String> list_users = new ArrayList<>();
            String clientMessage = "", serverMessage = "";
            boolean isLogin = false;
            while (!clientMessage.equals("-exit")) {
                clientMessage = inStream.readUTF();
                System.out.println("Command from client " + clientNo + " :" + clientMessage);
                //help
                if (clientMessage.equals("-help")) {
                    if (isLogin) {
                        serverMessage = "-createGroup: create your own group \n-join: join a group \n-showGroups: show groups exist \n-getNoti: get your notification \n-upload: upload file \n-download: download file \n-info: get your infomation"; // -login
                        outStream.writeUTF(serverMessage);
                        outStream.flush();
                    } else {
                        serverMessage = "-login: login app with your account \n-regist: create a new account \n-showGroups: show groups exist \n-exit: exit  "; // -login
                        outStream.writeUTF(serverMessage);
                        outStream.flush();
                    }

                } // login
                else if (clientMessage.equals("-login")) {
                    if (isLogin) {
                        outStream.writeUTF("Aready logined");
                        outStream.flush();
                    } else {
                        outStream.writeUTF("Enter < username:password > ");
                        outStream.flush();
                        clientMessage = inStream.readUTF();
                        BufferedReader reader;
                        String[] User0Pass1 = new String[2];
                        User0Pass1[0] = "";
                        User0Pass1[1] = "";
                        int temp = 0;
                        for (int i = 0; i < clientMessage.length(); i++) {
                            if (clientMessage.charAt(i) == ':') {
                                temp++;
                                continue;
                            }
                            User0Pass1[temp] += clientMessage.charAt(i);
                        }
                        user = User0Pass1[0];
                        pass = User0Pass1[1];
                        try {
                            reader = new BufferedReader(new FileReader(".\\data\\admindata\\info_users.txt"));
                            String line = reader.readLine();
                            while (line != null) {
                                list_users.add(line);
                                line = reader.readLine();
                            }

                            reader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        int x;
                        for (x = 0; x < list_users.size(); x++) {
                            String[] xUserPass = new String[2];
                            xUserPass[0] = "";
                            xUserPass[1] = "";
                            String userAtX = (String) list_users.get(x);
                            int tempp = 0;
                            for (int i = 0; i < userAtX.length(); i++) {
                                if (userAtX.charAt(i) == ':') {
                                    tempp++;
                                    continue;
                                }
                                xUserPass[tempp] += userAtX.charAt(i);
                            }

                            if (xUserPass[0].equals(User0Pass1[0]) && xUserPass[1].equals(User0Pass1[1])) {
                                x--;
                                break;
                            }
                        }
                        if (x == list_users.size()) {
                            System.out.println("Username and password not found");
                            outStream.writeUTF("Invalid Username or Password");
                            outStream.flush();
                        } else {
                            isLogin = true;
                            File f = new File(".\\data\\userdata\\Groups");
                            adminOf = "";
                            memberOf = "";
                            for (File file : f.listFiles()) {
                                File readme = new File(file + "\\" + "info.txt");
                                BufferedReader readerReadme = new BufferedReader(new FileReader(readme));
                                String line1 = readerReadme.readLine();
                                if (user.equals(line1)) {
                                    if (adminOf.equals("")) {
                                        adminOf += file.getName();
                                    } else {
                                        adminOf += ", " + file.getName();
                                    }
                                }
                                String line2 = readerReadme.readLine();
                                String members = line2.substring(7);
                                for (String member : members.split(",")) {
                                    if (user.equals(member)) {
                                        if (memberOf.equals("")) {
                                            memberOf += file.getName();
                                        } else {
                                            memberOf += ", " + file.getName();
                                        }
                                    }
                                }

                            }

                            System.out.println("user: " + User0Pass1[0]);
                            System.out.println("pass: " + User0Pass1[1]);
                            outStream.writeUTF("Hi " + User0Pass1[0] + "!");

                        }
                    }
                } //register
                else if (clientMessage.equals("-regist")) {
                    if (isLogin) {
                        outStream.writeUTF("Not valid");
                        outStream.flush();
                    } else {
                        outStream.writeUTF("username: ");
                        outStream.flush();
                        String user = inStream.readUTF();
                        outStream.writeUTF("pass: ");
                        outStream.flush();
                        String pass = inStream.readUTF();
                        ArrayList<String> arrList = new ArrayList<>();
                        BufferedReader reader;
                        File f = new File(".\\data\\admindata\\info_users.txt");
                        try {
                            reader = new BufferedReader(new FileReader(".\\data\\admindata\\info_users.txt"));
                            String line = reader.readLine();
                            while (line != null) {
                                arrList.add(line);
                                line = reader.readLine();
                            }

                            reader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        boolean isExistAccount = false;
                        for (int x = 0; x < arrList.size(); x++) {
                            if (arrList.get(x).contains(user + ":" + pass)) {
                                isExistAccount = true;
                                break;
                            }
                        }
                        if (isExistAccount) {
                            outStream.writeUTF("Regist failed, try again");
                            outStream.flush();
                        } else {
                            FileWriter fr = new FileWriter(f, true);
                            fr.write("\r\n" + user + ":" + pass);
                            fr.flush();
                            fr.close();
                            //Create HomeDirectory
                            File user_Folder = new File("G:\\DataDigitalSignatureProject\\" + user);
                            user_Folder.mkdir();
                            //Create Files
                            File privateKey = new File(user_Folder.getPath() + "\\" + user + "'s_Private_Key.txt");
                            File publicKey = new File(".\\data\\admindata\\keyStore\\publicKeys\\" + user + "'s_Public_Key.txt");
                            File certificateEncoded = new File(user_Folder.getPath() + "\\CertificateEncoded");
                            File publicKeyToString = new File(".\\data\\admindata\\keyStore\\publicKeys\\" + user + "'s_Public_Key_To_String.txt");
                            File certificate = new File(user_Folder.getPath() + "\\Certificate");
                            privateKey.createNewFile();
                            publicKey.createNewFile();
                            //Generate KeyPairs
                            GenerateKeys myKeys = new GenerateKeys(1024);
                            myKeys.createKeys();
                            myKeys.writeToFile(publicKey, myKeys.getPublicKey().getEncoded());
                            myKeys.writeToFile(privateKey, myKeys.getPrivateKey().getEncoded());
                            myKeys.writeToFile(certificateEncoded, myKeys.getCert().getEncoded());
                            //publicKeyToString
                            String pk = myKeys.getPublicKey().toString();
                            FileWriter fk = new FileWriter(publicKeyToString, true);
                            fk.write(pk);
                            fk.flush();
                            fk.close();
                            //
                            // Write Certificate
                            String Cert = myKeys.getCert().toString();
                            System.out.println(Cert);
                            FileWriter fc = new FileWriter(certificate, true);
                            fc.write(Cert);
                            fc.flush();
                            fc.close();

                            //
                            outStream.writeUTF("done");
                            outStream.flush();
                        }

                    }

                } //createGroup
                else if (clientMessage.equals("-createGroup")) {
                    if (isLogin) {
                        outStream.writeUTF("group_name:");
                        outStream.flush();
                        String groupName = inStream.readUTF();
                        File f = new File(".\\data\\userdata\\Groups\\" + groupName);
                        if (f.exists()) {
                            outStream.writeUTF("group existed, try again!");
                            outStream.flush();
                        } else {
                            f.mkdir();
                            File f2 = new File(f.getPath() + "/info.txt");
                            f2.createNewFile();
                            FileWriter fr2 = new FileWriter(f2, true);
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            Date date = new Date();
                            fr2.write(user + "\r\n" + "member:\r\n" + "Created at :" + formatter.format(date));
                            fr2.flush();
                            fr2.close();

                            File f3 = new File(f.getPath() + "/notification.txt");
                            f3.createNewFile();
                            if (adminOf.equals("")) {
                                adminOf += groupName;
                            } else {
                                adminOf += ", " + groupName;
                            }
                            outStream.writeUTF("group created");
                            outStream.flush();
                        }
                    } else {
                        outStream.writeUTF("You must login first ");
                        outStream.flush();
                    }
                }//showInfo
                else if (clientMessage.equals("-info")) {
                    if (isLogin) {
                        outStream.writeUTF("Account:" + user + "\nLeadGroup:" + adminOf + "\nMember Of:" + memberOf);
                        outStream.flush();
                        //
                    } else {
                        outStream.writeUTF("You must login first");
                        outStream.flush();
                    }
                }//showGroup
                else if (clientMessage.equals("-showGroups")) {
                    File f = new File(".\\data\\userdata\\Groups");
                    String data = "";
                    for (File files : f.listFiles()) {
                        data += files.getName() + "\n";
                    }
                    outStream.writeUTF(data);
                    outStream.flush();
                }//jofnGroup
                else if (clientMessage.equals("-join")) {
                    File f = new File(".\\data\\userdata\\Groups");
                    String data = "";
                    for (File files : f.listFiles()) {
                        BufferedReader reader;
                        reader = new BufferedReader(new FileReader(new File(f.getPath() + "\\" + files.getName() + "\\info.txt")));
                        String line = reader.readLine();
                        String line2 = reader.readLine();
                        boolean isJoin = false;
                        String members = line2.substring(7);
                        for (String member : members.split(",")) {
                            if (member.equals(user)) {
                                isJoin = true;
                                break;
                            }
                        }

                        if (!line.equals(user) && !isJoin) {
                            data += files.getName() + "\n";
                        }

                        reader.close();

                    }
                    outStream.writeUTF(data + "Which group do you want to join?");
                    outStream.flush();

                    boolean groupIsValid = false;
                    clientMessage = inStream.readUTF();
                    for (String d : data.split("\n")) {
                        if (clientMessage.equals(d)) {
                            // thao tac xin join
                            File joinFile = new File(".\\data\\userdata\\Groups" + "\\" + d + "\\notification.txt");
                            FileWriter fr = new FileWriter(joinFile, true);
                            fr.write(user + " requested to join group " + clientMessage + "\r\n");
                            fr.flush();
                            fr.close();
                            outStream.writeUTF("Requested");
                            outStream.flush();
                            groupIsValid = true;
                            break;

                        }
                    }
                    if (!groupIsValid) {
                        outStream.writeUTF("Group not exist");
                        outStream.flush();
                    }

                }//getNotification
                else if (clientMessage.equals("-getNoti")) {
                    ServerClientThread.getNotification();
                    String temp = "Command : < Line (0->n) :Y/N > or back";
                    outStream.writeUTF(noti + temp);
                    outStream.flush();
                    clientMessage = inStream.readUTF();
                    if (clientMessage.equals("-back")) {
                        outStream.writeUTF("Backed");
                        outStream.flush();
                    } else {
                        String[] line0Type1 = new String[2];
                        int index = 0;
                        for (String s : clientMessage.split(":")) {
                            line0Type1[index] = s;
                            index++;
                        }
                        ArrayList<String> listNoti = new ArrayList<>();
                        for (String string : noti.split("\n")) {
                            listNoti.add(string);

                        }
                        if (line0Type1[1].equals("N")) {
                            // not accept
                            String contentLine = listNoti.get(Integer.valueOf(line0Type1[0]));
                            ArrayList<String> groupName = new ArrayList<>();
                            String contentToArray[] = new String[6];
                            int i = 0;
                            for (String s : contentLine.split(" ")) {
                                contentToArray[i] = s;
                                i++;
                            }
                            String nameUser = contentToArray[0];
                            String group = contentToArray[5];
                            File directNoti = new File(".\\data\\userdata\\Groups" + "\\" + group + "\\notification.txt");
                            removeLine(contentLine, directNoti);
                            outStream.writeUTF("DENY DONE");
                            outStream.flush();
                        } else if (line0Type1[1].equals("Y")) {
                            //accept
                            System.out.println("Run here");
                            String contentLine = listNoti.get(Integer.valueOf(line0Type1[0]));
                            ArrayList<String> groupName = new ArrayList<>();
                            String contentToArray[] = new String[6];
                            int i = 0;
                            for (String s : contentLine.split(" ")) {
                                contentToArray[i] = s;
                                i++;
                            }
                            String nameUser = contentToArray[0];
                            String group = contentToArray[5];
                            File directNoti = new File(".\\data\\userdata\\Groups" + "\\" + group + "\\notification.txt");
                            removeLine(contentLine, directNoti);
                            // add to member in info.txt
                            File directInfo = new File(".\\data\\userdata\\Groups" + "\\" + group + "\\info.txt");
                            BufferedReader reader = new BufferedReader(new FileReader(directInfo));
                            reader.readLine();
                            String currentMember = reader.readLine();
                            if (currentMember.equals("member:")) {
                                currentMember += nameUser;
                            } else {
                                currentMember += "," + nameUser;
                            }
                            replaceLine(1, currentMember, directInfo);
                            outStream.writeUTF("ACCEPT DONE");
                            outStream.flush();
                        }

                    }
                } //uploadFile
                else if (clientMessage.equals("-upload")) {
                    FileDialog dialog = new FileDialog(user);
                    String pathFile = dialog.choosePath;
                    String filePicked = dialog.chooseFileName;
                    if (pathFile.equals("")) {
                        outStream.writeUTF("Canceled");
                        outStream.flush();
                    } else {
                        File f = new File(".\\data\\userdata\\Groups");
                        String data = "";
                        for (File files : f.listFiles()) {
                            BufferedReader reader;
                            reader = new BufferedReader(new FileReader(new File(f.getPath() + "\\" + files.getName() + "\\info.txt")));
                            String line = reader.readLine();
                            String line2 = reader.readLine();
                            boolean isJoin = false;
                            String members = line2.substring(7);
                            for (String member : members.split(",")) {
                                if (member.equals(user)) {
                                    isJoin = true;
                                    break;
                                }
                            }
                            if (line.equals(user) || isJoin) {
                                data += files.getName() + "\n";
                            }
                            reader.close();
                        }
                        outStream.writeUTF("Picked: " + filePicked + "\nUpload to group? \n" + data + "-------------------");
                        outStream.flush();
                        String groupUploadInTo = inStream.readUTF();
                        //uploadFileHash
                        //-> getDataOfFileChoosen

                        File fileChoosen = new File(pathFile);
                        String temp = readData(pathFile);
                        Message s = new Message(temp, "G:\\DataDigitalSignatureProject\\" + user + "\\" + user + "'s_Private_Key.txt");
                        s.writeToFile("data\\userdata\\Groups\\" + groupUploadInTo + "\\(" + user + ")" + filePicked);
                        outStream.writeUTF("UPLOAD DONE");
                        outStream.flush();
                        //
                    }
                } else if (clientMessage.equals("-download")) {
                    FileDownLoadDialog dialog = new FileDownLoadDialog();
                    String pathFile = dialog.choosePath;
                    String filePicked = dialog.chooseFileName;
                    if (pathFile.equals("")) {
                        outStream.writeUTF("Canceled");
                        outStream.flush();
                    } else {
                        boolean isJoined = false;;
                        ArrayList<String> token = new ArrayList<>();
                        for (String s : pathFile.split("\\\\")) {
                            token.add(s);
                        }
                        String groupPicked = token.get(token.size() - 2);
                        String adminOfMemberOf = adminOf + ", " + memberOf;
                        for (String s : adminOfMemberOf.split(", ")) {
                            if (groupPicked.equals(s)) {
                                isJoined = true;
                                break;
                            }
                        }
                        if (isJoined && !filePicked.equals("notification.txt") && !filePicked.equals("info.txt")) {
                            //Encripted File, need hashedData, publicKey.
                            // => getHashedData
                            // => get PublicKey Owner 
                            String fileName = filePicked;
                            String[] Owner0name1 = fileName.split("\\)");
                            Owner0name1[0] = Owner0name1[0].substring(1);
                            String PublicKey = "data\\admindata\\keyStore\\publicKeys\\" + Owner0name1[0] + "'s_Public_Key.txt"; //***********
                            System.out.println("pathFile:" + pathFile);
                            System.out.println("publicKey:" + PublicKey);
                            VerifyMessage vrm = new VerifyMessage(pathFile, PublicKey);
                            if (vrm.isVerifyed) {
                                String dataEncripted = new String(vrm.list.get(0));
                                File f = new File("G:\\DataDigitalSignatureProject\\" + user + "\\" + filePicked);
                                FileWriter fr = new FileWriter(f, true);
                                System.out.println(dataEncripted);
                                fr.write(dataEncripted);
                                fr.flush();
                                fr.close();
                                outStream.writeUTF("Verified, downloaded");
                                outStream.flush();
                            } else {
                                outStream.writeUTF("Not Verified, can't download");
                                outStream.flush();
                            }

                        } else {
                            outStream.writeUTF("You have no permission to download this file");
                            outStream.flush();
                        }

                    }

                }//default
                else {
                    outStream.writeUTF(clientMessage + " is not recognized as an internal or external command");
                    outStream.flush();
                }
            }
            inStream.close();
            outStream.close();
            serverClient.close();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Client -" + clientNo + " exit!! ");
        }
    }
}
