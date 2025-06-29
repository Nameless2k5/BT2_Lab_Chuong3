package com.example.bt2_lab_chuong3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Ánh xạ View
        ImageView detailImageView = findViewById(R.id.detailImageView);
        TextView detailTextView = findViewById(R.id.detailTextView);
        Button orderButton = findViewById(R.id.orderButton);

        // Nhận đối tượng Food từ Intent
        Food food = getIntent().getParcelableExtra("foodObject");

        // Kiểm tra nếu đối tượng không null
        if (food != null) {
            // Gán dữ liệu lên View
            detailImageView.setImageResource(food.getImageResId());

            // Định dạng giá tiền
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            String formattedPrice = currencyFormat.format(food.getPrice());

            String detailText = "Tên món ăn: " + food.getName() +
                    "\nMô tả: " + food.getDescription() +
                    "\nGiá: " + formattedPrice;
            detailTextView.setText(detailText);

            // Xử lý sự kiện click cho nút "Gọi món"
            orderButton.setOnClickListener(v -> {
                Toast.makeText(DetailActivity.this, "Đã gọi món: " + food.getName(), Toast.LENGTH_SHORT).show();
            });
        }
    }
}