package com.example.test1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DanhSachAdapter extends RecyclerView.Adapter<DanhSachAdapter.ViewHolder> {

    private Context context;
    private ArrayList<BaiDauXe> mData;

    public DanhSachAdapter(Context context, ArrayList<BaiDauXe> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvSoluong.setText("Sức chứa " + mData.get(position).getSoLuong());
        holder.tvOtrong.setText("Số ô còn lại " + mData.get(position).getConlai());
        holder.tvTen.setText(mData.get(position).getDiaChi());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTen, tvSoluong, tvOtrong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTen = (TextView) itemView.findViewById(R.id.ten);
            tvOtrong = (TextView) itemView.findViewById(R.id.o_trong);
            tvSoluong = (TextView) itemView.findViewById(R.id.soluong);
        }
    }
}
