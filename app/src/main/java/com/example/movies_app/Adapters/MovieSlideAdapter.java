package com.example.movies_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.movies_app.R;

public class MovieSlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public MovieSlideAdapter(Context context) {
        this.context = context;
    }

    //array
    public int[] slide_image =
            {
                    R.drawable.z4,
                    R.drawable.z2,
                    R.drawable.z3,
            };
    public String[] slide_headings = {
            "UpCaming",
            "Romatic",
            "TopRate",
    };
    public String[] slide_deatils =
            {
                    "This is a list of American films that are scheduled to be released in 2020. Some films have announced release dates but have yet to begin filming, while others are in production but do not yet have definite release dates:" +
                            " Romantic films serve as great escapes and fantasies for viewers, especially if the two people finally overcome their difficulties, declare their love, and experience life \"happily ever after\", implied by a reunion and final kiss. In romantic television series, the development of such romantic relationships may play out over many episodes, and different characters may become intertwined in different romantic arcs.",
                    "The 10 Best Movies of 2019 Top Rated English Movies Of2019\n" + "Hollywood produces hundreds of films annually and if you are finding it difficult to choose from the lot, here we give you an insight into the best-rated films of the year from all the films that have released along with the film’s reviews and ratings. The section also covers reviews, trailer, cast information, box-office collections, related videos and pictures of every film that has been listed. "
                    , "hi golblhnkhnlhnlnljnljljmlljlj;;;;;jlllllll"
            };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        ViewGroup view = (ViewGroup) layoutInflater.inflate(R.layout.slide_layout, container, false);
        container.addView(view);


        ImageView slideImageView = (ImageView) view.findViewById(R.id.imageViewSlide);
        TextView SlideHeading = (TextView) view.findViewById(R.id.txt_slide_heading);
        TextView SlideDetails = (TextView) view.findViewById(R.id.txt_slide_detail);

        slideImageView.setImageResource(slide_image[position]);
        SlideHeading.setText(slide_headings[position]);
        SlideDetails.setText(slide_deatils[position]);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
