package com.rhyme.r_scan.RScanView;

import android.app.Activity;

import com.rhyme.r_scan.RScanCamera.RScanPermissions;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.view.TextureRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;

public class RScanViewPlugin {

    public static void registerWith(PlatformViewRegistry platformViewRegistry,
                                    Activity activity,
                                    BinaryMessenger messenger,
                                    TextureRegistry textureRegistry) {

        RScanPermissions permissions = new RScanPermissions();

        platformViewRegistry.registerViewFactory(
                "com.rhyme_lph/r_scan_view",
                new RScanViewFactory(activity, messenger, permissions, textureRegistry)
        );
    }
}
