
/*
 * Because it's a one-line modification, I only posted partial source code
 * Also: I don't think I'm allowed to post the entire source.
 */

public class NetClientHandler extends NetHandler {
    
    /* ... other contents here ... */

    public void handleLogin(Packet1Login packet1login)
    {
        //This goes all the way at the end
        AuthModUtils.sendAuthMessage(netManager);
    }
    
    /* ... other contents here ... */

}
