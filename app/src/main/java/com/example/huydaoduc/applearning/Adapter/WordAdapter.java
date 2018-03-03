package com.example.huydaoduc.applearning.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.huydaoduc.applearning.Model.Word;
import com.example.huydaoduc.applearning.R;

import java.util.List;

/**
 * Created by HuyDaoDuc on 03/03/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private Context context;
    private int layout;
    private List<Word> wordList;

    // SparseBooleanArray : mapping Integer values to booleans  -->  more memory efficient
    private SparseBooleanArray mSelectedItemsIds;

    public WordAdapter(@NonNull Context context, int resourceId, @NonNull List<Word> WordList) {
        super(context, resourceId, WordList);
        mSelectedItemsIds = new SparseBooleanArray();
        this.context = context;
        this.layout = resourceId;
        this.wordList = WordList;

        // Filter
    }

    @Override
    public int getCount() {
        return wordList.size();
    }

    @Override
    public Word getItem(int i) {
        return wordList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        TextView txtTen = (TextView) view.findViewById(R.id.txtTen);
        TextView txtTheLoai = (TextView) view.findViewById(R.id.txtTheLoai);
        TextView txtMota = (TextView) view.findViewById(R.id.txtMota);

        Word word = wordList.get(i);
        if(word !=null){
            txtTen.setText(word.getTen());
            txtMota.setText(word.getMota());

            if(word.getTheLoai() != null)
            {
                txtTheLoai.setText(word.getTheLoai());
            }
            else
            {
                txtTheLoai.setVisibility(View.GONE);
            }
        }

        //animation
//        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list);
//        view.startAnimation(animation);

        return view;
    }
}
