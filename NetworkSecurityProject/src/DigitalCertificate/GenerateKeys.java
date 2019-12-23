/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalCertificate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.tools.keytool.CertAndKeyGen;
import sun.security.x509.X500Name;

public class GenerateKeys {

    CertAndKeyGen keyGen;
    private KeyPair pair;
    private PrivateKey privateKey;
    private PublicKey publicKey;
    X509Certificate[] chain;

    public GenerateKeys(int keylength) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, IOException, IOException, CertificateException, SignatureException, SignatureException {
        keyGen = new CertAndKeyGen("RSA", "SHA1WithRSA", null);
        this.keyGen.generate(keylength);
        this.privateKey = keyGen.getPrivateKey();
        this.publicKey = keyGen.getPublicKey();
        chain = new X509Certificate[1];
        chain[0] = keyGen.getSelfCertificate(new X500Name("CN=ROOT"), (long) 365 * 24 * 3600);

    }

    public void createKeys() {

    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public X509Certificate getCert() {
        return chain[0];
    }

    public void writeToFile(File f, byte[] key) throws IOException {

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();

    }
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, IOException, InvalidKeyException, CertificateException, SignatureException {
        GenerateKeys myKeys = new GenerateKeys(1024);
        myKeys.createKeys();
        File f = new File("publicKey2.txt");
        File f2 = new File("privateKey2.txt");
        myKeys.writeToFile(f, myKeys.getPublicKey().getEncoded());
        myKeys.writeToFile(f2, myKeys.getPrivateKey().getEncoded());
       
    }
}
