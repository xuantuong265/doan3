package com.example.test1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DanhSachAdapter danhSachAdapter;
    public static ArrayList<BaiDauXe> arrayList = new ArrayList<>();
    private DatabaseReference mData, mChitiet;
    private ArrayList<ChiTiet> chiTietArrayList = new ArrayList<>();
    private String soLuong, key, diaChi, gio, hinhAnh, soDienThoai, tenBaiDauXe;
    private BaiDauXe baiDauXe;
    private ChiTiet chiTiet;
    private int conlai = 0;
    public static int dem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // anhs xas
        anhXa();
        readData();

    }

    private void anhXa() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        mData = FirebaseDatabase.getInstance().getReference().child("DanhSach");
        mChitiet = FirebaseDatabase.getInstance().getReference().child("ChiTiet");
    }

    private void readData () {
        mData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    key = snapshot.getKey();
                    diaChi = snapshot.child("diaChi").getValue(String.class);
                    gio = snapshot.child("gio").getValue(String.class);
                    hinhAnh = snapshot.child("hinhAnh").getValue(String.class);
                    soDienThoai = snapshot.child("soDienThoai").getValue(String.class);
                    soLuong = snapshot.child("soLuong").getValue(String.class);
                    tenBaiDauXe = snapshot.child("tenBaiDoXe").getValue(String.class);

                    baiDauXe = new BaiDauXe(key, diaChi, gio, hinhAnh, soDienThoai, soLuong,
                            tenBaiDauXe);
                    arrayList.add(baiDauXe);
                }

                // lấy cái chi tiết
                mChitiet.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String keyBaiDauXe = snapshot.child("keyBaiDauXe").getValue(String.class);
                            String trangThai = snapshot.child("trangThai").getValue(String.class);
                            chiTiet = new ChiTiet(keyBaiDauXe, trangThai);
                            chiTietArrayList.add(chiTiet);
                        }

                        // duyệt cả 2 cái mảng

                        for (int i = 0; i < arrayList.size(); i++) {
                            String key = arrayList.get(i).getKey();
                            int dem = 0;
                            boolean isCheck = false;
                            for (int j = 0; j < chiTietArrayList.size(); j++) {
                                if (chiTietArrayList.get(j).getKeyBaiDauXe().equals(key)) {
                                    if (chiTietArrayList.get(j).getTrangThai().equals("Còn")) {
                                        dem++;
                                        arrayList.get(i).setConlai(String.valueOf(dem));
                                    }
                                }
                            }
                            if (dem == 0) {
                                arrayList.get(i).setConlai(String.valueOf(dem));
                            }
                        }

                        danhSachAdapter = new DanhSachAdapter(getApplicationContext(), arrayList);
                        recyclerView.setAdapter(danhSachAdapter);
                        danhSachAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                // end


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }



}
