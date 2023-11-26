package io.github.blobanium.mcbrowser.mixin;

import io.github.blobanium.mcbrowser.MCBrowser;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(at = @At(value = "HEAD"), method = "close")
    private void onClose(CallbackInfo ci) {
        if (MCBrowser.getConfig().saveTabs) {
            MCBrowser.saveTabsToJson();
        }
        MCBrowser.reset();
    }
}
