package com.example.healthhubheroes;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

    private List<Patient> patientList;

    public PatientAdapter(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_patient, parent, false);
        return new PatientViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        Patient patient = patientList.get(position);
        holder.textPatientName.setText(patient.getFirstName().substring(0, 1).toUpperCase() + " " + patient.getLastName().substring(0, 1).toUpperCase());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            holder.textPatientAge.setText("Age: " + patient.getAge());
        }

        // Set the initial for the avatar
        if (!patient.getFirstName().isEmpty()) {
            holder.avatarIcon.setText(patient.getFirstName().substring(0, 1).toUpperCase() + " " + patient.getLastName().substring(0, 1).toUpperCase());
        }
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    static class PatientViewHolder extends RecyclerView.ViewHolder {
        TextView avatarIcon, textPatientName, textPatientAge;
        ImageView iconEdit;

        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarIcon = itemView.findViewById(R.id.avatarIcon);
            textPatientName = itemView.findViewById(R.id.textPatientName);
            textPatientAge = itemView.findViewById(R.id.textPatientAge);
            iconEdit = itemView.findViewById(R.id.iconEdit);
        }
    }
}
