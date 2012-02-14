package net.minecraft.src;

import java.io.*;

public class Packet250CustomPayload extends Packet
{
    public String channel;
    public int length;
    public byte message[];

    public Packet250CustomPayload()
    {
    }
    
    public Packet250CustomPayload(String channel, byte[] message) {
        this.channel = channel;
        this.length = message.length;
        this.message = message;
    }

    public void readPacketData(DataInputStream datainputstream)
    throws IOException
    {
        channel = readString(datainputstream, 16);
        length = datainputstream.readShort();
        if (length > 0 && length < 32767)
        {
            message = new byte[length];
            datainputstream.read(message);
        }
    }

    public void writePacketData(DataOutputStream dataoutputstream)
    throws IOException
    {
        writeString(channel, dataoutputstream);
        dataoutputstream.writeShort((short) length);
        if (message != null)
        {
            dataoutputstream.write(message);
        }
    }

    public void processPacket(NetHandler nethandler)
    {
        nethandler.func_44028_a(this);
    }

    public int getPacketSize()
    {
        return 2 + channel.length() * 2 + 2 + length;
    }
}
