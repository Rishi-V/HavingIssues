package com.example.aiflab.testfixit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by aiflab on 10/7/17.
 */

public class IssueFragment extends Fragment {
    public static final String EXTRA_ISSUE_ID = "com.example.aiflab.testfixit.issue_id";

    private Issue mIssue;
    private TextView mTitle;
    private ImageView mImage;
    private TextView mDescription;


    public IssueFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID issueId = (UUID)getArguments().getSerializable(EXTRA_ISSUE_ID);
        mIssue = IssueList.get(getActivity()).getIssue(issueId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.issue_view, container, false);

        //Title
        mTitle = (TextView)v.findViewById(R.id.titleTextView);
        mTitle.setText(mIssue.getName());

        //Image
        mImage = (ImageView)v.findViewById(R.id.imageView);

        //Description
        mDescription = (TextView)v.findViewById(R.id.descriptionTextView);
        mDescription.setText(mIssue.getDescription());

        return v;
    }

    public static IssueFragment newInstance(UUID issueId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_ISSUE_ID, issueId);

        IssueFragment fragment = new IssueFragment();
        fragment.setArguments(args);

        return fragment;
    }
}
