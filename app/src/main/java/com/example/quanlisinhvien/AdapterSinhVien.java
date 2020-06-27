package com.example.quanlisinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdapterSinhVien extends ArrayAdapter<SINHVIEN> {
    Context context;
    int layout;
    ArrayList<SINHVIEN> arrayList;

    // Hàm tạo
    public AdapterSinhVien(@NonNull Context context, int layout, @NonNull ArrayList<SINHVIEN> arrayList) {
        super(context, layout, arrayList);
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;

    }

    //Xây dụng class ViewHolder
    public class ViewHolder {
        TextView txvMssv, txvHoten, txvGt, txvCn;
    }


    // Hàm getView (có sẵn)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false); // Mặc định là vậy
            viewHolder = new ViewHolder();
            // chỗ sẽ thay đổi
            viewHolder.txvMssv = convertView.findViewById(R.id.txvmssv);
            viewHolder.txvHoten = convertView.findViewById(R.id.txvhotensv);
            viewHolder.txvGt = convertView.findViewById(R.id.txvgt);
            viewHolder.txvCn = convertView.findViewById(R.id.txvcn);
            // chỗ sẽ thay đổi
            convertView.setTag(viewHolder);
        } else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.txvMssv.setText("MSSV: "+arrayList.get(position).mssv);
        viewHolder.txvHoten.setText("Họ Tên: "+arrayList.get(position).hoten);
        viewHolder.txvGt.setText("Giới Tính: "+arrayList.get(position).gt);
        viewHolder.txvCn.setText("Chuyên Ngành: "+arrayList.get(position).cn);
        return convertView;
        //   return super.getView(position, convertView, parent);
    }
}
