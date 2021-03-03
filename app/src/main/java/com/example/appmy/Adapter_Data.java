package com.example.appmy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Data extends RecyclerView.Adapter<Adapter_Data.ViewHoler> {
    Context context;
    int resuorce;
    ArrayList<DanhSach> danhSachArrayList;
    public Adapter_Data(Context context,int resuorce,ArrayList<DanhSach> danhSachArrayList){
        this.context = context;
        this.resuorce = resuorce;
        this.danhSachArrayList = danhSachArrayList;
    }
    public class ViewHoler extends RecyclerView.ViewHolder {
        TextView txttieude,txtngay,txtnoidung;
        LinearLayout layout;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);

            txttieude=itemView.findViewById(R.id.txttieude);
            txtngay=itemView.findViewById(R.id.txtngay);
            txtnoidung=itemView.findViewById(R.id.txtnoidung);
            layout=itemView.findViewById(R.id.layout);
        }
    }

    @NonNull
    @Override
    public Adapter_Data.ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resuorce,parent,false);
        ViewHoler viewHolder=new ViewHoler(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHoler holder, int position) {
        DanhSach ds = danhSachArrayList.get(position);
        holder.txttieude.setText(ds.getTieude());
        holder.txtngay.setText(ds.getNgay());
        holder.txtnoidung.setText(ds.getNoidung());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("tieude", holder.txttieude.getText());
                intent.putExtra("noidung", holder.txtnoidung.getText());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return danhSachArrayList.size(); // trả về giá trị tất cả các danh sách.
    }
}
