package com.example.appmy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtHienThi,txtHienthiNoidung;
    ArrayList<DanhSach> dsNote; // Gọi dữ liệu từ Danh Sách.
    Adapter_Data adapter_data; // Gọi adapter.
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHienThi = findViewById(R.id.txthienThi);
        txtHienthiNoidung = findViewById(R.id.txthienThinoiDung);
        recyclerView = findViewById(R.id.recyclerViewNote);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(MainActivity.this);

        dsNote = new ArrayList<>();
        dsNote.add(new DanhSach("Nhật ký 2020.","25/12/2020","Ngày Lễ Noell - Mừng Chúa Giáng Sinh."));
        dsNote.add(new DanhSach("Nhật ký 2020-2021.","01/01/2021","Happy New Year 2021."));
        dsNote.add(new DanhSach("Nhật ký.","08/03/2020","Ngày 8/3, ngày phụ nữ quốc tế."));
        dsNote.add(new DanhSach("Nhật ký.","20/11/2020","Ngày Nhà giáo Việt nam 20/11."));
        dsNote.add(new DanhSach("Nhật ký Của tôi.","25/12/2020","Ngày Lễ Noell."));
        dsNote.add(new DanhSach("Mừng Sinh Nhật","06/06/2020","Ngày sinh nhật tròn 23 tuổi của tôi..."));
        dsNote.add(new DanhSach("Ký Sự Năm Học.","25/12/2020","Hôm nay thi học kỳ 1 của môn Androis..."));
        dsNote.add(new DanhSach("Tìm lại tôi.","25/12/2020","Đêm giao thừa của năm 2020-2021 sắp đến rồi..."));
        dsNote.add(new DanhSach("Nhật ký","25/12/2020","Kính chúc mọi người năm mới tràn đầy may mắn, bình an hạnh phúc trong tình yêu thương."));
        dsNote.add(new DanhSach("Tình Yêu.","25/12/2020","Kính chúc mọi người năm mới tràn đầy may mắn, bình an hạnh phúc trong tình yêu thương."));
        dsNote.add(new DanhSach("Trong Tôi - Nhật ký","25/12/2020","Kính chúc mọi người năm mới tràn đầy may mắn, bình an hạnh phúc trong tình yêu thương."));

        Intent integer = getIntent();
        String tieude = integer.getStringExtra("tieude");
        String noidung = integer.getStringExtra("noidung");

        txtHienThi.setText(tieude);
        txtHienthiNoidung.setText(noidung);
        recyclerView.setLayoutManager(layoutManager);
        adapter_data = new Adapter_Data(MainActivity.this,R.layout.layout_danhsach_note,dsNote);
        recyclerView.setAdapter(adapter_data);
        adapter_data.notifyDataSetChanged();
    }
}