package com.example.gabrielmoro.xyz_reader.ui.base;

import android.view.View;

/**
 * Define the general contract between the ViewModel objects
 * @param <T>
 */
public interface AdapterViewModels<T> {

    void setup(T item);

    void click(View view);
}