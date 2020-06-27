package com.example.quanlisinhvien;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText edtMssv, edtHoten;
    RadioButton radNam, radNu;
    Button btnThem, btnSua, btnXoa, btnThoat;
    AdapterSinhVien adapterSinhVien;
    ArrayList<SINHVIEN> arrSV;
    ArrayAdapter<String> adapterSp; // cho spinner
    ArrayList arrChuyenNganh;// cho spinner
    Spinner spinner;
    int vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        arrSV = new ArrayList<>();
        // Tạo ra từng sinh viên
        SINHVIEN s1 = new SINHVIEN("17104018", "Võ Phước Lợi", "Nam", "CNTT");
        SINHVIEN s2 = new SINHVIEN("17104019", "Võ Phước Lợi", "Nữ", "Web");
        SINHVIEN s3 = new SINHVIEN("17104010", "Võ Phước Lợi", "Nam", "Lập trình");
        SINHVIEN s4 = new SINHVIEN("17104012", "Võ Phước Lợi", "Nữ", "Đồ họa");
        SINHVIEN s5 = new SINHVIEN("17104013", "Võ Phước Lợi", "Nam", "CNTT");
        // Tạo ra từng sinh viên

        //Thêm SV vào danh sách arrSV
        arrSV.add(s1);
        arrSV.add(s2);
        arrSV.add(s3);
        arrSV.add(s4);
        arrSV.add(s5);
        //Khởi tạo AdapterSinhVien
        adapterSinhVien = new AdapterSinhVien(this, R.layout.item_sinhvien, arrSV);
        listView.setAdapter(adapterSinhVien);

        //Su dung Spinner
        arrChuyenNganh = new ArrayList();
        arrChuyenNganh.add("None");
        arrChuyenNganh.add("CNTT");
        arrChuyenNganh.add("Đồ họa");
        arrChuyenNganh.add("Web");
        arrChuyenNganh.add("Quản trị Mạng");
        arrChuyenNganh.add("Lập trình");

        adapterSp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrChuyenNganh);
        adapterSp.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapterSp);
        //Su dung Spinner

        OnClick();

    }

    private void anhxa() {
        listView = findViewById(R.id.listview);
        spinner = findViewById(R.id.spnganh);
        edtMssv = findViewById(R.id.edtmssv);
        edtHoten = findViewById(R.id.edthotensv);
        radNam = findViewById(R.id.radnam);
        radNu = findViewById(R.id.radnu);
        btnThem = findViewById(R.id.btnthem);
        btnSua = findViewById(R.id.btnsua);
        btnXoa = findViewById(R.id.btnxoa);
        btnThoat = findViewById(R.id.btnthoat);
    }

    private void OnClick() {
        // su kien click cua lISTVIEW
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vt = i;
                String mssv = arrSV.get(i).mssv;
                edtMssv.setText(mssv); // dua mssv len edittext

                String tensv = arrSV.get(i).hoten;
                edtHoten.setText(tensv); // dua Ho ten len edittext

                // xu li gioi tinh
                if (arrSV.get(i).gt.equals("Nam")) {
                    radNam.setChecked(true);

                } else radNu.setChecked(true);
                // xu li gioi tinh
                //xu li chuyen nganh
                String cn = arrSV.get(i).cn;
                int spinnerPosition = adapterSp.getPosition(cn);
                spinner.setSelection(spinnerPosition);
                //xu li chuyen nganh
            }

        });

        // Button Them
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themsv();
            }
        });
        // Button Sua
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suasv();
            }
        });
        // Button Xoa
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xoasv();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question();
            }
        });


    }

    public void themsv() {
        if (ktthongtin()){
            String mssv = edtMssv.getText().toString();
            String hoten = edtHoten.getText().toString();
            String gt;
            final String cn;
            if (radNam.isChecked()) {
                gt = "Nam";
            } else gt = "Nữ";
            cn = spinner.getSelectedItem().toString();
            SINHVIEN sv = new SINHVIEN(mssv, hoten, gt, cn);
            arrSV.add(sv);
            adapterSinhVien.notifyDataSetChanged();
            Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Vui long nhap day du thong tin !", Toast.LENGTH_SHORT).show();
        }

    }

    public void suasv() {
        if(ktthongtin()){
            String mssv = edtMssv.getText().toString();
            String hoten = edtHoten.getText().toString();
            String gt;
            final String cn;
            if (radNam.isChecked()) {
                gt = "Nam";
            } else gt = "Nữ";
            cn = spinner.getSelectedItem().toString();
            arrSV.get(vt).setMssv(mssv);
            arrSV.get(vt).setHoten(hoten);
            arrSV.get(vt).setGt(gt);
            arrSV.get(vt).setCn(cn);
            adapterSinhVien.notifyDataSetChanged();
            Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Vui long nhap day du thong tin !", Toast.LENGTH_SHORT).show();
        }

    }

    public void xoasv() {

        arrSV.remove(vt);
        adapterSinhVien.notifyDataSetChanged();
        Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
    }

    public void question() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn thật sự muốn thoát");
        builder.setCancelable(false);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
    public  boolean ktthongtin(){
        if(edtHoten.getText().toString().equals("") || edtMssv.getText().toString().equals("")){
            return  false;
        } else  return  true;
    }
}