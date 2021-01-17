package com.release.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.tv_date.setText(currentNote.getDate());
        holder.tv_description.setText(currentNote.getDescription());
        holder.tv_priority.setBackgroundColor((currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
    public void setNotes(List<Note>notes){
        this.notes = notes;
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position){
        return notes.get(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView tv_date;
        private TextView tv_description;
       // private TextView tv_priority;
        private RelativeLayout tv_priority;

        public NoteHolder(View itemView){
            super(itemView);
            tv_date = itemView.findViewById(R.id.date);
            tv_description = itemView.findViewById(R.id.text);
            tv_priority = itemView.findViewById(R.id.priority);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener !=null && position !=RecyclerView.NO_POSITION){
                        listener.onItemClick(notes.get(position));
                    }
                }
            });
        }


    }
    public interface OnItemClickListener{
        void onItemClick(Note note);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
