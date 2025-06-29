package com.example.bt2_lab_chuong3;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> foodList;

    public FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        if (food == null) {
            return;
        }
        holder.foodImageView.setImageResource(food.getImageResId());
        holder.foodNameTextView.setText(food.getName());

        // Xử lý sự kiện click vào một item
        holder.itemView.setOnClickListener(v -> {
            // Lấy đúng đối tượng được click
            Food clickedFood = foodList.get(holder.getAdapterPosition());

            // Tạo Intent để chuyển sang DetailActivity
            Intent intent = new Intent(v.getContext(), DetailActivity.class);

            // Gửi toàn bộ đối tượng Food qua Intent bằng Parcelable
            // thay vì gửi từng giá trị riêng lẻ
            intent.putExtra("foodObject", clickedFood);

            // Bắt đầu Activity mới
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if (foodList != null) {
            return foodList.size();
        }
        return 0;
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImageView;
        TextView foodNameTextView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.foodImageView);
            foodNameTextView = itemView.findViewById(R.id.foodNameTextView);
        }
    }
}