package com.example.se07205_b41;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditTask extends AppCompatActivity {

    Button btnSubmitEdit;
    EditText edtTaskContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_task);

        btnSubmitEdit = findViewById(R.id.btnSubmitEdit);
        edtTaskContent = findViewById(R.id.edtTaskContent);

        Intent intent = getIntent(); // Lấy gía trị từ intent nếu có
        // nhận giá trị "position" từ intent, nếu không có thì set giá trị đó = -1
        int position = intent.getIntExtra("position", -1);
        if (position > -1){ // Nếu giá trị đó > -1 (tồn tại) thì set giá trị đó vào edtTaskContent
            edtTaskContent.setText(AppData.TaskList.get(intent.getIntExtra("position", -1)));
        }else{
            // Nếu không có thì thông báo và kết thúc activity (đưa về activity trước đó)
            Toast.makeText(this, "No task selected!", Toast.LENGTH_SHORT).show();
            finish(); // kết thúc activity (hành động có lỗi xảy ra)
        }

        btnSubmitEdit.setOnClickListener(v -> {
            String content = edtTaskContent.getText().toString();
            AppData.TaskList.set(position, content);
            Toast.makeText(this, "Input in " + AppData.AppName + " : "  + content, Toast.LENGTH_LONG).show();
            setResult(RESULT_OK); // báo về kết quả thành công (RESULT_OK)
            finish(); // kết thúc activity (đã hoàn thành)
        });


    }
}