package com.jachdev.mvvm.ui.detail;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jachdev.mvvm.R;
import com.jachdev.mvvm.base.BaseFragment;
import com.jachdev.mvvm.util.ViewModelFactory;

import javax.inject.Inject;

public class DetailsFragment extends BaseFragment {

    @BindView(R.id.tv_repo_name)
    TextView repoNameTextView;
    @BindView(R.id.tv_repo_description)
    TextView repoDescriptionTextView;
    @BindView(R.id.tv_forks)
    TextView forksTextView;
    @BindView(R.id.tv_stars)
    TextView starsTextView;

    @Inject
    ViewModelFactory viewModelFactory;
    private DetailsViewModel detailsViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.details_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        detailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(DetailsViewModel.class);
        detailsViewModel.restoreFromBundle(savedInstanceState);
        displayRepo();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        detailsViewModel.saveToBundle(outState);
    }

    private void displayRepo() {
        detailsViewModel.getSelectedRepo().observe(this, repo -> {
            if (repo != null) {
                repoNameTextView.setText(repo.name);
                repoDescriptionTextView.setText(repo.description);
                forksTextView.setText(String.valueOf(repo.forks));
                starsTextView.setText(String.valueOf(repo.stars));
            }
        });
    }
}
