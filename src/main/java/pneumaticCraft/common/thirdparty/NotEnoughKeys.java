package pneumaticCraft.common.thirdparty;

import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import modwarriors.notenoughkeys.api.Api;
import modwarriors.notenoughkeys.api.KeyBindingPressedEvent;
import pneumaticCraft.client.KeyHandler;
import pneumaticCraft.lib.Names;

public class NotEnoughKeys implements IThirdParty {

    @Override
    public void preInit() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKey(KeyBindingPressedEvent event) {
        if (event.isKeyBindingPressed) KeyHandler.getInstance()
            .onKey(event.keyBinding);
    }

    @Override
    public void init() {

    }

    @Override
    public void postInit() {}

    @Override
    public void clientSide() {}

    @Override
    public void clientInit() {
        Api.registerMod(
            Names.MOD_ID,
            new String[] { KeyHandler.getInstance().keybindHack.getKeyDescription(),
                KeyHandler.getInstance().keybindDebuggingDrone.getKeyDescription(),
                KeyHandler.getInstance().keybindOpenOptions.getKeyDescription() });
    }

}
