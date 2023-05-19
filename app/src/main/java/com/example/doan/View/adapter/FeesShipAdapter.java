package com.example.doan.View.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doan.R;

import java.util.ArrayList;
import java.util.List;

public class FeesShipAdapter extends ArrayAdapter<String> implements Filterable {
    private List<String> mOriginalList;
    private List<String> mFilteredList;
    private CustomFilter mFilter;

    public FeesShipAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        mOriginalList = new ArrayList<>(objects);
        mFilteredList = new ArrayList<>(objects);
        mFilter = new CustomFilter();
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            List<String> filteredList = new ArrayList<>();
            if (constraint != null && constraint.length() > 0) {
                for (String item : mOriginalList) {
                    if (item.toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filteredList.add(item);
                    }
                }
            }
            filterResults.count = filteredList.size();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mFilteredList.clear();
            if (results != null && results.count > 0) {
                mFilteredList.addAll((List<String>) results.values);
            }
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return mFilteredList.size();
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return mFilteredList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_autocomplete, parent, false);
        }
        TextView tvItem = convertView.findViewById(R.id.tv_item);
        String item = mFilteredList.get(position);
        tvItem.setText(item);
        return convertView;
    }
}
