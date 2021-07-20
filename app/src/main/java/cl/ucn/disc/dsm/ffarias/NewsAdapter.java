/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import org.ocpsoft.prettytime.PrettyTime;
import org.threeten.bp.DateTimeUtils;

import java.time.ZonedDateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.ucn.disc.dsm.ffarias.databinding.RowNewsBinding;
import cl.ucn.disc.dsm.ffarias.model.News;

/**
 * The Adapter of News.
 * @author Felipe Farías Espinoza
 */
public final class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    /**
     * The Pretty time
     */
    private static final PrettyTime PRETTY_TIME = new PrettyTime();

    /**
     * The DataSoruce
     */
    private List<News> theNews = new ArrayList<>();

    /**
     * The Constructor
     */
    public NewsAdapter(){
        // Nothing here.
    }

    /**
     * Update the datasource.
     * @param news to use as data source.
     */
    public void setNews(final List<News> news ){
        this.theNews = news;

        // Notify the RecyclerView.
        this.notifyDataSetChanged();

    }

    /**
     * Called when the RecyclerView need a fresh row of NewsViewHolder.
     *
     * @param parent The ViewGroup where the new will be added.
     * @param viewType The view of this type.
     * @return the NewsViewHolder ready for action.
     */
    @Override
    public NewsViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        // Called the constructor inflating the layout.
        return new NewsViewHolder(
                RowNewsBinding.inflate(
                LayoutInflater.from(parent.getContext())
                )
        );
    }

    /**
     * Called by the RecyclerView when need to display some data at specific position.
     * @param holder to use to set the GUI data.
     * @param position of the dataset to show.
     */
    @Override
    public void onBindViewHolder(final NewsAdapter.NewsViewHolder holder, int position) {
        // bind the viewHolder + news at certain position
        holder.bind(this.theNews.get(position));

    }

    /**
     *
     * @return the size of the dataset.
     */
    @Override
    public int getItemCount() {
        return this.theNews.size();
    }

    /**
     * The ViewHolder implementation of {@link cl.ucn.disc.dsm.ffarias.model.News}
     */
    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        /**
         * The GUI of News
         */
        private final RowNewsBinding rowNewsBinding;

        /**
         *
         * @param rowNewsBinding the layout to use.
         */
        public NewsViewHolder(final RowNewsBinding rowNewsBinding) {
            super(rowNewsBinding.getRoot());
            this.rowNewsBinding = rowNewsBinding;
        }

        /**
         *
         * @param news to use.
         */
        public void bind(final News news){

            //bind the tittle
            this.rowNewsBinding.rnTvTitle.setText(news.getTittle());

            // bind the author
            this.rowNewsBinding.rnTvAuthor.setText(news.getAuthor());

            // Bind the source
            this.rowNewsBinding.rnTvSource.setText(news.getSource());

            // Bind the description
            this.rowNewsBinding.rnTvDescription.setText(news.getDescription());

            // ZonedDateTime to Date
            final Date theDate = DateTimeUtils.toDate(news.getPublishedAt().toInstant());

            // Bind the Date
            this.rowNewsBinding.rnTvPublishedAt.setText( PRETTY_TIME.format(theDate) );

            // Bind the Image
            if (news.getUrlImage() != null){
                // URL to URI
                final Uri uri = Uri.parse(news.getUrlImage());
                this.rowNewsBinding.rnSdvImage.setImageURI(uri);

            }else{
                // No image, use the default

                this.rowNewsBinding.rnSdvImage.setImageResource(R.drawable.ic_launcher_foreground);
            }

        }
    }
}
