package com.rhyme.r_scan;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import com.rhyme.r_scan.RScanCamera.RScanPermissions;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.view.TextureRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;

/**
 * RScanPlugin using V2 embedding
 */
public class RScanPlugin implements FlutterPlugin, ActivityAware {
    private Activity activity;
    private FlutterPluginBinding pluginBinding;

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        this.pluginBinding = binding;
        // Optional: register platform view or set up method channels
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        this.pluginBinding = null;
    }

    @Override
    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
        this.activity = binding.getActivity();

        BinaryMessenger messenger = pluginBinding.getBinaryMessenger();
        TextureRegistry textureRegistry = pluginBinding.getTextureRegistry();
        PlatformViewRegistry viewRegistry = pluginBinding.getPlatformViewRegistry();
        Context context = pluginBinding.getApplicationContext();

        RScanPermissions permissions = new RScanPermissions();

        RScanViewFactory factory = new RScanViewFactory(
                activity,
                messenger,
                permissions,
                textureRegistry,
                viewRegistry
        );

        pluginBinding.getPlatformViewRegistry().registerViewFactory("r_scan_view", factory);
    }

    @Override
    public void onDetachedFromActivityForConfigChanges() {
        this.activity = null;
    }

    @Override
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
        onAttachedToActivity(binding);
    }

    @Override
    public void onDetachedFromActivity() {
        this.activity = null;
    }
}
