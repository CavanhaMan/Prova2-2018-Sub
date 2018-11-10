package com.man.cavanha.androidcrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final String TABLE_ALUNOS = "Alunos";
    private DbGateway gw;

    public AlunoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean salvar(String nome, String nota){
        ContentValues cv = new ContentValues();
        cv.put("Nome", nome);
        cv.put("Nota", nota);
        return gw.getDatabase().insert(TABLE_ALUNOS, null, cv) > 0;
    }

    public List<Aluno> retornarTodos(){
        List<Aluno> alunos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Alunos", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            String nota = cursor.getString(cursor.getColumnIndex("Nota"));
            alunos.add(new Aluno(id, nome, nota));
        }
        cursor.close();
        return alunos;
    }

    public Aluno retornarUltimo(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Alunos ORDER BY ID DESC", null);
        if(cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            String nota = cursor.getString(cursor.getColumnIndex("Nota"));
            cursor.close();
            return new Aluno(id, nome, nota);
        }

        return null;
    }
}