package com.man.cavanha.androidcrud;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class AlunoHolder extends RecyclerView.ViewHolder {

    public TextView nomeAluno;
    public TextView notaAluno;
    public ImageButton btnEditar;
    public ImageButton btnExcluir;

    public AlunoHolder(View itemView) {
        super(itemView);
        nomeAluno = (TextView) itemView.findViewById(R.id.nomeAluno);
        notaAluno = (TextView) itemView.findViewById(R.id.notaAluno);
    }
}
