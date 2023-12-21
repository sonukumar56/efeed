package com.example.efeed.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.efeed.R;
import com.example.efeed.model.Model1;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<Model1> issues;

    public UserAdapter(List<Model1> issues) {
        this.issues = issues;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_issue, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model1 issue = issues.get(position);
        holder.bind(issue);
    }

    @Override
    public int getItemCount() {
        return issues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView createdDate;
        private TextView closedDate;
        private TextView userName;
        private ImageView userImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            createdDate = itemView.findViewById(R.id.createdDate);
            closedDate = itemView.findViewById(R.id.closedDate);
            userName = itemView.findViewById(R.id.userName);
            userImage = itemView.findViewById(R.id.userImage);
        }

        public void bind(Model1 issue) {
            title.setText(issue.getTitle());
            createdDate.setText(issue.getCreatedAt());
            closedDate.setText(issue.getClosedAt());
            userName.setText(issue.getUser().getLogin());
            // Picasso.get().load(issue.getUser().getAvatarUrl()).into(userImageView);
        }
    }
}

