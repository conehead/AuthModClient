package net.minecraft.src;

public class PluginChannelUtils {
    
    public static Packet250CustomPayload getRegisterPacket(String channel) {
        return getMessagePacket("REGISTER", channel);
    }
    
    public static Packet250CustomPayload getMessagePacket(String channel, String message) {
        byte[] payload = new byte[message.length()];
        for (int i = 0; i < message.length(); i++) {
            payload[i] = (byte)message.charAt(i);
        }
        return new Packet250CustomPayload(channel, payload);
    }
    
    public static Packet250CustomPayload getMessagePacket(String channel, byte[] message) {
        return new Packet250CustomPayload(channel, message);
    }
}
