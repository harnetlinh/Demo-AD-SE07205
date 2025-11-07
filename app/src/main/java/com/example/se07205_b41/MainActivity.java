package com.example.se07205_b41;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCreate;
    Button btnEdit;
    ListView lvTasks;
    TextView tvTotalBill;
    ArrayAdapter<Item> adapter; // kết nối danh sách với ListView (giao diện)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Kết nối tới layout có tên là activity_main
        btnCreate = findViewById(R.id.btnCreate); // Kết nối tới Button có id là btnCreate
        lvTasks = findViewById(R.id.lvTasks); // Kết nối tới ListView có id là lvTasks
        tvTotalBill = findViewById(R.id.tvTotalBill);

        btnCreate.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateNewTaskActivity.class);
            startActivity(intent);
        });

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, AppData.ItemList);
        // gắn giao diện ListView (lvTasks) với adapter
        lvTasks.setAdapter(adapter);
        adapter.notifyDataSetChanged(); // cập nhật giao diện
        tvTotalBill.setText("Tổng tiền: " + AppData.getTotalBill() + " VNĐ");

        lvTasks.setOnItemClickListener((parent, view, position, id) -> {
            Item item = AppData.ItemList.get(position);

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Please, choose your action!");
            builder.setPositiveButton("Edit", (dialog, which) -> {

                Intent intent = new Intent(MainActivity.this, EditTask.class);
                intent.putExtra("position", position);
                startActivityForResult(intent, AppData.REQUEST_EDIT_TASK);
            });
            builder.setNegativeButton("Delete", (dialog, which) -> {
                AppData.ItemList.remove(position);
                tvTotalBill.setText("Tổng tiền: " + AppData.getTotalBill() + " VNĐ");
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, item.getName() + " is deleted!", Toast.LENGTH_SHORT).show();
            });
            builder.show();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == AppData.REQUEST_EDIT_TASK && resultCode == RESULT_OK){
            tvTotalBill.setText("Tổng tiền: " + AppData.getTotalBill() + " VNĐ");
            adapter.notifyDataSetChanged();
        }
    }
}