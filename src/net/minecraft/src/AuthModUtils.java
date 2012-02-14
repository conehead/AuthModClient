package net.minecraft.src;

import net.minecraft.client.Minecraft;

import javax.crypto.Cipher;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

public class AuthModUtils {
    private static File pubKeyFile = new File(Minecraft.getMinecraftDir(), "authmod.key");
    private static byte[] key = new byte[]{3,3,7,7,6};
    
    public static void sendAuthMessage(NetworkManager manager) {
        manager.addToSendQueue(PluginChannelUtils.getRegisterPacket("auth"));
        manager.addToSendQueue(PluginChannelUtils.getMessagePacket("auth", encryptedMessage()));
    }
    
    private static byte[] encryptedMessage() {
        
        try {
            PublicKey pubKey = loadKey();
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            return cipher.doFinal(key);
        } catch (Exception e) {
            return key;
        }
    }

    private static PublicKey loadKey() throws Exception {
        ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(pubKeyFile)));
        try {
            BigInteger m = (BigInteger) oin.readObject();
            BigInteger e = (BigInteger) oin.readObject();
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
            KeyFactory fact = KeyFactory.getInstance("RSA");
            return fact.generatePublic(keySpec);
        } catch (Exception e) {
            throw new RuntimeException("Spurious serialisation error", e);
        } finally {
            oin.close();
        }
    } 
}
