package com.justforfun.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.justforfun.test.model.Promotion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An activity representing a list of Promotions. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link PromotionDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class PromotionListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */

    public static final ArrayList<Promotion> promotionsList = new ArrayList<>();

    public static final Map<Integer, Promotion> promotionsMap = new HashMap<Integer, Promotion>();

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        View recyclerView = findViewById(R.id.promotion_list);
        assert recyclerView != null;
        setupItems();
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.promotion_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupItems(){

        addPromotion(
                new Promotion(0,"Papa John's Pizza","Papa John's"
                    ,"20% en pizzas grandes y extra grandes",getResources().getString(R.string.lorem)
                    ,R.drawable.promo_papa_johns,R.drawable.logo_papa_johns)
        );

        addPromotion(
                new Promotion(1,"Papa John's Pizza","Papa John's"
                        ,"20% en pizzas grandes y extra grandes",getResources().getString(R.string.lorem)
                        ,R.drawable.promo_papa_johns,R.drawable.logo_papa_johns)
        );

        addPromotion(
                new Promotion(2,"Papa John's Pizza","Papa John's"
                        ,"20% en pizzas grandes y extra grandes",getResources().getString(R.string.lorem)
                        ,R.drawable.promo_papa_johns,R.drawable.logo_papa_johns)
        );

        addPromotion(
                new Promotion(3,"Papa John's Pizza","Papa John's"
                        ,"20% en pizzas grandes y extra grandes",getResources().getString(R.string.lorem)
                        ,R.drawable.promo_papa_johns,R.drawable.logo_papa_johns)
        );

        addPromotion(
                new Promotion(4,"Papa John's Pizza","Papa John's"
                        ,"20% en pizzas grandes y extra grandes",getResources().getString(R.string.lorem)
                        ,R.drawable.promo_papa_johns,R.drawable.logo_papa_johns)
        );

        addPromotion(
                new Promotion(5,"Papa John's Pizza","Papa John's"
                        ,"20% en pizzas grandes y extra grandes",getResources().getString(R.string.lorem)
                        ,R.drawable.promo_papa_johns,R.drawable.logo_papa_johns)
        );

        addPromotion(
                new Promotion(6,"Papa John's Pizza","Papa John's"
                        ,"20% en pizzas grandes y extra grandes",getResources().getString(R.string.lorem)
                        ,R.drawable.promo_papa_johns,R.drawable.logo_papa_johns)
        );

        addPromotion(
                new Promotion(7,"Papa John's Pizza","Papa John's"
                        ,"20% en pizzas grandes y extra grandes",getResources().getString(R.string.lorem)
                        ,R.drawable.promo_papa_johns,R.drawable.logo_papa_johns)
        );

        addPromotion(
                new Promotion(8,"Papa John's Pizza","Papa John's"
                        ,"20% en pizzas grandes y extra grandes",getResources().getString(R.string.lorem)
                        ,R.drawable.promo_papa_johns,R.drawable.logo_papa_johns)
        );

        addPromotion(
                new Promotion(9,"Papa John's Pizza","Papa John's"
                        ,"20% en pizzas grandes y extra grandes",getResources().getString(R.string.lorem)
                        ,R.drawable.promo_papa_johns,R.drawable.logo_papa_johns)
        );

    }

    private void addPromotion(Promotion promotion){
        promotionsList.add(promotion);
        promotionsMap.put(promotion.getId(),promotion);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(promotionsList));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Promotion> mValues;

        public SimpleItemRecyclerViewAdapter(List<Promotion> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.promotion_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);

            holder.mIdView.setText(mValues.get(position).getShortTitle());
            holder.mContentView.setText(mValues.get(position).getSubtitle());
            holder.mContentImageView.setImageResource(mValues.get(position).getImage());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putInt(PromotionDetailFragment.ARG_ITEM_ID, holder.mItem.getId());
                        PromotionDetailFragment fragment = new PromotionDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.promotion_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, PromotionDetailActivity.class);
                        intent.putExtra(PromotionDetailFragment.ARG_ITEM_ID, holder.mItem.getId());

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public final ImageView mContentImageView;
            public Promotion mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.text_view_title);
                mContentView = (TextView) view.findViewById(R.id.text_view_subtitle);
                mContentImageView = (ImageView) view.findViewById(R.id.image_view_content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
