package com.geek.listcontacts.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.listcontacts.R;
import com.geek.listcontacts.model.ContactModel;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private final List<ContactModel> list;
    IListener listener;
    public MainAdapter(List<ContactModel> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
       holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ContactModel model;
        private final TextView tvName;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvName = itemView.findViewById(R.id.tv_name);
        }
        public void onBind(ContactModel contactModel) {
            this.model = contactModel;
            tvName.setText(model.getName());
        }
        @Override
        public void onClick(View v) {
            if(listener!=null){
                listener.onItemClick(model.getNumber());
            }
        }
    }
    public void setOnClickListener(IListener mListener){ this.listener = mListener;}
    public interface IListener{
        void onItemClick(String number);
    }
}
