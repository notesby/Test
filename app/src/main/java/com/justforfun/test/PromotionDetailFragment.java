package com.justforfun.test;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.justforfun.test.dummy.DummyContent;
import com.justforfun.test.model.Promotion;

/**
 * A fragment representing a single Promotion detail screen.
 * This fragment is either contained in a {@link PromotionListActivity}
 * in two-pane mode (on tablets) or a {@link PromotionDetailActivity}
 * on handsets.
 */
public class PromotionDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Promotion mItem;

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            share();
        }
    };

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PromotionDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = PromotionListActivity.promotionsMap.get(getArguments().getInt(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getTitle());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.promotion_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.text_view_detail)).setText(mItem.getDescription());
            ((TextView) rootView.findViewById(R.id.text_view_title)).setText(mItem.getTitle());
            ((TextView) rootView.findViewById(R.id.text_view_subtitle)).setText(mItem.getSubtitle());
            ((ImageView) rootView.findViewById(R.id.image_view_logo)).setImageResource(mItem.getLogo());
            ((FloatingActionButton) rootView.findViewById(R.id.menu_fb_share)).setOnClickListener(listener);
            ((FloatingActionButton) rootView.findViewById(R.id.menu_email_share)).setOnClickListener(listener);
            ((FloatingActionButton) rootView.findViewById(R.id.menu_twitter_share)).setOnClickListener(listener);
        }

        return rootView;
    }

    private void share(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, mItem.getDescription());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
