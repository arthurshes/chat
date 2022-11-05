package anonimchatguest.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ChatHolder> {
    ArrayList<String> messages;
    LayoutInflater inflater;

    public Adapter(Context context,ArrayList<String> messages) {
        this.messages = messages;
        this.inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_container_priem_message,parent,false);
        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, int position) {
String msg=messages.get(position);
holder.message.setText(msg);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
