package com.jachdev.mvvm.di.module;

import com.jachdev.mvvm.di.util.ViewModelKey;
import com.jachdev.mvvm.ui.list.ListViewModel;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Singleton
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel.class)
    abstract ViewModel bindListViewModel(ListViewModel listViewModel);
}
