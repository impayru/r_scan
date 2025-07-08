package com.rhyme.r_scan.RScanView;

import android.app.Activity;
import android.content.Context;

import com.rhyme.r_scan.RScanCamera.RScanPermissions;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import io.flutter.view.TextureRegistry;

public class RScanViewFactory extends PlatformViewFactory {
    private final Activity activity;
    private final BinaryMessenger messenger;
    private final RScanPermissions permissions;
    private final TextureRegistry textureRegistry;

    public RScanViewFactory(Activity activity,
                            BinaryMessenger messenger,
                            RScanPermissions permissions,
                            TextureRegistry textureRegistry) {
        super(StandardMessageCodec.INSTANCE);
        this.activity = activity;
        this.messenger = messenger;
        this.permissions = permissions;
        this.textureRegistry = textureRegistry;
    }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        return new FlutterRScanView(activity, messenger, permissions, textureRegistry, viewId, args);
    }
}
