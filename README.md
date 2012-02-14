AuthModClient
=============

This is the corresponding client mod for use with the [AuthMod Bukkit plugin](https://github.com/conehead/AuthMod). In conjunction with the Bukkit plugin, this allows users (particularly staff members) to authenticate themselves with an RSA certificate.


Setting up AuthModClient
------------------------

Install it as you would any other mod. It modifies NetClientHandler and Packet250CustomPayload, and adds two other classes.

Acquire an AuthMod key from your server owner, and put it directly in your .minecraft folder as "authmod.key".

Usage
-----

You should be able to connect to the server as usual. If you want to connect from a different computer, you'll have to install AuthMod on that one as well, and copy your authmod.key as well.