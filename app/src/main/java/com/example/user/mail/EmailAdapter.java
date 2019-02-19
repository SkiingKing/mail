package com.example.user.mail;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.mail.R;

import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder> {

    private List<EmailItem> emailsPreviewList;
    private EmailItemClicked callback;
    private Context context;

    // конструктор, принимает на вход нужный лист с данными, для дальнейшей работы с ними.
    EmailAdapter(List<EmailItem> emailsPreviewList,
                 EmailItemClicked callback, Context context) {
        this.emailsPreviewList = emailsPreviewList;
        this.callback = callback;
        this.context = context;
    }

    // тут мы должны указать layout для работы с элементами
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        // указываем лаяут
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_recycler_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);


        // добавляем слушатель кликов на все подобные лаяуты (добавится слушатель всего один раз)
        // рекомендую подробно прочесть про анонимные классы, если не понятен код ниже
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // находим позицию элемента, на оторый нажали
                int adapterPosition = holder.getAdapterPosition();
                // проверяем корректность позиции и наличие callback
                if (adapterPosition != RecyclerView.NO_POSITION && callback != null) {
                    // делегируем работу с данными через callback.
                    // В адаптере не должно быть лишней логики.
                    callback.itemClickedCallback(adapterPosition);
                }
            }
        });
        return holder;
    }

    // метод вызывается для отрисовки нового экземпляра.
    // Будет вызван у каждого нового элемента.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        // получаем текущий элемент у нашего листа
        final EmailItem item = emailsPreviewList.get(position);
        if (item.getUserImg() != null && !item.getUserImg().isEmpty()) {
            Glide.with(context).load(item.getUserImg()).into(holder.user_image);
        } else {
            String userImgDefault = "http://simpleicon.com/wp-content/uploads/user1.png";
            Glide.with(context).load(userImgDefault).into(holder.user_image);
        }
        // проверка наших объектов на null или пустую строку
        if (item.getTitle() != null && !item.getTitle().isEmpty()) {
            holder.titleTv.setText(item.getTitle());
        } else {
            // в случае пустой или null строки в объекте, ставим вместо него другой текст
            holder.titleTv.setText(R.string.email_title_placeholder);
        }
        if (item.getSecondtext() != null && !item.getSecondtext().isEmpty()) {
            holder.subTitleTv.setText(item.getSecondtext());
        } else {
            // в случае пустой или null строки в объекте, прячем textview с текущего элемента
            holder.subTitleTv.setVisibility(View.GONE);
        }
        if (item.getText() != null && !item.getText().isEmpty()) {
            holder.contentTv.setText(item.getText());
        } else {
            holder.contentTv.setVisibility(View.GONE);
        }

        if (item.getDate() != null && !item.getDate().isEmpty()) {
            holder.dateTv.setText(item.getDate());
        }
    }

    // метод вызывается для получения максимального количества элементов
    @Override
    public int getItemCount() {
        if (emailsPreviewList == null) return 0;
        return emailsPreviewList.size();
    }

    interface EmailItemClicked {
        void itemClickedCallback(int itemPosition);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, subTitleTv, contentTv, dateTv;
        ImageView user_image;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.title_text);
            subTitleTv = itemView.findViewById(R.id.subtitle_text);
            contentTv = itemView.findViewById(R.id.content_text);
            dateTv = itemView.findViewById(R.id.data_text);
            user_image=itemView.findViewById(R.id.user_image);
        }
    }
}