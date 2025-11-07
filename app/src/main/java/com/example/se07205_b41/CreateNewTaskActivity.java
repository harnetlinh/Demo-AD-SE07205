package com.example.se07205_b41;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CreateNewTaskActivity extends AppCompatActivity {
    EditText edtItemName, edtQuantity, edtUnitPrice;
    Button btnSubmitCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_new_task);

        btnSubmitCreate = findViewById(R.id.btnSubmitCreate);
        edtItemName = findViewById(R.id.edtItemName);
        edtQuantity = findViewById(R.id.edtQuantity);
        edtUnitPrice = findViewById(R.id.edtUnitPrice);

        btnSubmitCreate.setOnClickListener(v -> {
            String ItemName = edtItemName.getText().toString();
            int Quantity = Integer.parseInt(edtQuantity.getText().toString());
            int UnitPrice = Integer.parseInt(edtUnitPrice.getText().toString());
            Item newItem = new Item(ItemName, Quantity, UnitPrice);
            AppData.ItemList.add(newItem);
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Thêm mới thành công");
            alertDialog.setMessage("Món đồ: " + newItem.getName() + " Số lượng: " + newItem.getQuantity() + " Đơn giá: " + newItem.getUniPrice() + "VND");
            alertDialog.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}