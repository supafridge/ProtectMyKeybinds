# ProtectMyKeybinds
This mod prevents any non-vanilla keybinds from being resolved in text components. This partially patches [this issue](https://wurst.wiki/sign_translation_vulnerability) and when used with [ExploitPreventer](https://modrinth.com/mod/exploitpreventer) will allow you to use all the mods you want on all the servers you want.

Please note that mods that create plugin channels (like Flashback) can still be detected by the server, but who would ever go through the trouble just to do that?

## The technical details
Malicious or ill-intented servers can force the client to open a sign with components. These components include `translation` and `keybind` components. Now, any other trustworthy server would simply use these to maybe give the player guidance using their own keybinds, but a bad server could use these to identify the mods a player has installed.

Take for example Flashback. This mod is a gameplay recording and replay mod, very similar to...Replay Mod. Flashback creates a keybind called "Create Marker 1", which is used in Flashback's replay viewer to quickly create a marker at the time in the replay the user is at.

With that in mind, the server will tell the client to open a sign. This sign will have one or more `keybind` components. Inside the keybind component(s), the server could ask the client to resolve the keybind `key.flashback.create_marker_1`. If a player joins said server with Flashback and this happens to them, their client will resolve the keybind and then send the result back to the server. From there, the server can take any action they want against the player, like kicking or banning them.

ProtectMyKeybinds will block the resolution of all modded keybinds, while leaving the resolution of regular vanilla keybinds untouched, essentially acting like a vanilla Minecraft client. So joining a server with Flashback that abuses this vulnerability will have the keybind simply resolve to `key.flashback.create_marker_1`, and not whatever the keybind was bound to.

## What servers exploit this?
[I honestly think no server would or could ever exploit this. Minecraft is just such a perfect game with perfect people and perfect code that no one would ever think to abuse this vulnerability. I would be absolutely appalled, dumbfounded, and bewildered if I ever saw a server use this.](https://github.com/NikOverflow/ExploitPreventer/blob/master/HALL_OF_SHAME.md)