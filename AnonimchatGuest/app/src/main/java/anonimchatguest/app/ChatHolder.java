package anonimchatguest.app;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ChatHolder extends RecyclerView.ViewHolder {
    TextView message;
    public ChatHolder(View itemView){
        super(itemView);
        message=itemView.findViewById(R.id.priem_message);
    }
}
