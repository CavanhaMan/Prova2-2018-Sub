package com.man.cavanha.androidcrud;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;


public class AlunoAdapter extends RecyclerView.Adapter<AlunoHolder> {

    private final List<Aluno> alunos;

    public AlunoAdapter(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public AlunoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AlunoHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista, parent, false));
    }

    @Override
    public void onBindViewHolder(AlunoHolder holder, int position) {
        holder.nomeAluno.setText(alunos.get(position).getNome());
        holder.notaAluno.setText(alunos.get(position).getNota());
    }

    @Override
    public int getItemCount() {
        return alunos != null ? alunos.size() : 0;
    }

    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
        notifyItemInserted(getItemCount());
    }
    /*adiciona o aluno na coleção in-memory e notifica a RecyclerView que ela deve se atualizar*/
}
