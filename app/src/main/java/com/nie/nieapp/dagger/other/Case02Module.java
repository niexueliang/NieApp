package com.nie.nieapp.dagger.other;

import android.graphics.Color;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author JY
 * @Time 2017/12/12 17:33
 */

@Module
public class Case02Module {

//    @Provides
//    @Named("green")
//    ColorPicker provideColorGreen() {
//        return new ColorPicker(Color.GREEN);
//    }

    @Provides
    @Named("blue")
    ColorPicker provideColorBlue() {
        return new ColorPicker(Color.BLUE);
    }

}
